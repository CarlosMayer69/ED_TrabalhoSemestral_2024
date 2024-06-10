package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVHandler {

    private String filePath;

    public CSVHandler(String filePath) {
        this.filePath = filePath;
    }

    public String[][] readCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String[] rows = sb.toString().split("\n");
            if (rows.length == 0) {
                return null;
            }
            String[][] data = new String[rows.length][];
            for (int i = 0; i < rows.length; i++) {
                data[i] = rows[i].split(",");
            }
            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeCSV(String[][] data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] row : data) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
