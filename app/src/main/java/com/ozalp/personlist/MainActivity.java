package com.ozalp.personlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.ozalp.instagram.R;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    TextView nameText;
    TextView surnameText;
    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.list){
            Intent intent = new Intent(getApplicationContext(), RecycleView.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void init(){
        nameText = findViewById(R.id.nameText);
        surnameText = findViewById(R.id.surnameText);
        firestore = FirebaseFirestore.getInstance();
    }

    public void save(View view){

        String name = nameText.getText().toString();
        System.out.println(name);

        String surname = surnameText.getText().toString();
        System.out.println(surname);
        String fullName = name + " " + surname;

        Map map = new HashMap();
        map.put("fullname",fullName);
        System.out.println(fullName);
        try {
            firestore.collection("People").document(fullName).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
                    nameText.setText("");
                    surnameText.setText("");
                }
            });
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}