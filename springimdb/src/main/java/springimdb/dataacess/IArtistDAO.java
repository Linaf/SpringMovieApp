package springimdb.dataacess;

import java.util.Collection;

import springimdb.model.Artist;

public interface IArtistDAO {
	public void saveArtist(Artist Artist);

	public void updateArtist(Artist Artist);

	public Artist loadArtist(String name);

	public Collection<Artist> getArtists();
}
