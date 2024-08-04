package com.example.chat_bot_app.Activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chat_bot_app.Adapter.QuestionAdapter;
import com.example.chat_bot_app.Question;
import com.example.chat_bot_app.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapterQuestion;
private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initRecyclerview();
    }

    private void initRecyclerview() {
        ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question("Explain Quantum physics"));
        questions.add(new Question("What are wormholes explain like i am 5"));
        questions.add(new Question("What are wormholes explain like i am 5"));

        recyclerView = findViewById(R.id.explain);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapterQuestion = new QuestionAdapter(questions);
        recyclerView.setAdapter(adapterQuestion);

    }
}