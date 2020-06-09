package com.techcards.TechCardsBackend.models.services;

import com.techcards.TechCardsBackend.models.dao.subjects.Subject;
import com.techcards.TechCardsBackend.models.dao.subjects.Subject;
import com.techcards.TechCardsBackend.models.dao.subjects.SubjectDAO;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Subject> getAllSubjects() {
        List<Subject> allSubjects = subjectDAO.getAllSubjects();
        return allSubjects;
    }

    public int createSubject(Subject subject) {
        return subjectDAO.createSubject(subject);
    }

    public int updateSubject(Subject subject) {
        return subjectDAO.updateSubject(subject);
    }

    public int deleteSubject(UUID subjectId) {
        return subjectDAO.deleteSubject(subjectId);
    }
}
