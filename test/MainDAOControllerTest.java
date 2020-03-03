import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

class MainDAOControllerTest {

    @org.junit.jupiter.api.Test
    void loadFromDB() throws IOException {
        FileReader fileReader = new FileReader("src/resources/database/default");
        Scanner scan = new Scanner(fileReader);
        ArrayList<String> data = new ArrayList<>();
        while (scan.hasNextLine()) {
            data.add(scan.nextLine());
        }
        System.out.println(data);
        fileReader.close();
    }

    @org.junit.jupiter.api.Test
    void loadFromDb() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        String url = "jdbc:sqlite:identifier.sqlite";
        Connection conn = DriverManager.getConnection(url);
        System.out.println("Ready");
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Models");
        ObservableList<String> data = FXCollections.observableArrayList();
        data.setAll(String.valueOf(resultSet));
        System.out.println(data);
    }
}