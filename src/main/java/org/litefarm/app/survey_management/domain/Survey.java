package org.litefarm.app.survey_management.domain;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class Survey {
    private UUID uuid;
    private List<Question> questionList;
    private Locale locale;

    public Survey() {
        uuid = UUID.randomUUID();
        questionList = List.of(new Question());
    }
}
