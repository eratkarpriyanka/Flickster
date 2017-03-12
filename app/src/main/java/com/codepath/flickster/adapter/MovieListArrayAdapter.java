package com.codepath.flickster.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.flickster.R;
import com.codepath.flickster.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieListArrayAdapter extends ArrayAdapter<Movie>{

    Context context;

    public MovieListArrayAdapter(Context context, List<Movie>movieList){

        super(context, android.R.layout.simple_list_item_1,movieList);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // get data for view
        Movie movie =  getItem(position);

        ViewHolder viewHolder;
        // check existing view being used
        if(convertView == null){

            LayoutInflater inflator = LayoutInflater.from(getContext());
            convertView = inflator.inflate(R.layout.list_item_movie,parent,false);
            ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivPoster);
            TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            TextView tvSynopsis = (TextView) convertView.findViewById(R.id.tvSynopsis);
            viewHolder = new ViewHolder(ivImage,tvTitle,tvSynopsis);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        
        Picasso.with(context).load(movie.getPosterPath()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(viewHolder.ivImage);
        viewHolder.tvTitle.setText(movie.getTitle());
        viewHolder.tvSynopsis.setText(movie.getSynosis());

        // populate data to view


        return convertView;
    }

    private class ViewHolder{

        ImageView ivImage;
        TextView tvTitle;
        TextView tvSynopsis;

        public ViewHolder(ImageView ivImage,TextView tvTitle,TextView tvSynopsis){

            this.ivImage = ivImage;
            this.tvTitle = tvTitle;
            this.tvSynopsis = tvSynopsis;
        }
    }
}
