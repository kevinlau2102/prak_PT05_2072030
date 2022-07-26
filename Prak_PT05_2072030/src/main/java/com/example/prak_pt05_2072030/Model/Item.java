package com.example.prak_pt05_2072030.Model;

public class Item {
    private int idItem;
    private String nama;
    private double price;
    private String description;
    private Kategori kategori_idKategori;

    public Item(int idItem, String nama, double price, String description, Kategori kategori_idKategori) {
        this.idItem = idItem;
        this.nama = nama;
        this.price = price;
        this.description = description;
        this.kategori_idKategori = kategori_idKategori;
    }
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Kategori getKategori_idKategori() {
        return kategori_idKategori;
    }

    public void setKategori_idKategori(Kategori kategori_idKategori) {
        this.kategori_idKategori = kategori_idKategori;
    }
}
