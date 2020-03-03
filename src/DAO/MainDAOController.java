package DAO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainDAOController {

    public static void loadFromDB(String textFileUrl) throws IOException {
        FileReader fileReader = new FileReader(textFileUrl);
        Scanner scan = new Scanner(fileReader);
        while (scan.hasNextLine()){
            System.out.println(scan.nextLine());
        }
        fileReader.close();
    }
}
