package com.techcards.TechCardsBackend.controllers;

import com.techcards.TechCardsBackend.models.dao.subjects.Subject;
import com.techcards.TechCardsBackend.models.services.SubjectService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/subject")
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


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Subject> getAllSubjects() {
        List<Subject> allSubjects = subjectService.getAllSubjects();
        return allSubjects;
    }

    @RequestMapping(value = "/newSubject", method = RequestMethod.POST)
    public String createSubject(@RequestBody Subject subject) {
        subjectService.createSubject(subject);
        return "redirect:/all";
    }

    @RequestMapping(value="/editSubject/{subjectId}")
    public String editSubject(@PathVariable("subjectId") UUID subjectId, Model m) {
        Subject subject = subjectService.getSubjectById(subjectId);
        m.addAttribute("command", subject);
        return "editSubjectForm";
    }

    @RequestMapping(value = "/editSubject", method = RequestMethod.PUT)
    public String updateSubject(@ModelAttribute("subject") Subject subject) {
        subjectService.updateSubject(subject);
        return "redirect:/all";
    }

    @RequestMapping(value="/deleteSubject/{subjectId}",method = RequestMethod.DELETE)
    public String deleteSubject(@PathVariable("subjectId") UUID subjectId) {
        subjectService.deleteSubject(subjectId);
        return "redirect:/all";
    }
}
