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

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder>
{
    private Context context;
    private Activity activity;
    private ArrayList<String> gridList;

    public GridAdapter(Context context, Activity activity, ArrayList<String> gridList)
    {
        this.context = context;
        this.activity = activity;
        this.gridList = gridList;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.single_grid_layout, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position)
    {
        String text = gridList.get(position);

        holder.textView.setText(text);

    }

    @Override
    public int getItemCount() {
        return gridList.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder
    {
        private TextView textView;

        public GridViewHolder(@NonNull View itemView)
        {
            super(itemView);
            textView = itemView.findViewById(R.id.textview);
        }
    }
}
