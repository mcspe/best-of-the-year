package org.java.app.media;

import java.util.concurrent.atomic.AtomicInteger;

public class Movie {

	private static final AtomicInteger count = new AtomicInteger(0);
	private int id;
	private String title;
	private int year;
	private String img;

	public Movie(String title, int year, String img) {
		setId();
		setTitle(title);
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
		return getTitle() + " (" + getYear() + ")";
	}
	
}
