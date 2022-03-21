package com.github.kis8ya.studyresourcesdemo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
@NoArgsConstructor
public class StudyResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private String id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private ResourceType type;

    public StudyResource(String id, String name, ResourceType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

}
