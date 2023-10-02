package org.java.app.media;

public class Movie {

	private int id;
	private String title;
	private int year;

	public Movie(String title, int year) {
		setId();
		setTitle(title);
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
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return getTitle() + " (" + getYear() + ")";
	}
	
}
