package com.scratch.tabbfrag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AListAdapter extends RecyclerView.Adapter<AListAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(ADataModel item);
    }

    private ArrayList<ADataModel> data = new ArrayList<>();
    private OnItemClickListener listener = null;

    public AListAdapter(ArrayList<ADataModel> data) {
        this.data = data;
    }

    public AListAdapter(ArrayList<ADataModel> data, OnItemClickListener clickListener){
        this.data = data;
        this.listener = clickListener;
    }

    //TODO: Implement Availability Factor
    //TODO: Improve OnItemCLickListener by transfering listener to onCreateView
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView productTitle, productSub, productMRP, productPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productTitle = itemView.findViewById(R.id.product_title);
            productSub = itemView.findViewById(R.id.product_sub);
            productMRP = itemView.findViewById(R.id.product_price);
            productPrice = itemView.findViewById(R.id.product_offer_price);
        }

        public void bind(ADataModel aDataModel, OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(aDataModel);
                }
            });
        }
    }

    @NonNull
    @Override
    public AListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.products_item, null));
    }

    @Override
    public void onBindViewHolder(@NonNull AListAdapter.ViewHolder holder, int position) {

        holder.productTitle.setText(data.get(position).title);
        holder.productSub.setText(data.get(position).sub);
        holder.productMRP.setText(String.valueOf(data.get(position).mrp));
        holder.productPrice.setText(String.valueOf(data.get(position).price));
        //binding onClickListener
        holder.bind(data.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
