package com.example.truecitizenquiz;

public class Question {
    private int answerResId;
    private boolean answerTrue;

    public Question(int answerResId, boolean answerTrue) {
        this.answerResId = answerResId;
        this.answerTrue = answerTrue;
    }

    public int getAnswerResId() {
        return answerResId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerResId(int answerResId) {
        this.answerResId = answerResId;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }
}
