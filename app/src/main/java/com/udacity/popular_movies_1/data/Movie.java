package com.udacity.popular_movies_1.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Movie implements Parcelable {
    private static final String baseUrl = "http://image.tmdb.org/t/p/w500";
    private static final SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat outputDateFormat = new SimpleDateFormat("d MMMM yyyy");
    String title;
    String releaseDate;
    String moviePoster; // url
    double voteAverage;
    String plotSypnosis;

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() throws ParseException {
        return outputDateFormat.format(inputDateFormat.parse(releaseDate));
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public String getPlotSypnosis() {
        return plotSypnosis;
    }

    public Movie(String title, String releaseDate, String moviePoster, double voteAverage, String plotSypnosis) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.moviePoster = baseUrl + moviePoster;
        this.voteAverage = voteAverage;
        this.plotSypnosis = plotSypnosis;
    }

    private Movie(Parcel in) {
        title = in.readString();
        releaseDate = in.readString();
        moviePoster = in.readString();
        voteAverage = in.readDouble();
        plotSypnosis = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(releaseDate);
        dest.writeString(moviePoster);
        dest.writeDouble(voteAverage);
        dest.writeString(plotSypnosis);
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel parcel) {
            return new Movie(parcel);
        }

        @Override
        public Movie[] newArray(int i) {
            return new Movie[i];
        }
    };
}
