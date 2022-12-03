package com.read.excle.propertiesfile.readfile.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class ReadAndWriteTxtFileService {
    public  void readTxtFile(MultipartFile files) throws IOException {
        InputStream inputStream = new ByteArrayInputStream(files.getBytes());

        StringBuilder resultStringBuilder = new StringBuilder();

        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }

        System.out.println(resultStringBuilder.toString());


    }
    public void writeTxtFile(){
        try {
            FileWriter myWriter = new FileWriter("E:\\filename.txt");
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
