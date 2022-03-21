package com.github.kis8ya.studyresourcesdemo.services;

import com.github.kis8ya.studyresourcesdemo.model.StudyResource;

import java.util.Optional;

public interface StudyResourcesService {

    Iterable<StudyResource> list();

    Optional<StudyResource> findById(String id);

    StudyResource add(StudyResource resource);

    void remove(StudyResource resource);

    void removeById(String id);

    boolean existsById(String id);

}
