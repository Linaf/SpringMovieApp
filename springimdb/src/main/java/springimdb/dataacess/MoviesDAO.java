package springimdb.dataacess;

import java.util.Collection;

//import org.hibernate.SessionFactory;

import springimdb.model.Movie;;

public class MoviesDAO implements IMovieDAO{

	private SessionFactory sf;	

	@SuppressWarnings("unchecked")
	public Collection<Movie> getMovies() {
		return sf.getCurrentSession().createQuery("select distinct a from Movie a " +
				"join fetch a.artists " +
				"join fetch a.director").list();
	}

	public Movie loadMovie(String title) {
		return (Movie) sf.getCurrentSession().get(Movie.class, title);
	}

	public void saveMovie(Movie movie){
		sf.getCurrentSession().persist(movie);
	}

	public void updateMovie(Movie movie) {
		sf.getCurrentSession().saveOrUpdate(movie);
	}

}
