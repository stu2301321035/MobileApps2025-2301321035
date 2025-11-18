package com.example.mynotesapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynotesapp.MainActivity;
import com.example.mynotesapp.R;
import com.example.mynotesapp.UpdateNoteActivity;
import com.example.mynotesapp.model.Note;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    Context context;
    ArrayList<Note> arrayList = new ArrayList<>();

    public NoteAdapter(Context context, ArrayList<Note> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.note_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tvTitle.setText(arrayList.get(position).getTitle());
        holder.tcDesc.setText(arrayList.get(position).getDescription());



        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateNoteActivity.class);

                intent.putExtra("id", arrayList.get(position).getId());
                intent.putExtra("title", arrayList.get(position).getTitle());
                intent.putExtra("description", arrayList.get(position).getDescription());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle, tcDesc;
        CardView cardView;
        public ViewHolder(@NonNull View itemView){
            super(itemView);

            tcDesc = itemView.findViewById(R.id.tvDesc); // Use tvDesc
            tvTitle = itemView.findViewById(R.id.tvTitle); // Use tvTitle
            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}
