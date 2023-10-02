package org.java.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.java.app.media.Movie;
import org.java.app.media.Song;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@org.springframework.stereotype.Controller
public class Controller {
	
	@GetMapping("/")
	public String index(Model model) {
		final String name = "Marco";
		model.addAttribute("name", name);
		return "index";
	}
	
	@GetMapping("/movies")
	public String movie(Model model) {
		final List<Movie> bestMovies = getBestMovies();
		final String movies = bestMovies.stream()
								.map(m -> m.toString())
								.collect(Collectors.joining(", "));
		model.addAttribute("movies", movies);
		return "movies";
	}
	
	@GetMapping("/songs")
	public String song(Model model) {
		final List<Song> bestSongs = getBestSongs();
		final String songs = bestSongs.stream()
				.map(s -> s.toString())
				.collect(Collectors.joining(", "));
		model.addAttribute("songs", songs);
		return "songs";
	}

	private List<Movie> getBestMovies() {
		final List<Movie> bestMovies = new ArrayList<>();
		bestMovies.add(new Movie("Inception", 2010));
		bestMovies.add(new Movie("Fight Club", 1999));
		bestMovies.add(new Movie("Into the Wild", 2007));
		bestMovies.add(new Movie("Captain Fantastic", 2016));
		return bestMovies;
	}
	
	private List<Song> getBestSongs() {
		final List<Song> bestSongs = new ArrayList<>();
		bestSongs.add(new Song("Hey you", "Pink Floyd", 1979));
		bestSongs.add(new Song("Shine on you Crazy Diamond", "Pink Floyd", 1975));
		bestSongs.add(new Song("Spirit Bird", "Xavier Rudd", 2012));
		bestSongs.add(new Song("Hotel California", "Eagles", 1976));
		return bestSongs;
	}
	
}
