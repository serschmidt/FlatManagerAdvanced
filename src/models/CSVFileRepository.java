package models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVFileRepository {
    private String filePath;

    public CSVFileRepository(String filePath) {
        this.filePath = filePath;
    }

    public void save(List<Flat> flats) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Flat flat : flats) {
                String line = flat.getCSVLine();
                bw.write(line);
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }

    public List<Flat> load() {
        return null;
    }
}
