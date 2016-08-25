package com.example.qklahpita.sqlite;

import java.util.List;

/**
 * Created by Qk Lahpita on 8/23/2016.
 */
public class MathWord {
    private String questionContent;
    private List<String> listAnswer;

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public List<String> getListAnswer() {
        return listAnswer;
    }

    public void setListAnswer(List<String> listAnswer) {
        this.listAnswer = listAnswer;
    }

    public MathWord(String questionContent, List<String> listAnswer) {

        this.questionContent = questionContent;
        this.listAnswer = listAnswer;
    }
}
