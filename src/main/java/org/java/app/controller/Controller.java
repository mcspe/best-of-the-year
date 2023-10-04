package org.java.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.java.app.media.Movie;
import org.java.app.media.Song;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@org.springframework.stereotype.Controller
public class Controller {
	
	private final List<Movie> bestMovies = new ArrayList<>();
	
	private void createBestMovies() {
		bestMovies.removeAll(bestMovies);
		bestMovies.add(new Movie("Inception", 2010, "https://mr.comingsoon.it/imgdb/locandine/big/47397.jpg"));
		bestMovies.add(new Movie("Fight Club", 1999, "https://mypostercollection.com/wp-content/uploads/2018/07/Fight-Club-MyPosterCollection.com-1.jpg"));
		bestMovies.add(new Movie("Into the Wild", 2007, "https://img.fruugo.com/product/2/47/14585472_max.jpg"));
		bestMovies.add(new Movie("Captain Fantastic", 2016, "https://mr.comingsoon.it/imgdb/locandine/big/53268.jpg"));	
	}
	
	private final List<Song> bestSongs = new ArrayList<>();
	
	private void createBestSongs() {
		bestSongs.removeAll(bestSongs);
		bestSongs.add(new Song("Hey you", "Pink Floyd", 1979, "https://i.scdn.co/image/ab67616d0000b2735d48e2f56d691f9a4e4b0bdf"));
		bestSongs.add(new Song("Shine on you Crazy Diamond", "Pink Floyd", 1975, "https://i.scdn.co/image/ab67616d0000b2731a84d71391df7469c5ab8539"));
		bestSongs.add(new Song("Spirit Bird", "Xavier Rudd", 2012, "https://upload.wikimedia.org/wikipedia/en/9/99/Spirit_Bird_by_Xavier_Rudd.jpg"));
		bestSongs.add(new Song("Hotel California", "Eagles", 1976, "https://upload.wikimedia.org/wikipedia/en/4/49/Hotelcalifornia.jpg"));
	}
	
	@GetMapping("/")
	public String index(Model model) {
		createBestMovies();
		createBestSongs();
		final String page = "home";
		final String name = "Marco";
		model.addAttribute("page", page);
		model.addAttribute("name", name);
		return "index";
	}
	
	@GetMapping("/movies")
	public String movie(Model model) {
		final List<Movie> bestMovies = getBestMovies();
//		final String movies = bestMovies.stream()
//								.map(m -> m.toString())
//								.collect(Collectors.joining(", "));
		final String page = "movies";
		model.addAttribute("page", page);
		model.addAttribute("movies", bestMovies);
		return "index";
	}
	
	@GetMapping("/songs")
	public String song(Model model) {
		final List<Song> bestSongs = getBestSongs();
//		final String songs = bestSongs.stream()
//				.map(s -> s.toString())
//				.collect(Collectors.joining(", "));
		final String page = "songs";
		model.addAttribute("page", page);
		model.addAttribute("songs", bestSongs);
		return "index";
	}

	private List<Movie> getBestMovies() {
		return bestMovies;
	}
	
	private List<Song> getBestSongs() {
		return bestSongs;
	}
	
	@GetMapping("/details/{mediaType}/{id}")
	public String detail(@PathVariable String mediaType, @PathVariable int id, Model model) {
		final String page = "details";
		model.addAttribute("page", page);
		if (mediaType.equalsIgnoreCase("songs")) {
			List<Song> song = getBestSongs().stream()
							.filter(s -> id == s.getId())
							.collect(Collectors.toList());
			model.addAttribute("media", song.get(0));
			model.addAttribute("mediaType", "song");
		}
		if (mediaType.equalsIgnoreCase("movies")) {
			List<Movie> movie = getBestMovies().stream()
							.filter(m -> id == m.getId())
							.collect(Collectors.toList());
			model.addAttribute("media", movie.get(0));
			model.addAttribute("mediaType", "movie");
		}
		return "index";
	}
	
}
