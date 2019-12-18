package com.example.wordgame.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wordgame.R;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordHolder> {

    Context context;
    EditText editTextWord;
    private Character[] characterList;

    public WordAdapter(Context context, EditText editTextWord, Character[] characterList) {
        this.context = context;
        this.editTextWord = editTextWord;
        this.characterList = characterList;
    }

    @NonNull
    @Override
    public WordHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.character_layout, parent, false);
        WordHolder wordHolder = new WordHolder(view);
        return wordHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final WordHolder holder,final int position) {
        holder.textView.setText(String.valueOf(characterList[position]));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String setWord = editTextWord.getText().toString() + characterList[position];
                editTextWord.setText(setWord);
                holder.textView.setOnClickListener(null);
            }
        });

    }

    @Override
    public int getItemCount() {
        return characterList.length;
    }

    public class WordHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        TextView textView;
        public WordHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.letters);
            textView = itemView.findViewById(R.id.letterChar);
        }
    }
}
