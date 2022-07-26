package com.example.prak_pt05_2072030.Dao;

import com.example.prak_pt05_2072030.Model.Kategori;
import com.example.prak_pt05_2072030.Utility.JDBCUtility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KategoriDao implements DaoInterface<Kategori>{
    @Override
    public ObservableList<Kategori> getData() {
        ObservableList<Kategori> kList;
        kList = FXCollections.observableArrayList();

        Connection conn = JDBCUtility.getConnection();
        String query = "SELECT * FROM kategori";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int id = result.getInt("idKategori");
                String nama = result.getString("nama");
                Kategori k = new Kategori(id, nama);
                kList.add(k);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return kList;
    }

    @Override
    public void addData(Kategori data) {
        Connection conn = JDBCUtility.getConnection();
        String query = "INSERT INTO kategori(idKategori, nama) values(?,?)";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, data.getIdKategori());
            ps.setString(2, data.getNama());
            int result = ps.executeUpdate();
            if (result > 0) {
                System.out.println("add kategori successfully");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteData(Kategori data) {

    }

    @Override
    public void updateData(Kategori data) {

    }
}
