package com.techcards.TechCardsBackend.models.dao.subjects;

import com.techcards.TechCardsBackend.models.dao.decks.Deck;
import com.techcards.TechCardsBackend.models.dao.decks.DeckDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.*;

@Component
public class SubjectDAO {

    JdbcTemplate jdbcTemplate;
    DeckDAO deckDAO;

    public SubjectDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Subject getSubjectById(UUID subjectId) {
        Subject currentSubject = jdbcTemplate.queryForObject("select * from subjects where subject_id = ?", new Object[] { subjectId }, new SubjectMapper());
        currentSubject.setDeckList(deckDAO.getAllDecksBySubjectId(subjectId));
        return currentSubject;
    }


    public List<Subject> getAllSubjects() {
        List<Subject> subjects = new ArrayList<>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from subjects");

        for (Map row : rows) {
            Subject subject = new Subject();
            subject.setId((UUID) row.get("subject_id"));
            subject.setName((String) row.get("subject_name"));
            subject.setImageUrl((String) row.get("subject_imageUrl"));
            subject.setDeckList((List<Deck>) row.get("subject_deck_list"));

            subjects.add(subject);
        }
        return subjects;
    }

    public int createSubject(Subject subject) {

        UUID newSubjectId = UUID.randomUUID();
        subject.setId(newSubjectId);

        String sql = "insert into subjects " +
                "(subject_id, subject_name, subject_imageUrl, subject_deck_list) values " +
                "('" + subject.getId() +
                "','" + subject.getName() +
                "','" + subject.getImageUrl() +
                "','" + subject.getDeckList() + "')";

        return jdbcTemplate.update(sql);
    }

    public int updateSubject(Subject subject) {
        String sql = "update subjects set " +
                "subject_name = '" + subject.getName() +
                "', subject_imageUrl = '" + subject.getImageUrl() +
                "', subject_deck_list = '" + subject.getDeckList() +
                "' where subject_id = " + subject.getId() + "";

        return jdbcTemplate.update(sql);
    }

    public int deleteSubject(UUID subjectId) {
        String sql = "delete from subjects where id = '" + subjectId + "'";
        return jdbcTemplate.update(sql);
    }

}
