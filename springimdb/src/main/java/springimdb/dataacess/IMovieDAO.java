package springimdb.dataacess;

import java.util.Collection;

import springimdb.model.Movie;
public interface IMovieDAO {
	public void saveMovie(Movie movie);
	public void updateMovie(Movie movie);
	public Movie loadMovie(String title);
	public Collection<Movie> getMovies();
}
