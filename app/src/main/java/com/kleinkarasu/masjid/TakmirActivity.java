package com.kleinkarasu.masjid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TakmirActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private DatabaseReference myRef;

    private String namaMasjid, kota, kecamatan, alamat;

    private TextView tvNamaMasjid, tvKotaKecamatan, tvAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takmir);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        myRef = FirebaseDatabase.getInstance().getReference();
        myRef.child("users").child(user.getUid()).child("masjid").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Masjid masjid = dataSnapshot.getValue(Masjid.class);
                tvNamaMasjid.setText(masjid.getNamaMasjid());
                tvKotaKecamatan.setText(masjid.getKota()+", "+masjid.getKecamatan());
                tvAlamat.setText(masjid.getAlamat());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        tvNamaMasjid = (TextView) findViewById(R.id.tv_namamasjid);
        tvKotaKecamatan = (TextView) findViewById(R.id.tv_kotakecamatan);
        tvAlamat = (TextView) findViewById(R.id.tv_alamat);

        setMasjidDetails();
    }

    private void setMasjidDetails() {
        tvNamaMasjid.setText(namaMasjid);
        tvKotaKecamatan.setText(kota+", "+kecamatan);
        tvAlamat.setText(alamat);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logout) {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }
        return super.onContextItemSelected(item);
    }
}