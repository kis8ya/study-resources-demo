package com.github.kis8ya.studyresourcesdemo.controllers;

import com.github.kis8ya.studyresourcesdemo.model.StudyResource;
import com.github.kis8ya.studyresourcesdemo.services.StudyResourcesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@RestController
@RequestMapping({"/resources"})
public class StudyResourcesController {

    private final StudyResourcesService studyResourcesService;

    public StudyResourcesController(StudyResourcesService studyResourcesService) {
        this.studyResourcesService = studyResourcesService;
    }

    @GetMapping({""})
    public Iterable<StudyResource> get() {
        return studyResourcesService.list();
    }

    @PostMapping({""})
    public StudyResource post(@RequestBody StudyResource resource) {
        return studyResourcesService.add(resource);
    }

    @GetMapping({"/{id}"})
    public StudyResource getById(@PathVariable String id) {
        Optional<StudyResource> resource = studyResourcesService.findById(id);
        if (resource.isPresent()) {
            return resource.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Study resource not found");
    }

    @RequestMapping(value = {"/{id}"}, method = {RequestMethod.PATCH, RequestMethod.PUT})
    public ResponseEntity<StudyResource> patchById(@PathVariable String id, @RequestBody StudyResource resource) {
        HttpStatus status = HttpStatus.CREATED;
        if (studyResourcesService.existsById(resource.getId())) {
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(studyResourcesService.add(resource), status);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String id) {
        studyResourcesService.removeById(id);
    }

}
