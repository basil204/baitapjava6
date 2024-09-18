package com.example.BaiCuoiMon.rest.controller;

import com.example.BaiCuoiMon.Service.UploadService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/upload")
public class UploadRestController {
    @Autowired
    private UploadService uploadService;

    @PostMapping("/{folder}")
    public JsonNode uploadImage(@PathVariable("folder") String folder, @RequestParam("file") MultipartFile file) {
        File savedFile = uploadService.save(file, folder);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("name", savedFile.getName());
        node.put("size", savedFile.length());
        return node; // Convert ObjectNode to String for return type
    }
}
