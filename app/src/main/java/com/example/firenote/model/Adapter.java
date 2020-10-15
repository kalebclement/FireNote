package com.example.firenote.model;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firenote.NoteDetail;
import com.example.firenote.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    List<String> titles;
    List<String> content;

    public Adapter(List<String> Titles, List<String> Content){
        this.titles = Titles;
        this.content = Content;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_layout,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.notecontent.setText(content.get(position));
        holder.notetitle.setText(titles.get(position));
        final int codeRandom = holder.view.getResources().getColor(getRandomColor(), null);
        Log.d("Color = ", Integer.toString(codeRandom));
        holder.cardView.setCardBackgroundColor(codeRandom);
        holder.view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), NoteDetail.class);
                i.putExtra("content", content.get(position));
                i.putExtra("title", titles.get(position));
                i.putExtra("color", codeRandom);
                v.getContext().startActivity(i);
            }
        });


    }

    private int getRandomColor() {
        List<Integer> colorCode = new ArrayList<Integer>();
        colorCode.add(R.color.Red);
        colorCode.add(R.color.Purple);
        colorCode.add(R.color.Blue);
        colorCode.add(R.color.Green);
        colorCode.add(R.color.Yellow);
        colorCode.add(R.color.Orange);

        Random randomcolor = new Random();
        int number = randomcolor.nextInt(colorCode.size());
        return colorCode.get(number);
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView notetitle, notecontent;
        View view;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            notetitle = itemView.findViewById(R.id.titles);
            notecontent = itemView.findViewById(R.id.content);
            cardView = itemView.findViewById(R.id.noteCard);
            view = itemView;

        }
    }
}
