package com.github.kis8ya.studyresourcesdemo.bootstrap;

import com.github.kis8ya.studyresourcesdemo.model.ResourceType;
import com.github.kis8ya.studyresourcesdemo.model.StudyResource;
import com.github.kis8ya.studyresourcesdemo.repositories.StudyResourcesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final StudyResourcesRepository studyResourcesRepository;

    public DataLoader(StudyResourcesRepository studyResourcesRepository) {
        this.studyResourcesRepository = studyResourcesRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<StudyResource> resources = List.of(
                StudyResource.builder().name("Head First Java").type(ResourceType.BOOK).build(),
                StudyResource.builder().name("Effective Java").type(ResourceType.BOOK).build(),
                StudyResource.builder().name("Spring Framework 5: Beginner to Guru").type(ResourceType.ONLINE_COURSE).build(),
                StudyResource.builder().name("Introduction to Algorithms").type(ResourceType.BOOK).build(),
                StudyResource.builder().name("Concrete Mathematics").type(ResourceType.BOOK).build(),
                StudyResource.builder().name("USACO Guide").type(ResourceType.ONLINE_COURSE).build()
        );

        studyResourcesRepository.saveAll(resources);
    }
}
