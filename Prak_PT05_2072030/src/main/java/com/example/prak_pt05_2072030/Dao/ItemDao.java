package com.example.prak_pt05_2072030.Dao;

import com.example.prak_pt05_2072030.Model.Item;
import com.example.prak_pt05_2072030.Model.Kategori;
import com.example.prak_pt05_2072030.Utility.JDBCUtility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDao implements DaoInterface<Item>{
    @Override
    public ObservableList<Item> getData() {
        ObservableList<Item> iList;
        iList = FXCollections.observableArrayList();

        Connection conn = JDBCUtility.getConnection();
        String query = "SELECT i.idItem, i.nama, i.price, i.description, k.idKategori, k.nama AS namaKategori FROM item i JOIN kategori k ON i.kategori_idKategori = k.idKategori;";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt("idItem");
                String nama = result.getString("nama");
                double price = result.getDouble("price");
                String description = result.getString("description");
                int idKategori = result.getInt("idKategori");
                String namaKategori = result.getString("namaKategori");
                Kategori k = new Kategori(idKategori, namaKategori);
                Item i = new Item(id, nama, price, description, k);
                iList.add(i);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return iList;
    }

    @Override
    public void addData(Item data) {
        Connection conn = JDBCUtility.getConnection();
        String query = "INSERT INTO item(idItem, nama, price, description, kategori_idKategori) values(?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, data.getIdItem());
            ps.setString(2, data.getNama());
            ps.setDouble(3,data.getPrice());
            ps.setString(4,data.getDescription());
            ps.setInt(5,data.getKategori_idKategori().getIdKategori());
            int result = ps.executeUpdate();
            if (result > 0) {
                System.out.println("add item successfully");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteData(Item data) {
        Connection conn = JDBCUtility.getConnection();
        String query = "DELETE FROM item WHERE idItem = ?";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, data.getIdItem());
            int result = ps.executeUpdate();
            if (result > 0) {
                System.out.println("delete successfully");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateData(Item data) {
        Connection conn = JDBCUtility.getConnection();
        String query = "UPDATE item SET nama = ?, price = ?, description = ?, kategori_idKategori = ? WHERE idItem = ?;";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, data.getNama());
            ps.setDouble(2, data.getPrice());
            ps.setString(3, data.getDescription());
            ps.setInt(4, data.getKategori_idKategori().getIdKategori());
            ps.setInt(5, data.getIdItem());
            int result = ps.executeUpdate();
            if (result > 0) {
                System.out.println("update successfully");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
