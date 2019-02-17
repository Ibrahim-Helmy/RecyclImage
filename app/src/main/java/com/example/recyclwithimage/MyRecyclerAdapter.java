package com.example.recyclwithimage;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {
    Context context;
    List<Image> images = new ArrayList<>();

    public MyRecyclerAdapter(Context context, List<Image> images) {
        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.custom_row, viewGroup, false);
        return new MyViewHolder(view, context, images);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Image image = images.get(i);


        myViewHolder.imageView.setImageResource(image.getImage());
        myViewHolder.title.setText(image.getTitle());
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public void updateRecycle(List<Image> newList) {
        images = new ArrayList<>();
        images.addAll(newList);
        notifyDataSetChanged();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        Context context;
        List<Image> images;

        public MyViewHolder(@NonNull View itemView, final Context context, final List<Image> images) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_id);
            title = itemView.findViewById(R.id.txt_title);


            this.context = context;
            this.images = images;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DisplayImageActivity.class);
                    Image image = images.get(getAdapterPosition());
                    intent.putExtra("i", image);
                    context.startActivity(intent);
                }
            });
        }
    }
}
