package task2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String ABSOLUTE_PATH = "D:\\hw-9.2\\src\\task2\\text.txt";
    private static final String PATH_FOR_JSON = "D:\\hw-9.2\\src\\task2\\users.json";
    public static void main(String[] args) {
        File file = new File(ABSOLUTE_PATH);
        File json = new File(PATH_FOR_JSON);
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> list = new ArrayList<>();

        if(!json.exists()){
            json.getParentFile().mkdirs();
            try {
                json.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
             FileWriter fileWriter = new FileWriter(json)) {
            String line = bufferedReader.readLine();
            while (line!=null){
                String[] split = line.split(" ");
                User user = new User(split[0],Integer.parseInt(split[1]));
                list.add(user);
                line=bufferedReader.readLine();
            }
            objectMapper.writeValue(fileWriter,list);

        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
