package com.ozalp.personlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ozalp.instagram.R;
import com.ozalp.instagram.databinding.RowBinding;

import java.util.ArrayList;
import java.util.List;

public class LAdapter extends RecyclerView.Adapter<LAdapter.Holder> {

    List list = new ArrayList();
    public LAdapter(List list){
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowBinding rowBinding = RowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new Holder(rowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.rowBinding.row.setText(list.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        RowBinding rowBinding;
        public Holder(@NonNull RowBinding rowBinding) {
            super(rowBinding.getRoot());
            this.rowBinding = rowBinding;
        }
    }
}
