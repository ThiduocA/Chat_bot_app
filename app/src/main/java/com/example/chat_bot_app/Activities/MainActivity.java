package com.example.chat_bot_app.Activities;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chat_bot_app.Adapter.MessageAdapter;
import com.example.chat_bot_app.Adapter.QuestionAdapter;
import com.example.chat_bot_app.Question;
import com.example.chat_bot_app.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapterQuestion;
private RecyclerView recyclerView, recyclerViewChat;
private ImageView sendBtn;
private EditText messageEditText;
List<Message> messageList;
MessageAdapter messageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        messageList = new ArrayList<>();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        initRecyclerviewExplain();
//        initRecyclerviewWrite();
//        initRecyclerviewTranslate();

        EditText editText = findViewById(R.id.editTextText);
        editText.setBackgroundResource(0);

        //setup recycler view
        messageAdapter = new MessageAdapter(messageList);
        recyclerViewChat = findViewById(R.id.recycleView);
        recyclerViewChat.setAdapter(messageAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setStackFromEnd(true);
        recyclerViewChat.setLayoutManager(llm);

        clickBtn();
    }

    private void clickBtn() {
        sendBtn = findViewById(R.id.sendBtn);
        messageEditText = findViewById(R.id.editTextText);
        sendBtn.setOnClickListener((v -> {
            String question = messageEditText.getText().toString().trim();
            //Toast.makeText(this, question, Toast.LENGTH_LONG).show();
            addToChat(question, Message.SENT_BY_ME);
            messageEditText.setText("");

        }));
    }

//    private void initRecyclerviewTranslate() {
//        ArrayList<Question> questions = new ArrayList<>();
//
//        questions.add(new Question("How do you say “how are you” in korean?"));
//        questions.add(new Question("Write a poem about flower and love"));
//
//        recyclerView = findViewById(R.id.translate);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//
//        adapterQuestion = new QuestionAdapter(questions);
//        recyclerView.setAdapter(adapterQuestion);
//    }
//
//    private void initRecyclerviewWrite() {
//        ArrayList<Question> questions = new ArrayList<>();
//
//        questions.add(new Question("Explain Quantum physics"));
//        questions.add(new Question("What are wormholes explain like i am 5"));
//
//        recyclerView = findViewById(R.id.explain);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//
//        adapterQuestion = new QuestionAdapter(questions);
//        recyclerView.setAdapter(adapterQuestion);
//    }
//
//    private void initRecyclerviewExplain() {
//        ArrayList<Question> questions = new ArrayList<>();
//
//        questions.add(new Question("Write a tweet about global warming"));
//        questions.add(new Question("Write a poem about flower and love"));
//        questions.add(new Question("Write a rap song lyrics about"));
//
//        recyclerView = findViewById(R.id.write);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//
//        adapterQuestion = new QuestionAdapter(questions);
//        recyclerView.setAdapter(adapterQuestion);
//
//    }

    private void addToChat(String message, String sentBy){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                messageList.add(new Message(message, sentBy));
                messageAdapter.notifyDataSetChanged();
                recyclerViewChat.smoothScrollToPosition(messageAdapter.getItemCount());
            }
        });

    }
}