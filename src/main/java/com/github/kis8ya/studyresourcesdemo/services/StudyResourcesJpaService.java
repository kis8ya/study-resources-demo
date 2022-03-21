package com.github.kis8ya.studyresourcesdemo.services;

import com.github.kis8ya.studyresourcesdemo.model.StudyResource;
import com.github.kis8ya.studyresourcesdemo.repositories.StudyResourcesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudyResourcesJpaService implements StudyResourcesService {

    private final StudyResourcesRepository repository;

    public StudyResourcesJpaService(StudyResourcesRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<StudyResource> list() {
        return repository.findAll();
    }

    @Override
    public Optional<StudyResource> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public StudyResource add(StudyResource resource) {
        return repository.save(resource);
    }

    @Override
    public void remove(StudyResource resource) {
        repository.delete(resource);
    }

    @Override
    public void removeById(String id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(String id) {
        return repository.existsById(id);
    }
}
