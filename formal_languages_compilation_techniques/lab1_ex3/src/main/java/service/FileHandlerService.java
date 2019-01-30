package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import service.automate.AutomatFinit;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Service class that has methods to read and write files.
 */
public class FileHandlerService {


    /**
     * Outputs a list of Strings, each representing a line.
     *
     * @param filePath - path to the file
     * @return List of Strings (lines)
     * @throws IOException
     */
    public List<String> readFromFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }

    public AutomatFinit readFromJson(String filePath) throws IOException{
       ObjectMapper objectMapper = new ObjectMapper();
       return objectMapper.readValue(new File(filePath),AutomatFinit.class);
    }

}
