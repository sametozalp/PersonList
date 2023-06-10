package com.ozalp.personlist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.ozalp.instagram.R;
import com.ozalp.instagram.databinding.ActivityRecycleViewBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import androidx.recyclerview.widget.LinearLayoutManager;


public class RecycleView extends AppCompatActivity {

    View recyclerView;
    FirebaseFirestore firestore;
    List list;
    LAdapter lAdapter;
    ActivityRecycleViewBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecycleViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        recyclerView = binding.recyclerView;
        firestore = FirebaseFirestore.getInstance();
        list = new ArrayList();
        getData();

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        lAdapter = new LAdapter(list);
        binding.recyclerView.setAdapter(lAdapter);
    }

    public void getData(){
        firestore.collection("People").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                Map<String, Object> data = null;
                if (!queryDocumentSnapshots.isEmpty()){
                    for (DocumentSnapshot document : queryDocumentSnapshots) {
                        data = document.getData();
                        System.out.println(data);
                    }
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }

}