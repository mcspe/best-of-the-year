package org.java.app.media;

import java.util.concurrent.atomic.AtomicInteger;

public class Song {
	
	private static final AtomicInteger count = new AtomicInteger(0);
	private int id;
	private String title;
	private String artist;
	private int year;
	private String img;

	public Song(String title, String artist, int year, String img) {
		setId();
		setTitle(title);
		setArtist(artist);
		setYear(year);
		setImg(img);
	}

	public int getId() {
		return id;
	}

	private void setId() {
		id = count.incrementAndGet();
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
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return getArtist() + " - " + getTitle() + " (" + getYear() + ")";
	}
}
