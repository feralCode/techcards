package com.techcards.TechCardsBackend.models.services;

import com.techcards.TechCardsBackend.models.dao.subjects.Subject;
import com.techcards.TechCardsBackend.models.dao.subjects.SubjectDAO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SubjectService {

    SubjectDAO subjectDAO;

    public SubjectService(SubjectDAO subjectDAO) {
        this.subjectDAO = subjectDAO;
    }

    public Subject getSubjectById(UUID id) {
        Subject subject = subjectDAO.getSubjectById(id);

        return subject;
    }
}
