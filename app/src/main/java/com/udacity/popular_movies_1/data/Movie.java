package com.udacity.popular_movies_1.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    String title;
    String releaseDate;
    String moviePoster; // url
    double voteAverage;
    String plotSypnosis;

    public Movie(String title, String releaseDate, String moviePoster, double voteAverage, String plotSypnosis) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.moviePoster = moviePoster;
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

    public final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
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
