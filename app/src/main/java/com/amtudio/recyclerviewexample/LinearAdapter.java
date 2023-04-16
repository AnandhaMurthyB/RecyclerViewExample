package com.amtudio.recyclerviewexample;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList<String> linearList;

    public LinearAdapter(Context context, Activity activity, ArrayList<String> linearList)
    {
        this.context = context;
        this.activity = activity;
        this.linearList = linearList;
    }

    @NonNull
    @Override
    public LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.single_linear_layout, parent, false);
        return new LinearViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LinearViewHolder holder, int position)
    {
        String text = linearList.get(position);
        holder.textView.setText(text);
    }

    @Override
    public int getItemCount() {
        return linearList.size();
    }

    public class LinearViewHolder extends RecyclerView.ViewHolder
    {
        private TextView textView;

        public LinearViewHolder(@NonNull View itemView)
        {
            super(itemView);
            textView = itemView.findViewById(R.id.textview);
        }
    }
}
