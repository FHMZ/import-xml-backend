package com.importer.importxmlbackend.controller;

import com.importer.importxmlbackend.model.Agent;
import com.importer.importxmlbackend.service.ImportXmlService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/imports")
public class ImportXmlController {

    private final ImportXmlService importXmlService;

    @PostMapping
    public ResponseEntity<String> saveFiles(@RequestParam MultipartFile file) throws IOException {
        importXmlService.createFile(file);
        return ResponseEntity.ok().body("Os arquivos foram lidos com sucesso.");
    }

    @GetMapping(name = "/regions")
    public ResponseEntity<List<Agent>> getFileByRegion() {
        return ResponseEntity.ok().body(importXmlService.getAllFiles());
    }

    @DeleteMapping(name = "/agents/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long agentId) {
        importXmlService.deleteById(agentId);
        return ResponseEntity.ok().body("O arquivo foi deletado com sucesso");
    }

}
