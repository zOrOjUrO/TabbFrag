package com.scratch.tabbfrag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class BListAdapter extends RecyclerView.Adapter<BListAdapter.ViewHolder> {


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryTitle, categorySub;
        MaterialButton availability;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryTitle = itemView.findViewById(R.id.category_title);
            categorySub = itemView.findViewById(R.id.category_sub);
            availability = itemView.findViewById(R.id.availability_ind);
        }
    }

    ArrayList<BDataModel> data = new ArrayList<>();

    public BListAdapter(ArrayList<BDataModel> data) {
        this.data = data;
    }


    @NonNull
    @Override
    public BListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_item, null));
    }

    @Override
    public void onBindViewHolder(@NonNull BListAdapter.ViewHolder holder, int position) {
        holder.categoryTitle.setText(data.get(position).title);
        holder.categorySub.setText(data.get(position).sub);
        if(!(data.get(position).availability)){
            holder.availability.setText("Not Available");
            holder.availability.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.availability_negative,0);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
