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

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPublished_at(String published_at) {
        this.published_at = published_at;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
}
