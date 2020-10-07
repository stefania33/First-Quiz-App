package com.example.truecitizenquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button falseButton;
    private Button trueButton;
    private TextView questionTextView;
    private ImageButton nextButton;
    private ImageButton backButton;

    private int currentQuestionIndex = 0;

    private Question[] questionBank = new Question[]{
            new Question(R.string.question_text, false),
            new Question(R.string.question_text1, true),
            new Question(R.string.question_text2, false),
            new Question(R.string.question_text3, true),
            new Question(R.string.question_text4, false),
            new Question(R.string.question_text5, true),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Question question = new Question(R.string.question_text, true);


        falseButton = findViewById(R.id.false_button);
        trueButton = findViewById(R.id.true_button);
        questionTextView = findViewById(R.id.answer_text_view);
        nextButton = findViewById(R.id.next_button);
        backButton = findViewById(R.id.back_button);

//        falseButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        };
//
//        trueButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });


        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.false_button:
                checkAnswer(false);
                break;

            case R.id.true_button:
                checkAnswer(true);
                break;

            case R.id.next_button:
//                Toast.makeText(MainActivity.this, "Next", Toast.LENGTH_SHORT).show();
                currentQuestionIndex = (currentQuestionIndex+1) % questionBank.length;
                updateQuestion();
                break;

            case R.id.back_button:
                if(currentQuestionIndex > 0) {
                    currentQuestionIndex = (currentQuestionIndex - 1) % questionBank.length;
                }else{
                    currentQuestionIndex = questionBank.length;
                    currentQuestionIndex = (currentQuestionIndex - 1) % questionBank.length;
                }
                updateQuestion();
                break;
        }
    }

    private void updateQuestion(){
            Log.d("Current", "onClick: " +currentQuestionIndex);
            questionTextView.setText(questionBank[currentQuestionIndex].getAnswerResId());

    }

    private void checkAnswer(boolean userChooseCorect){
        boolean answerIsTrue = questionBank[currentQuestionIndex].isAnswerTrue();
        int toastMessageId;

        if(userChooseCorect == answerIsTrue){
            toastMessageId = R.string.correct_answer;
        }else{
            toastMessageId=R.string.wrong_answer;
        }

        Toast.makeText(MainActivity.this, toastMessageId, Toast.LENGTH_SHORT).show();
    }
}
