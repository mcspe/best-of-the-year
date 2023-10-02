package org.java.app.media;

public class Song {
	
	private int id;
	private String title;
	private String artist;
	private int year;

	public Song(String title, String artist, int year) {
		setId();
		setTitle(title);
		setArtist(artist);
		setYear(year);
	}

	public int getId() {
		return id;
	}

	private void setId() {
		id++;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return getArtist() + " - " + getTitle() + " (" + getYear() + ")";
	}
}
