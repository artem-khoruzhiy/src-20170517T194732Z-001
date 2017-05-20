package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import sample.interfaces.impls.CollectionDataBd;
import sample.object.Smeta;


import javax.swing.*;
import java.io.File;

public class Controller {

    private CollectionDataBd addressBookImpl = new CollectionDataBd();

    @FXML
    private TableView tableSmeta;

    @FXML
    private TableColumn<Smeta, String> columnName;

    @FXML
    private TableColumn<Smeta, String> columnCena;

    @FXML
    private void initialize() {
        columnName.setCellValueFactory(new PropertyValueFactory<Smeta, String>("name"));
        columnCena.setCellValueFactory(new PropertyValueFactory<Smeta, String>("cena"));

        addressBookImpl.fillTestData();

        tableSmeta.setItems(addressBookImpl.getPersonList());

        //updateCountLabel();
    }

   /* private void updateCountLabel() {
        labelCount.setText("Количество записей: " + addressBookImpl.getPersonList().size());
    }*/






    public void OpenFile(ActionEvent actionEvent) {
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();
        }
    }
}
