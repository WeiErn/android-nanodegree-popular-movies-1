package com.udacity.popular_movies_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.udacity.popular_movies_1.data.Movie;

import java.text.ParseException;

public class MovieActivity extends AppCompatActivity {
    private ImageView mMoviePosterImageView;
    private TextView mMovieTitleTextView;
    private TextView mMovieReleaseDateTextView;
    private TextView mMovieVoteAverageTextView;
    private TextView mMoviePlotSypnosisTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        mMoviePosterImageView = findViewById(R.id.movie_detail_poster);
        mMovieTitleTextView = findViewById(R.id.movie_detail_title);
        mMovieReleaseDateTextView = findViewById(R.id.movie_detail_release_date);
        mMovieVoteAverageTextView = findViewById(R.id.movie_detail_vote_average);
        mMoviePlotSypnosisTextView = findViewById(R.id.movie_detail_plot_sypnosis);

        Intent intent = getIntent();

        if (intent.hasExtra("movie")) {
            Movie movie = intent.getExtras().getParcelable("movie");
            Picasso.get().load(movie.getMoviePoster()).into(mMoviePosterImageView);
            getSupportActionBar().setTitle(movie.getTitle());
            mMovieTitleTextView.setText(movie.getTitle());
            try {
                mMovieReleaseDateTextView.setText(movie.getReleaseDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            mMovieVoteAverageTextView.setText(movie.getVoteAverage() + "/10");
            mMoviePlotSypnosisTextView.setText(movie.getPlotSypnosis());
        }
    }
}
