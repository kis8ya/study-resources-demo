package com.github.kis8ya.studyresourcesdemo.model;

import lombok.*;

import java.util.UUID;

@Builder
public class StudyResource {

    @Getter
    private final String id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private ResourceType type;

    public StudyResource(String id, String name, ResourceType type) {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
        if (type == null) {
            type = ResourceType.ONLINE_COURSE;
        }
        this.id = id;
        this.name = name;
        this.type = type;
    }

}
