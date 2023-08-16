import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class readCSV {
    private static final String COMMA_DELIMITER = ",";
    String inputFilePath = "C:\\Users\\trangthihuyentran\\Desktop\\Test data\\DataCollection.csv";
    String outputFilePath = "C:\\Users\\trangthihuyentran\\Desktop\\Test data\\NewDataCollection7.csv";

    public void creatNewFile() throws IOException {
        List<String> uniqueRecords = new ArrayList();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(COMMA_DELIMITER);
                String nameEntity = null;
                nameEntity = fields[0];
                if (!uniqueRecords.contains(nameEntity) && !nameEntity.equals("smalltalk")) {
                    uniqueRecords.add(nameEntity);
                }
            }
            for (int i = 0; i < uniqueRecords.size(); i++) {
                writer.write(uniqueRecords.get(i));
                writer.newLine();
            }
            System.out.println("Duplicates removed and unique records written to " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



