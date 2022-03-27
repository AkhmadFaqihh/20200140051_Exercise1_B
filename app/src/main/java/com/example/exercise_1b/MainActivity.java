package com.example.exercise_1b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Deklarasi variabel untuk button
    Button btnLogin;

    //Deklarasi variabel untuk EditText
    EditText ednama, edpassword;

    //Deklarasi variabel untuk menyimpan email dan password
    String nama, password;

    //Deklarasi variabel untuk membuka layout pendaftaran
    TextView regist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnLogin dengan komponen button pada layout
        btnLogin = findViewById(R.id.btSignin);

        //Menghubungkan variabel ednama dengan komponen button pada layout
        ednama = findViewById(R.id.edNama);

        //Menghubungkan variabel edpassword dengan komponen button pada layout
        edpassword = findViewById(R.id.edPassword);

        //Menghubungkan variabel regist dengan komponen button pada layout
        regist = findViewById(R.id.mnRegister);

        //Membuat fungsi onclick pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Menyimpan input user di edittext email kedalam variabel nama
                nama = ednama.getText().toString();

                //Menyimpan input user di edittext password kedalam variabel password
                password = edpassword.getText().toString();

                //Mengset email yang benar
                String email = "faqih";

                //Mengset password yang benar
                String pass = "geporcity";

                //Mengecek apakah edittext email dan password terdapat isi atau tidak
                if (nama.isEmpty() || password.isEmpty()) {

                    //Membuat variabel toast dan menampilkan pesan "edittext tidak boleh kosong"
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Nama dan Password tidak boleh kosong!!!",
                            Toast.LENGTH_LONG);
                    ednama.setError("Email tidak boleh kosong!");
                    edpassword.setError("Password tidak boleh kosong!");

                    //Menampilkan Toast
                    t.show();

                } else if (!nama.equals(email) && password.equals(pass)) {

                        Toast t = Toast.makeText(getApplicationContext(),
                                "Email salah",
                                Toast.LENGTH_LONG);
                    //Menampilkan Toast
                    t.show();

                    } else if (nama.equals(email) && !password.equals(pass)) {

                        Toast t = Toast.makeText(getApplicationContext(),
                                "Password salah",
                                Toast.LENGTH_LONG);
                    //Menampilkan Toast
                    t.show();

                    } else if (!nama.equals(email) && !password.equals(pass)) {

                        Toast t = Toast.makeText(getApplicationContext(),
                                "Email dan Password salah",
                                Toast.LENGTH_LONG);
                    //Menampilkan Toast
                    t.show();

                    }else {

                    //Mengecek apakah isi dari email dan password anda sudah sama dengan email dan
                    // password yang sudah di set

                    if (nama.equals(email) && password.equals(pass)) {
                        //membuat variabel toast dan menampilkan pesan "Login sukses"
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Sukses",
                                Toast.LENGTH_LONG);

                        //Menampilkan toast
                        t.show();

                        //Membuat objek bundle
                        Bundle b = new Bundle();

                        //Memasukkan value dari variabel nama dengan kunci "a" dan
                        // dimasukkan kedalam bundle
                        b.putString("a", nama.trim());

                        //Memasukkan value dari variabel password dengan kunci "b" dan
                        // dimasukkan kedalam bundle
                        b.putString("b", password.trim());

                        //Membuat objek intent berpindah activity dari main activity ke activityHasil
                        Intent i = new Intent(getApplicationContext(), ActivityHasil.class);

                        //Memasukkan bundle kedalam intent untuk dikirimkan ke ActivityHasil
                        i.putExtras(b);

                        //Berpindah ke ActivityHasil
                        startActivity(i);

                    } else {
                    //Membuat variabel toast dan membuat toast dan menampilkan pesan login gagal

                    Toast t = Toast.makeText(getApplicationContext(),
                            "Login Gagal",
                            Toast.LENGTH_LONG);
                    //Menampilkan Toast
                    t.show();
                    }
                }
            }
        });
        regist.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, ActivityRegist.class);
                startActivity(intent);
            }
        });
    }


    ;}
