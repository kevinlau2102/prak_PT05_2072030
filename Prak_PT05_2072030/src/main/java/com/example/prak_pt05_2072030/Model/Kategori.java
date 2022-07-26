package com.example.prak_pt05_2072030.Model;

public class Kategori {
    private int idKategori;
    private String nama;

    public Kategori(int idKategori, String nama) {
        this.idKategori = idKategori;
        this.nama = nama;
    }

    public int getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(int idKategori) {
        this.idKategori = idKategori;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    @Override
    public String toString() {
        return nama;
    }
}
