package com.read.excle.propertiesfile.readfile.contoller;

import com.read.excle.propertiesfile.readfile.service.ReadAndWriteTxtFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/txt")
public class ReadAndWriteTxtFileController {
    @Autowired
    ReadAndWriteTxtFileService readAndWriteTxtFileService;
    @GetMapping
    public ResponseEntity readTxtFile(@RequestParam("file") MultipartFile files) throws IOException {
       readAndWriteTxtFileService.readTxtFile(files);
return ResponseEntity.ok("file has been read");
    }
    @PostMapping
    ResponseEntity writeTextFile(){
readAndWriteTxtFileService.writeTxtFile();

return ResponseEntity.ok("write file has been done");
    }
}
