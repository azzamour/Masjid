package com.kleinkarasu.masjid;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MasjidFormActivity extends AppCompatActivity implements View.OnClickListener {

    String email, password, name, username, role, namaMasjid, kota, kecamatan, alamat;

    EditText etNama, etKota, etKecamatan, etAlamat;
    Button btnRegister;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masjid_form);

        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        Bundle extras = getIntent().getExtras();
        email = extras.getString("EMAIL");
        password = extras.getString("PASSWORD");
        name = extras.getString("NAME");
        username = extras.getString("USERNAME");
        role = extras.getString("ROLE");

        etNama = (EditText) findViewById(R.id.et_nama);
        etKota = (EditText) findViewById(R.id.et_kota);
        etKecamatan = (EditText) findViewById(R.id.et_kecamatan);
        etAlamat = (EditText) findViewById(R.id.et_alamat);
        btnRegister = (Button) findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);
    }

    private void registerUser() {
        namaMasjid = etNama.getText().toString();
        kota = etKota.getText().toString();
        kecamatan = etKecamatan.getText().toString();
        alamat = etAlamat.getText().toString();

        if(TextUtils.isEmpty(namaMasjid)) {
            //email is empty
            Toast.makeText(this, "Please enter nama masjid", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(kota)) {
            //password is empty
            Toast.makeText(this, "Please enter kota", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(kecamatan)) {
            //password is empty
            Toast.makeText(this, "Please enter kecamatan", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(alamat)) {
            //password is empty
            Toast.makeText(this, "Please enter alamat", Toast.LENGTH_SHORT).show();
            return;
        }

        //show progress dialog
        progressDialog.setMessage("Registering User...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()) {
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            User newUser = new User(name, username);
                            Masjid masjid = new Masjid(namaMasjid, kota, kecamatan, alamat);
                            myRef.child("roles").child(user.getUid()).setValue(role);
                            myRef.child("users").child(user.getUid()).setValue(newUser);
                            myRef.child("users").child(user.getUid()).child("masjid").setValue(masjid);

                            finish();
                            startActivity(new Intent(getApplicationContext(), TakmirActivity.class));
                        }
                        else {
                            Toast.makeText(MasjidFormActivity.this, "Could not register... please try again", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if(view == btnRegister) {
            registerUser();
        }
    }
}
