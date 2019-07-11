package com.robert.starwarsquiz;

public class Question {

    private int mTextResId;
    private boolean mAnswerTrue;
    private boolean mUnanswered = true;
    private int mYOUTUBE_VIDEO_CODE;

    public Question(int textResId, boolean answerTrue, int YOUTUBE_VIDEO_CODE) {
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
        mYOUTUBE_VIDEO_CODE = YOUTUBE_VIDEO_CODE;

    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public int getYOUTUBE_VIDEO_CODE() {
        return mYOUTUBE_VIDEO_CODE;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

    public boolean getUnanswered() {
        return mUnanswered;
    }

    public void setUnanswered() {
        mUnanswered = false;
    }

}
