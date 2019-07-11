package com.robert.starwarsquiz;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private TextView mQuestionTextView;
    private TextView mScoreTextView;
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mProofButton;

    Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_one, false, R.string.video_one ),
            new Question(R.string.question_two, true, R.string.video_two),
            new Question(R.string.question_three, true, R.string.video_three),
            new Question(R.string.question_four, true, R.string.video_four),
            new Question(R.string.question_five, false, R.string.video_five),
    };

    int mCurrentIndex = 0;
    int mScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Typeface solidFont = Typeface.createFromAsset(getAssets(), "fonts/Star_Jedi_Rounded.ttf");
        //Typeface hollowFont = Typeface.createFromAsset(getAssets(), "fonts/Starjhol.ttf");

        mQuestionTextView = findViewById(R.id.question_text_view);
        mQuestionTextView.setTypeface(solidFont);
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });

        mScoreTextView = findViewById(R.id.score_text_view);

        mTrueButton = findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mQuestionBank[mCurrentIndex].getUnanswered()){
                    checkAnswer(true);
                }
            }
        });

        mFalseButton = findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mQuestionBank[mCurrentIndex].getUnanswered()){
                    checkAnswer(false);
                }
            }
        });

        mNextButton = findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });

        mProofButton = findViewById(R.id.proof_button);
        mProofButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(QuizActivity.this, APIActivity.class);
                //String videoString = getResources().getString(mQuestionBank[mCurrentIndex].getYOUTUBE_VIDEO_CODE());
                //intent.putExtra("Video", videoString);
                //startActivity(intent);
            }
        });

        updateQuestion();
        //updateScore();
    }

    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    private void updateScore() {
        mScore +=50;
        mScoreTextView.setText(Integer.toString(mScore));
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();

        int messageResId = 0;

        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
            updateScore();
        } else {
            messageResId = R.string.incorrect_toast;
            mProofButton.setVisibility(View.VISIBLE);
        }

        mQuestionBank[mCurrentIndex].setUnanswered();

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();

    }





}
