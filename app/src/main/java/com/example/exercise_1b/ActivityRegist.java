package com.example.exercise_1b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ActivityRegist extends AppCompatActivity {

    //Deklarasi variabel dengan tipe data EditText
    EditText edtNama, edtEmail, edtPassword, edtrepass;

    //Deklarasi variabel dengan tipe data Floating action button
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        edtNama = findViewById(R.id.edName);
        edtEmail = findViewById(R.id.edEmail);
        edtPassword = findViewById(R.id.edPass);
        edtrepass = findViewById(R.id.edrepas);
        fab = findViewById(R.id.fabSimpan);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Membuat kondisi untuk mengecek apakah EditText kosong atau tidak
                if (edtNama.getText().toString().isEmpty() ||
                        edtEmail.getText().toString().isEmpty() ||
                        edtPassword.getText().toString().isEmpty() ||
                        edtrepass.getText().toString().isEmpty())
                {
                    //Menampilkan pesan notifikasi jika seluruh EditText wajib di isi
                    Snackbar.make(view, "Wajib isi seluruh data!!!", Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    //Membuat kondisi untuk mengecek apakah isi dari EditText password dan EditText repassword
                    //sama atau tidak
                    if (edtPassword.getText().toString().equals(edtrepass.getText().toString()))
                    {
                        //Menampilkan pesan notifikasi jika pendaftaran berhasil
                        Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil!",
                                Toast.LENGTH_LONG).show();

                        //Method untuk langsung menuju ke activity hasil
                        Intent i = new Intent(getApplicationContext(), ActivityHasil.class);
                        startActivity(i);
                    }
                    else
                    {
                        //Menampilkan pesan bahwa isi dari EditText password dan EditText Repassword
                        //tidak sama
                        Snackbar.make(view, "Password dan Repassword harus sama!",
                                Snackbar.LENGTH_LONG).show();
                    }
        };

    }
});}}