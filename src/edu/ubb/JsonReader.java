package edu.ubb;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class JsonReader {

    public List<Question> jsonReader() throws IOException {

        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        Path path = Paths.get("questions.json");

        List<Question> questionList;

        try (Reader reader = Files.newBufferedReader(path)){
            questionList=gson.fromJson(reader, new TypeToken<List<Question>>(){}.getType());
        }
        return questionList;
    }

}
