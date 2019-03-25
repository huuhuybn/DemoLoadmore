package vn.e.demoloadmore;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentHolder> {


    List<Student> students;
    Context context;


    public StudentAdapter(List<Student> students, Context context) {
        this.students = students;
        this.context = context;
    }

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.student, viewGroup, false);
        return new StudentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder studentHolder, int i) {

        studentHolder.tvName.setText(students.get(i).name);
        studentHolder.tvClass.setText(students.get(i).classID);

    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


}
