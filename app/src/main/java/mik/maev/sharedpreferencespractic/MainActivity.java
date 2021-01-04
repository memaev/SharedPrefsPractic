package mik.maev.sharedpreferencespractic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button up_score_btn;
    private TextView score;
    private int score_int;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       up_score_btn = findViewById(R.id.up_score_btn);
       score = findViewById(R.id.score);

       SharedPreferences prefs = getSharedPreferences("Score", Context.MODE_PRIVATE);
       SharedPreferences.Editor edit = prefs.edit();
       score_int = prefs.getInt("score", 0);
       score.setText(Integer.toString(score_int));
       up_score_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               score_int++;
               score.setText(Integer.toString(score_int));
               edit.putInt("score", score_int);
               edit.apply();
           }
       });
    }
}