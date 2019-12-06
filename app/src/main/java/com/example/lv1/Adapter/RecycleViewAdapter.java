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

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.StudentViewHolder> {

    public static final int HEAD = 0;
    public static final int LIST = 1;
    private MyDataStorage myDataStorage = MyDataStorage.getInstance();
    private List<Student>lStudenti = myDataStorage.getlStudents();
    public RecycleViewAdapter(List<Student>myDataset)
    {
        lStudenti = myDataset;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if(viewType == HEAD){
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.header, viewGroup, false);
            StudentViewHolder holder = new StudentViewHolder(view, viewType);
            return holder;
        }
        else if(viewType == LIST){
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.studenti_layout, viewGroup, false);
            StudentViewHolder holder = new StudentViewHolder(view, viewType);
            return holder;
        }
        return null;

    }


    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        if(holder.view_type== LIST){
            holder.ime.setText(lStudenti.get(position-1).getIme());
            holder.prezime.setText(lStudenti.get(position-1).getPrezime());
            holder.predmet.setText(lStudenti.get(position-1).getPredmet());
        }
        else if(holder.view_type == HEAD){
            holder.header.setText(R.string.studenti);
        }

    }

    @Override
    public int getItemCount() {
        return lStudenti.size() + 1;
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder
    {
        int view_type;
        TextView ime;
        TextView prezime;
        TextView predmet;
        TextView header;
        public StudentViewHolder(@NonNull View itemView, int viewType)
        {
            super(itemView);
            if(viewType == LIST) {
                ime = itemView.findViewById(R.id.studentIme);
                prezime = itemView.findViewById(R.id.prezime);
                predmet = itemView.findViewById(R.id.predmet);
                view_type = 1;
            }
            else if(viewType == HEAD)
            {
                header = itemView.findViewById(R.id.studentiHeader);
                view_type = 0;
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return HEAD;
        }
        else{
            return LIST;
        }
    }

}
