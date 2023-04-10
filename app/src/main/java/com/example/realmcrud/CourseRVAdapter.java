package com.example.realmcrud;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CourseRVAdapter extends RecyclerView.Adapter<CourseRVAdapter.ViewHolder> {

    // variable for our array list and context
    private List<DataModel> dataModalArrayList;
    private Context context;

    public CourseRVAdapter(List<DataModel> dataModalArrayList, Context context) {
        this.dataModalArrayList = dataModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CourseRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseRVAdapter.ViewHolder holder, int position) {
        DataModel modal = dataModalArrayList.get(position);
        holder.courseNameTV.setText(modal.getC_name());
        holder.courseDescTV.setText(modal.getC_desc());
        holder.courseDurationTV.setText(modal.getC_dur());
        holder.courseTracksTV.setText(modal.getC_track());

        // adding on click listener for item of recycler view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are creating a new intent.
                Intent i = new Intent(context, UpdateCourseActivity.class);
                // on below line we are passing all the data to new activity.
                i.putExtra("courseName", modal.getC_name());
                i.putExtra("courseDescription", modal.getC_desc());
                i.putExtra("courseDuration", modal.getC_dur());
                i.putExtra("courseTracks", modal.getC_track());
                i.putExtra("id", modal.getId());
                // on below line we are starting a new activity.
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our text views.
        private TextView courseNameTV, courseDescTV, courseDurationTV, courseTracksTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            courseNameTV = itemView.findViewById(R.id.idTVCourseName);
            courseDescTV = itemView.findViewById(R.id.idTVCourseDescription);
            courseDurationTV = itemView.findViewById(R.id.idTVCourseDuration);
            courseTracksTV = itemView.findViewById(R.id.idTVCourseTracks);
        }
    }
}
