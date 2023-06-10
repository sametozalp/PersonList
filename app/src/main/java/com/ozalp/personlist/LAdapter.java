package com.ozalp.personlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.ozalp.instagram.R;
import com.ozalp.instagram.databinding.RowBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LAdapter extends RecyclerView.Adapter<LAdapter.Holder> {

    ArrayList<String> list;
    public LAdapter (ArrayList<String> list){
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
        System.out.println(list);
        holder.rowBinding.row.setText(list.get(position));
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
