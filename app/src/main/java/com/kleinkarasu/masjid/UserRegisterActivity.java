package com.kleinkarasu.masjid;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserRegisterActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private Button btnRegister;
    private EditText etName;
    private EditText etUsername;
    private Spinner spnrRole;
    private EditText etEmail;
    private EditText etPassword;

    private String name, username, role;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        btnRegister = (Button) findViewById(R.id.btn_register);
        etName = (EditText) findViewById(R.id.et_nama);
        etUsername = (EditText) findViewById(R.id.et_username);
        spnrRole = (Spinner) findViewById(R.id.spnr_role);
        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);

        spnrRole.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.roles_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnrRole.setAdapter(adapter);

        btnRegister.setOnClickListener(this);

        progressDialog = new ProgressDialog(this);
    }

    private void registerUser() {
        name = etName.getText().toString();
        username = etUsername.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if(TextUtils.isEmpty(username)) {
            //email is empty
            Toast.makeText(this, "Please enter username", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(name)) {
            //email is empty
            Toast.makeText(this, "Please enter name", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(email)) {
            //email is empty
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)) {
            //password is empty
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
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
                            myRef.child("roles").child(user.getUid()).setValue(role);
                            myRef.child("users").child(user.getUid()).setValue(newUser);

                            finish();
                            startActivity(new Intent(getApplicationContext(), WargaActivity.class));
                        }
                        else {
                            Toast.makeText(UserRegisterActivity.this, "Could not register... please try again", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void registerTakmir() {
        String name = etName.getText().toString();
        String username = etUsername.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if(TextUtils.isEmpty(name)) {
            //email is empty
            Toast.makeText(this, "Please enter name", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(username)) {
            //email is empty
            Toast.makeText(this, "Please enter username", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(email)) {
            //email is empty
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)) {
            //password is empty
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(role)) {
            Toast.makeText(this, "Please select role", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent i = new Intent(getApplicationContext(), MasjidFormActivity.class);
        Bundle extras = new Bundle();
        extras.putString("EMAIL", email);
        extras.putString("PASSWORD", password);
        extras.putString("NAME", name);
        extras.putString("USERNAME", username);
        extras.putString("ROLE", role);
        i.putExtras(extras);
        startActivity(i);
    }

    @Override
    public void onClick(View view) {
        if(view == btnRegister) {
            if(role.equals("warga")) {
                registerUser();
            }
            else if(role.equals("takmir")) {
                registerTakmir();
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        role = parent.getItemAtPosition(pos).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
