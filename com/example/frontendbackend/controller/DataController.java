package com.example.frontendbackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileWriter;
import java.io.IOException;

@Controller
public class DataController {

    @PostMapping("submit")
    public ResponseEntity<String> submitData(@RequestParam("inputText") String inputText) {
        try (FileWriter writer = new FileWriter("data.txt", true)) {
            writer.write(inputText + System.lineSeparator());
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Error while saving data");
        }
        return ResponseEntity.ok("Data saved successfully");
    }
}
