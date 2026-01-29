package org.litefarm.app.survey_management.domain;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class Question {
    private UUID uuid;
    private String displayText;
    private Locale locale;
    private QuestionType questionType;
    private List<Answer> answerList;
}
