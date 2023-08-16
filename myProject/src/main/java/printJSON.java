import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class printJSON {
    private static final String COMMA_DELIMITER = ",";

    public List<objectName> pintResult() throws IOException {
        String Path = "C:\\Users\\trangthihuyentran\\Desktop\\Test data\\NewDataCollection7.csv";
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<objectName> results = new ArrayList<objectName>();
        BufferedReader reader = new BufferedReader(new FileReader(Path));
        String line = "";
        int i = 0;
        String header = "";
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(COMMA_DELIMITER);
            if (header == "") header = fields[0];
            results.add(new objectName("REQ_00" + ++i, header, "REQ_00" + i, fields[0]));
        }
        new GsonBuilder().setPrettyPrinting().create().toJson(results);
        return results;
    }

    public void commentLine() throws IOException {
        List<objectName> results = pintResult();
        Scanner inital = new Scanner(System.in);
        System.out.println("Input question: ");
        int numberOfQuestion = inital.nextInt();

        switch (numberOfQuestion) {
            case 1, 2:
                System.out.println("Question " + new GsonBuilder().setPrettyPrinting().create().toJson(results.get(--numberOfQuestion)));
                break;
            case 3:
                System.out.println("Question " + new GsonBuilder().setPrettyPrinting().create().toJson(results));
                break;
        }
    }
}
