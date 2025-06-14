package com.product.arti_fact.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.product.arti_fact.model.Artifact;
import com.product.arti_fact.model.exception.ResourceNotFoundException;

@Repository
public class ArtifactRepository {

    private List<Artifact> artifacts = new ArrayList<Artifact>();
    private Integer lastID = 0;

    /**
     * Return all artifacts
     * 
     * @return artifact list
     */
    public List<Artifact> getAll() {
        return artifacts;
    }

    /**
     * Metod that returns the found artefact by id
     * 
     * @param id of the artifact
     * @return Return an artefact if found one
     */
    public Optional<Artifact> getById(Integer id) {
        return artifacts
                .stream()
                .filter(artifact -> artifact.getId() == id)
                .findFirst();
    }

    /**
     * Add an artifact
     * 
     * @param artifact to be add
     * @return The add artifact
     */
    public Artifact addArtifact(Artifact artifact) {
        lastID++;

        artifact.setId(lastID);
        artifacts.add(artifact);

        return artifact;
    }

    /**
     * Method to delete an artifact by i
     * 
     * @param id
     */
    public void deleteArt(Integer id) {
        artifacts.removeIf(artifact -> artifact.getId() == id);
    }

    /**
     * Method to update an artifact
     * 
     * @param artifact receive an artifact that will be used to search the old id
     *                 and update
     * @return updated artifact
     */
    public Artifact updateArt(Artifact artifact) {
        // search for the product
        Optional<Artifact> foundArtifact = getById(artifact.getId());
        if (foundArtifact.isEmpty()) {
            throw new ResourceNotFoundException("Artifact not found!");
        }

        // remove the old one
        deleteArt(artifact.getId());

        // add the updated one
        artifacts.add(artifact);

        return artifact;

    }
}
