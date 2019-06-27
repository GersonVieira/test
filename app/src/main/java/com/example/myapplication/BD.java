package com.example.myapplication;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BD {
    private static DatabaseReference firebase;
    Aluno aluno;
    boolean a=true;
    public BD(){
        firebase=FirebaseDatabase.getInstance().getReference();
    }
    public  void iniciarBD(){
        new BD();
    }
    public  void salvarPontos(String idPessoa, int pontos){
        firebase.child(idPessoa).child("pontuacao").setValue(pontos);
    }
    public Aluno recuperarAluno(){

        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return null;
    }

}
