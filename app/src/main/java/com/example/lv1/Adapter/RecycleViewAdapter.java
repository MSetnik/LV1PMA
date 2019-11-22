package com.example.lv1.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lv1.Model.Student;
import com.example.lv1.R;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Student>lStudenti;

    public RecycleViewAdapter(List<Student>myDataset)
    {
        lStudenti = myDataset;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        TextView view  = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.studenti_layout,viewGroup, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        StudentViewHolder myViewHolder = (StudentViewHolder)holder;
        myViewHolder.customTextView.setText(lStudenti.get(position).getIme());
    }

    @Override
    public int getItemCount() {
        return lStudenti.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder
    {
        TextView customTextView;
        public StudentViewHolder(@NonNull View itemView)
        {
            super(itemView);
            customTextView = itemView.findViewById(R.id.studentImePrezime);
        }

    }
}
