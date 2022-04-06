package com.example.countryapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    MainActivity mainActivity;
    List<CountryDatum> modellist;

    public RecyclerAdapter(MainActivity mainActivity, List<CountryDatum> modelList) {

        this.mainActivity=mainActivity;
        this.modellist=modelList;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mainActivity).inflate(R.layout.country_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        holder.name.setText(modellist.get(position).getName());
        Glide.with(mainActivity).load(modellist.get(position).getFlags().getPng()).into(holder.flags);
    }

    @Override
    public int getItemCount() {
        return modellist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView flags;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.name);
            flags=itemView.findViewById(R.id.flags);
        }
    }
}
