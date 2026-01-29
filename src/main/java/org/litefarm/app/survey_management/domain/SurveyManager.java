package org.litefarm.app.survey_management.domain;

import org.litefarm.app.kernel.domain.AggregateRoot;

public class SurveyManager implements AggregateRoot {
    public Survey createSurvey() {

        var survey = new Survey();
        return null;

    }

}


/**
 *  SurveyManager will be used something like
 *      OnbooardingSurvey -> to collect info about the user
 *      CertificateSurvey -> to build up certifications
 *      CropSurvey -> for a specific crop they can have different info
 *      LocationSurvey
 *
 *   with SurveyManager you can build those Surveys
 *   and also fetch them from memory
 *
 *   Surveys are going to be stored in the DB
 *   if an entity needs a survey they have to have a relationship between them
 *   For example:
 *      When user gets onboarded
 *      at the time of bringing up the onboarding process, a query to the DB
 *      looking for a specific survey has to be made
 *      Some of them have to be known beforehand (thus created as part of seeding process)
 *      and some other can be created on the flight through user input
 *
 *      that workflow might look like
 *      - user creates a farm
 *          GET /survey?id=farm-creation&locale=en
 *      Load the values from the DB
 *      create proper objects FarmSurvey with all its questions
 *
 *      - user wll be answering the survey
 *      - when saving:
 *          - update the survey with the information given
 *
 *         NOTE: Use some sort of tag so the object can be manipulated easily from
 *         the code as the surveys are developer centric and not user-centric, users
 *         dont create surveys, but developers
 *
 */