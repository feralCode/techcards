package com.techcards.TechCardsBackend.models.dao.subjects;

import com.techcards.TechCardsBackend.models.dao.decks.Deck;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class SubjectMapper implements RowMapper<Subject> {

    public Subject mapRow(ResultSet resultSet, int i) throws SQLException {

        Subject subject = new Subject();
        subject.setId(resultSet.getObject("subject_id", UUID.class));
        subject.setName(resultSet.getString("subject_name"));

        return subject;
    }
}