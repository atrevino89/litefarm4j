package org.litefarm.app.survey_management.domain;

public enum QuestionType {
    MULTI_CHOICE,
    SCALE, // ranges from 1 to X
    BOOLEAN, // agree/disagree
    RANKED, // to rank answers
    OPEN_ENDED,
}
