package com.product.arti_fact.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.arti_fact.model.Artifact;
import com.product.arti_fact.services.ArtifactService;

@RestController
@RequestMapping("/api/artifacts/")
public class ArtifactController {
    @Autowired
    private ArtifactService artifactService;

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/get_all")
    public List<Artifact> get_all() {
        return artifactService.getAll();
    }

    @GetMapping("/get_by_id/{id}")
    public Optional<Artifact> get_by_id(@PathVariable Integer id) {
        return artifactService.getById(id);
    }

    @PostMapping("/add_artifact")
    public Artifact add_artifact(@RequestBody Artifact artifact) {
        return artifactService.addArtifact(artifact);
    }

    @DeleteMapping("/delete_artifact/{id}")
    public String delete_artifact(@PathVariable Integer id) {
        artifactService.deleteArt(id);
        return "Artifact with id: " + id + " has been deleted";
    }

    @PutMapping("/update_artifact")
    public Artifact update_artifact(@RequestBody Artifact artifact) {
        return artifactService.updateArt(artifact.getId(), artifact);
    }
}
