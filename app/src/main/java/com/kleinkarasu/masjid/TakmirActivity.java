package com.kleinkarasu.masjid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}