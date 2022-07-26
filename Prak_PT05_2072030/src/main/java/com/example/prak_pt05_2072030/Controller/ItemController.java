package com.example.prak_pt05_2072030.Controller;

import com.example.prak_pt05_2072030.Dao.ItemDao;
import com.example.prak_pt05_2072030.MainApplication;
import com.example.prak_pt05_2072030.Model.Item;
import com.example.prak_pt05_2072030.Model.Kategori;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;

public class ItemController {
    @FXML
    private TableView<Item> table;
    @FXML
    private TableColumn<Integer, Item> idCol;
    @FXML
    private TableColumn<String, Item> namaCol;
    @FXML
    private TableColumn<Double, Item> priceCol;
    @FXML
    private TableColumn<Kategori, Item> kategoriCol;
    @FXML
    private TextField idItem;
    @FXML
    private TextField namaItem;
    @FXML
    private TextField priceItem;
    @FXML
    private TextArea descItem;
    @FXML
    private ComboBox<Kategori> kategoriItem;
    @FXML
    private Button addButton;
    @FXML
    private Button resetButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button updateButton;
    @FXML
    private MenuItem showKategori;
    @FXML
    private MenuItem close;
    @FXML
    private Label id;

    private ObservableList<Item> iList;
    private ItemDao itemDao;
    private KategoriController kController;
    private FXMLLoader fxmlLoader;
    private Stage stage;

    public void initialize() throws IOException {
        fxmlLoader = new FXMLLoader(MainApplication.class.getResource("kategori-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage = new Stage();
        stage.setTitle("Category Management");
        stage.setScene(scene);
        kController = fxmlLoader.getController();
        kategoriItem.setItems(kController.kList);
        showKategori.setAccelerator(KeyCombination.keyCombination("Alt+F2"));
        close.setAccelerator(KeyCombination.keyCombination("Alt+X"));
        showData();
    }
    public void showData() {
        itemDao = new ItemDao();
        iList = itemDao.getData();
        table.setItems(iList);
        idCol.setCellValueFactory(new PropertyValueFactory<>("idItem"));
        namaCol.setCellValueFactory(new PropertyValueFactory<>("nama"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        kategoriCol.setCellValueFactory(new PropertyValueFactory<>("kategori_idKategori"));
    }
    public void showKategori() {
        stage.showAndWait();
        kategoriItem.setItems(kController.kList);
    }
    public void close() {
        id.getScene().getWindow().hide();
    }
    public void reset() {
        idItem.clear();
        namaItem.clear();
        priceItem.clear();
        descItem.clear();
        kategoriItem.setValue(null);
        idItem.setDisable(false);
        addButton.setDisable(false);
    }
    public void addItem() {
        if(idItem.getText().isEmpty() || namaItem.getText().isEmpty() || priceItem.getText().isEmpty() || descItem.getText().isEmpty() || kategoriItem.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Please fill in all the field",ButtonType.OK);
            alert.showAndWait();
        } else {
            itemDao.addData(new Item(Integer.parseInt(idItem.getText()), namaItem.getText(), Double.parseDouble(priceItem.getText()), descItem.getText(), kategoriItem.getValue()));
            showData();
            reset();
        }
    }
    public void getSelectedItem() {
        idItem.setText(String.valueOf(table.getSelectionModel().getSelectedItem().getIdItem()));
        namaItem.setText(table.getSelectionModel().getSelectedItem().getNama());
        priceItem.setText(String.valueOf(table.getSelectionModel().getSelectedItem().getPrice()));
        descItem.setText(table.getSelectionModel().getSelectedItem().getDescription());
        kategoriItem.setValue(table.getSelectionModel().getSelectedItem().getKategori_idKategori());
        idItem.setDisable(true);
        addButton.setDisable(true);
    }
    public void updateItem() {
        itemDao.updateData(new Item(Integer.parseInt(idItem.getText()), namaItem.getText(), Float.parseFloat(priceItem.getText()), descItem.getText(), kategoriItem.getValue()));
        showData();
        reset();
    }
    public void deleteItem() {
        itemDao.deleteData(table.getSelectionModel().getSelectedItem());
        showData();
        reset();
    }

}