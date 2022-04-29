package ch03;

import java.util.ArrayList;
import java.util.List;

import lombok.ToString;

@ToString
public class MovieData {
	String status;
	String status_message;
	Data data;
}

@ToString
class Data {
	String movie_count;
	int limit;
	int page_number;
	List<Movie> movies = new ArrayList<Movie>();
}

@ToString
class Movie {
	int id;
	String url;
	String imdb_code;
	String title;
	String slug;
	int year;
	double rating;
	int runtime;
	List<String> genres = new ArrayList<String>();
	String status;
	String background_image;
	String small_cover_image;
	String medium_cover_image;
	String large_cover_image;
}
