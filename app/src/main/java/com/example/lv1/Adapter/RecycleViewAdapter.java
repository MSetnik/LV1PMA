package com.example.lv1.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lv1.Model.MyDataStorage;
import com.example.lv1.Model.Student;
import com.example.lv1.R;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private MyDataStorage myDataStorage = MyDataStorage.getInstance();
    List<Student>lStudenti = myDataStorage.getlStudents();

    public RecycleViewAdapter(List<Student>myDataset)
    {
        lStudenti = myDataset;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.studenti_layout,viewGroup, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        StudentViewHolder myViewHolder = (StudentViewHolder)holder;
        myViewHolder.Ime.setText(lStudenti.get(position).getIme());
        myViewHolder.prezime.setText(lStudenti.get(position).getPrezime());
        myViewHolder.predmet.setText(lStudenti.get(position).getPredmet());
    }

    @Override
    public int getItemCount() {
        return lStudenti.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder
    {
        TextView Ime;
        TextView prezime;
        TextView predmet;
        public StudentViewHolder(@NonNull View itemView)
        {
            super(itemView);
            Ime = itemView.findViewById(R.id.studentIme);
            prezime = itemView.findViewById(R.id.prezime);
            predmet = itemView.findViewById(R.id.predmet);

        }

    }
}
