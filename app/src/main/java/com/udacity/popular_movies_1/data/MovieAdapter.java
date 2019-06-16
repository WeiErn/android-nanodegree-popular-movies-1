package com.udacity.popular_movies_1.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.udacity.popular_movies_1.R;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieAdapterViewHolder> {

    private static final String TAG = MovieAdapter.class.getSimpleName();
    private List<Movie> mMovieData;
    private final MovieAdapterOnClickHandler mClickHandler;

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        Movie movie = getItem(position);
//
//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.movie, parent, false);
//        }
//
//        Uri uri = Uri.parse("http://image.tmdb.org/t/p/w185" + movie.moviePoster);
//        ImageView moviePosterView = convertView.findViewById(R.id.movie_poster);
//        moviePosterView.setImageURI(null);
//        moviePosterView.setImageURI(uri);
//
//        TextView titleView = convertView.findViewById(R.id.movie_title);
//        titleView.setText(movie.title);
//
//        TextView releaseDateView = convertView.findViewById(R.id.movie_release_date);
//        releaseDateView.setText(movie.releaseDate);
//
//        TextView voteAverageView =  convertView.findViewById(R.id.movie_vote_average);
//        voteAverageView.setText(String.valueOf(movie.voteAverage));
//
//        TextView plotSypnosisView = convertView.findViewById(R.id.movie_plot_sypnosis);
//        plotSypnosisView.setText(movie.plotSypnosis);
//
//        return convertView;
//    }

    public interface MovieAdapterOnClickHandler {
        void onClick(Movie movie);
    }

    public MovieAdapter(MovieAdapterOnClickHandler clickHandler) {
        mClickHandler = clickHandler;
    }

    public class MovieAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView mMovieTextView;

        public MovieAdapterViewHolder(View view) {
            super(view);
            mMovieTextView = view.findViewById(R.id.movie_title);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            mClickHandler.onClick(mMovieData.get(adapterPosition));
        }
    }

    @Override
    public MovieAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.movie;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        return new MovieAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieAdapterViewHolder movieAdapterViewHolder, int position) {
        Movie movieSelected = mMovieData.get(position);
        movieAdapterViewHolder.mMovieTextView.setText(movieSelected.toString());
    }

    @Override
    public int getItemCount() {
        if (null == mMovieData) return 0;
        return mMovieData.size();
    }

    public void setMovieData(List<Movie> movieData) {
        mMovieData = movieData;
        notifyDataSetChanged();
    }
}
