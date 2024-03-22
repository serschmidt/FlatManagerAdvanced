package models;

import java.io.*;
import java.util.List;

public class CSVFileRepository {
    private String filePath;
    private FlatRepository flatRepo;

    public CSVFileRepository(String filePath) {
        this.filePath = filePath;
        flatRepo = new FlatRepository();
    }

    public void save(String filePath, List<Flat> flats) {
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


    public void load(String fileLocation) {
        try (FileReader fr = new FileReader(fileLocation)) {
            BufferedReader br = new BufferedReader(fr);
            flatRepo.clear();
            do {
                String line = br.readLine();
                if (line == null) // finish, if reached the end of the file
                    break;
                // split the line into a data parts
                Flat newFlat = Flat.parseFromCSV(line);
                flatRepo.add(newFlat);
            } while (true);
            flatRepo.sortById();
            int newCount = flatRepo.getNewCount();
            Flat.setCount(newCount);
        } catch (IOException e) {
            System.out.print("ERROR: loading error.");
        }
    }

}
