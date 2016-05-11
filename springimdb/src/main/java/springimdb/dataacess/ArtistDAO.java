package springimdb.dataacess;

import java.util.Collection;

//import org.hibernate.SessionFactory;

import springimdb.model.Artist;;

public class ArtistDAO implements IArtistDAO{

	private SessionFactory sf ;
	//= HibernateUtil.getSessionFactory();	

	@SuppressWarnings("unchecked")
	public Collection<Artist> getArtists() {
		return sf.getCurrentSession().createQuery("select distinct a from Artist a ").list();
	}

	public Artist loadArtist(String name) {
		return (Artist) sf.getCurrentSession().get(Artist.class, name);
	}

	public void saveArtist(Artist Artist){
		sf.getCurrentSession().persist(Artist);
	}

	public void updateArtist(Artist Artist) {
		sf.getCurrentSession().saveOrUpdate(Artist);
	}

}
