package com.techcards.TechCardsBackend.controllers;

import com.techcards.TechCardsBackend.models.dao.subjects.Subject;
import com.techcards.TechCardsBackend.models.services.SubjectService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @RequestMapping(value = "/{subjectId}", method = RequestMethod.GET)
    public Subject getSubject(@PathVariable("subjectId") UUID subjectId) {
        Subject subject = subjectService.getSubjectById(subjectId);
        return subject;
    }
}
