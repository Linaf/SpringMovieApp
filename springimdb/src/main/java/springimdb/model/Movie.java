package springimdb.model;

import java.sql.Time;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Movie {
	@Id @GeneratedValue
	private long id;
	private String name;
	private String title;
	private String poster;
	private String summary;
	private String userComment;
	
	@ElementCollection
	@Enumerated(EnumType.STRING)
	private List<Genre> genres;
	private int year;
	
	@ManyToMany
    @JoinTable(name ="MOVIE_ARTIST", 
    		joinColumns = @JoinColumn(name="movieId"),
    		inverseJoinColumns=@JoinColumn(name="artistId"))
	private List<Artist> artists = new ArrayList<Artist>();
	private Artist director;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}

	public List<Artist> getArtists() {
		return artists;
	}

	public String getUserComment() {
		return userComment;
	}

	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public Artist getDirector() {
		return director;
	}

	public void setDirector(Artist director) {
		this.director = director;
	}

}
