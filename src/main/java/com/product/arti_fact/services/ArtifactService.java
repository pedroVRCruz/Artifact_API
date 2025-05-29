package com.product.arti_fact.services;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.arti_fact.model.Artifact;
import com.product.arti_fact.repository.ArtifactRepository;

@Service
public class ArtifactService {

    @Autowired
    private ArtifactRepository artifacRepository;

    /**
     * Return all artifacts
     * 
     * @return artifact list
     */
    public List<Artifact> getAll() {
        return artifacRepository.getAll();
    }

    /**
     * Metod that returns the found artefact by id
     * 
     * @param id of the artifact
     * @return Return an artefact if found one
     */
    public Optional<Artifact> getById(Integer id) {
        return artifacRepository.getById(id);
    }

    /**
     * Add an artifact
     * 
     * @param artifact to be add
     * @return The add artifact
     */
    public Artifact addArtifact(Artifact artifact) {
        // needs some rules, marker
        return artifacRepository.addArtifact(artifact);
    }

    /**
     * Method to delete an artifact by i
     * 
     * @param id
     */
    public void deleteArt(Integer id) {
        artifacRepository.deleteArt(id);
    }

    /**
     * Method to update an artifact
     * 
     * @param artifact receive an artifact that will be used to search the old id
     *                 and update
     * @return updated artifact
     */
    public Artifact updateArt(Integer id, Artifact artifact) {

        // need some business rules, marker
        artifact.setId(id);

        return artifacRepository.updateArt(artifact);

    }

}
