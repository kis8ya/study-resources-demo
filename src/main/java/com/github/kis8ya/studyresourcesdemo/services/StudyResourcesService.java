package com.github.kis8ya.studyresourcesdemo.services;

import com.github.kis8ya.studyresourcesdemo.model.ResourceType;
import com.github.kis8ya.studyresourcesdemo.model.StudyResource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudyResourcesService {

    private List<StudyResource> resources = new ArrayList<>();

    public StudyResourcesService() {
        resources.addAll(List.of(
                StudyResource.builder().name("English grammar").build(),
                StudyResource.builder().name("Java in a nutshell").build(),
                StudyResource.builder().name("Discrete mathematics").type(ResourceType.BOOK).build()
        ));
    }

    public Iterable<StudyResource> list() {
        return resources;
    }

    public Optional<StudyResource> findById(String id) {
        for (StudyResource resource : resources) {
            if (resource.getId().equals(id)) {
                return Optional.of(resource);
            }
        }
        return Optional.empty();
    }

    public StudyResource add(StudyResource resource) {
        resources.add(resource);
        return resource;
    }

    public void remove(StudyResource resource) {
        resources.remove(resource);
    }

    public boolean removeById(String id) {
        return resources.removeIf(resource -> resource.getId().equals(id));
    }

}
