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
		bestMovies.add(new Movie("Inception", 2010));
		bestMovies.add(new Movie("Fight Club", 1999));
		bestMovies.add(new Movie("Into the Wild", 2007));
		bestMovies.add(new Movie("Captain Fantastic", 2016));	
	}
	
	private final List<Song> bestSongs = new ArrayList<>();
	
	private void createBestSongs() {
		bestSongs.removeAll(bestSongs);
		bestSongs.add(new Song("Hey you", "Pink Floyd", 1979));
		bestSongs.add(new Song("Shine on you Crazy Diamond", "Pink Floyd", 1975));
		bestSongs.add(new Song("Spirit Bird", "Xavier Rudd", 2012));
		bestSongs.add(new Song("Hotel California", "Eagles", 1976));
	}
	
	@GetMapping("/")
	public String index(Model model) {
		createBestMovies();
		createBestSongs();
		final String name = "Marco";
		model.addAttribute("name", name);
		return "index";
	}
	
	@GetMapping("/movies")
	public String movie(Model model) {
		final List<Movie> bestMovies = getBestMovies();
//		final String movies = bestMovies.stream()
//								.map(m -> m.toString())
//								.collect(Collectors.joining(", "));
		model.addAttribute("movies", bestMovies);
		return "movies";
	}
	
	@GetMapping("/songs")
	public String song(Model model) {
		final List<Song> bestSongs = getBestSongs();
//		final String songs = bestSongs.stream()
//				.map(s -> s.toString())
//				.collect(Collectors.joining(", "));
		model.addAttribute("songs", bestSongs);
		return "songs";
	}

	private List<Movie> getBestMovies() {
		return bestMovies;
	}
	
	private List<Song> getBestSongs() {
		return bestSongs;
	}
	
	@GetMapping("/details/{mediaType}/{id}")
	public String detail(@PathVariable String mediaType, @PathVariable int id, Model model) {
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
		return "details";
	}
	
}
