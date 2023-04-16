package com.amtudio.recyclerviewexample;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.StaggeredGridViewHolder>
{
    private Context context;
    private Activity activity;
    private ArrayList<String> staggeredGridList;

    public StaggeredGridAdapter(Context context, Activity activity, ArrayList<String> staggeredGridList)
    {
        this.context = context;
        this.activity = activity;
        this.staggeredGridList = staggeredGridList;
    }
    @NonNull
    @Override
    public StaggeredGridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.single_staggered_grid_layout, parent, false);
        return new StaggeredGridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StaggeredGridViewHolder holder, int position) {

        String text = staggeredGridList.get(position);

        if (position % 2 == 0)
        {
            holder.relativeLayout_1.setVisibility(View.VISIBLE);
            holder.relativeLayout_2.setVisibility(View.GONE);
            holder.textView_1.setVisibility(View.VISIBLE);
            holder.textView_2.setVisibility(View.GONE);

            holder.textView_1.setText(text);
        }
        else
        {
            holder.relativeLayout_2.setVisibility(View.VISIBLE);
            holder.relativeLayout_1.setVisibility(View.GONE);
            holder.textView_2.setVisibility(View.VISIBLE);
            holder.textView_1.setVisibility(View.GONE);

            holder.textView_2.setText(text);
        }
    }

    @Override
    public int getItemCount() {
        return staggeredGridList.size();
    }

    public class StaggeredGridViewHolder extends RecyclerView.ViewHolder
    {
        private TextView textView_1, textView_2;
        private RelativeLayout relativeLayout_1, relativeLayout_2;

        public StaggeredGridViewHolder(@NonNull View itemView)
        {
            super(itemView);
            textView_1 = itemView.findViewById(R.id.textview_1);
            textView_2 = itemView.findViewById(R.id.textview_2);
            relativeLayout_1 = itemView.findViewById(R.id.relativelayout_1);
            relativeLayout_2 = itemView.findViewById(R.id.relativelayout_2);
        }
    }
}
