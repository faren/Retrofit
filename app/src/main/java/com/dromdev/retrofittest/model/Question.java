package com.dromdev.retrofittest.model;

import java.util.List;

/**
 * Created by faren on 5/26/15.
 */
public class Question {
    private String question;
    private String url;
    private String published_at;
    private List<Choice> choices;

    public String getQuestion() {
        return question;
    }

    public String getUrl() {
        return url;
    }

    public String getPublished_at() {
        return published_at;
    }

    public List<Choice> getChoices() {
        return choices;
    }
}
