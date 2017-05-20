package sample;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.interfaces.impls.CollectionDataBd;

import javax.imageio.IIOParam;
import java.sql.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Сметный калькулятор");
        primaryStage.setMaximized(true);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        testData();
    }




    private void testData() {
      CollectionDataBd addressBook = new CollectionDataBd();
      addressBook.fillTestData();
     addressBook.print();
    }





    private static Connection connectionDb() {
        Connection dbConnection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/smeta", "root", "root");
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

   private static void getDataTable() throws SQLException {
        String[] name;
        Connection dbConnection = null;
        Statement statement = null;

        String selectTableSQL = "SELECT name, cena from raz";
        try {
            dbConnection = connectionDb();
            statement = dbConnection.createStatement();

            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(selectTableSQL);

            // И если что то было получено то цикл while сработает
            while (rs.next()) {

                String userid = rs.getString("name");
                String username = rs.getString("cena");


                System.out.println("userid : " + userid);
                System.out.println("username : " + username);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        }







    public static void main(String[] args)  {



        try {
            getDataTable();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }





        launch(args);

    }
}
