package com.example.pertemuan3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class adapterPahlawan extends RecyclerView.Adapter<adapterPahlawan.ViewHolder> {

    private ArrayList<modelPahlawan> modelPahlawans;
    private Context context;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pahlawan,parent,false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Glide.with(context).load(getModelPahlawans().get(position).getHeroImages()).into(holder.ivPahlawan);
        holder.tvNama.setText(getModelPahlawans().get(position).getHeroNames());
        holder.tvDetails.setText(getModelPahlawans().get(position).getHeroDetails());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(modelPahlawans.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return getModelPahlawans().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPahlawan;
        private TextView tvNama, tvDetails;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPahlawan = itemView.findViewById(R.id.ivPahlawan);
            tvNama = itemView.findViewById(R.id.tvPahlawan);
            tvDetails = itemView.findViewById(R.id.tv_deskripsi);
        }
    }

    public ArrayList<modelPahlawan> getModelPahlawans() {
        return modelPahlawans;
    }

    public void setModelPahlawans(ArrayList<modelPahlawan> modelPahlawans) {
        this.modelPahlawans = modelPahlawans;
    }

    public adapterPahlawan(Context context) {
        this.context = context;
    }
    public interface OnItemClickCallback {
        void onItemClicked(modelPahlawan data);
    }
}

