package com.kleinkarasu.masjid;

/**
 * Created by Muhammad Azzam on 12/10/2017.
 */

public class Masjid {
    private String namaMasjid;
    private String kota;
    private String kecamatan;
    private String alamat;

    public Masjid(){}

    public Masjid(String namaMasjid, String kota, String kecamatan, String alamat) {
        this.namaMasjid = namaMasjid;
        this.kota = kota;
        this.kecamatan = kecamatan;
        this.alamat = alamat;
    }

    public String getNamaMasjid() {
        return namaMasjid;
    }

    public void setNamaMasjid(String namaMasjid) {
        this.namaMasjid = namaMasjid;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
