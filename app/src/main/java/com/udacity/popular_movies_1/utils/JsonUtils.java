package com.udacity.popular_movies_1.utils;

import com.udacity.popular_movies_1.data.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public final class JsonUtils {

    public static List getMoviesFromJson(String responseJsonStr)
        throws JSONException {
        final String title = "title";
        final String releaseDate = "release_date";
        final String moviePoster = "poster_path"; // url
        final String voteAverage = "vote_average";
        final String plotSypnosis = "overview";

        List movieList = new ArrayList<Movie>();
        JSONObject responseJsonObj = new JSONObject(responseJsonStr);

        // handle error?

        JSONArray moviesJsonArr = responseJsonObj.getJSONArray("results");

        if (moviesJsonArr.length() > 0) {
            for (int i = 0; i < moviesJsonArr.length(); i++) {
                JSONObject movieJsonObj = moviesJsonArr.getJSONObject(i);
                Movie movie = new Movie(
                        movieJsonObj.getString(title),
                        movieJsonObj.getString(releaseDate),
                        movieJsonObj.getString(moviePoster),
                        movieJsonObj.getString(voteAverage),
                        movieJsonObj.getString(plotSypnosis)
                );
                movieList.add(movie);
            }
        }
        return movieList;
    }
}
