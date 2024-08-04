package com.example.chat_bot_app.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chat_bot_app.Question;
import com.example.chat_bot_app.R;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.viewholder> {


    ArrayList<Question> questions;
    Context context;

    public QuestionAdapter(ArrayList<Question> questions) {
        this.questions = questions;
    }
    @NonNull
    @Override
    public QuestionAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_question, parent, false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionAdapter.viewholder holder, int position) {
        holder.quests.setText(questions.get(position).getQuestion());
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView quests;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            quests = itemView.findViewById(R.id.quest);
        }
    }
}
