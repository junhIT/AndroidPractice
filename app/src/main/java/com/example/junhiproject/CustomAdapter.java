package com.example.junhiproject;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    Context mContext;
    public ArrayList<Dictionary> mList;
    private OnItemClickListener mListener = null;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener = listener;
    }

    public interface OnItemClickListener{
        void onItemClick(View v, int position);
    }

    public CustomAdapter(ArrayList<Dictionary> list, Context context){
        this.mContext = context;
        this.mList = list;

    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected ImageView image;
        protected TextView title;
        protected TextView date;
        protected TextView name;

        public CustomViewHolder(@NonNull View view) {
            super(view);
            this.image = (ImageView) view.findViewById(R.id.item_image);
            this.title = (TextView) view.findViewById(R.id.item_title);
            this.date = (TextView) view.findViewById(R.id.item_date);
            this.name = (TextView) view.findViewById(R.id.item_name);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        if(mListener != null) {
                            mListener.onItemClick(v, pos);
                        }
                    }
                }
            });
        }

    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_memo_item, viewGroup, false);

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, int position) {
        viewholder.title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        viewholder.date.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        viewholder.name.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);


        viewholder.image.setImageResource(mContext.getResources().getIdentifier("pimg"+mList.get(position).getImage(), "drawable", mContext.getPackageName()));


        viewholder.title.setGravity(Gravity.CENTER);
        viewholder.date.setGravity(Gravity.CENTER);
        viewholder.name.setGravity(Gravity.CENTER);

        viewholder.title.setText(mList.get(position).getTitle());
        viewholder.date.setText(mList.get(position).getDate());
        viewholder.name.setText(mList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }


}
