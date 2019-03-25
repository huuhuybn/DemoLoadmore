package vn.e.demoloadmore;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

class StudentHolder extends RecyclerView.ViewHolder {

    public TextView tvName;
    public TextView tvClass;


    public StudentHolder(@NonNull View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.tvName);
        tvClass = itemView.findViewById(R.id.tvClass);
    }
}
