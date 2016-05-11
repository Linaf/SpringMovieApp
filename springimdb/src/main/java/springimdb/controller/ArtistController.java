package springimdb.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springimdb.dataacess.IArtistDAO;
import springimdb.model.Artist;

@Controller
public class ArtistController {
	 @Resource
	    private IArtistDAO artistDao;

	    @RequestMapping("/")
	    public String redirectRoot() {
	        return "redirect:/Artists";
	    }

	    @RequestMapping(value = "/Artists", method = RequestMethod.GET)
	    public String getAll(Model model) {
	        model.addAttribute("Artists", artistDao.getArtists());
	        return "ArtistList";
	    }

	    @RequestMapping(value = "/Artists", method = RequestMethod.POST)
	    public String add(Artist artist) {
	        artistDao.saveArtist(artist);
	        return "redirect:/Artists";
	    }

	    @RequestMapping(value = "/Artists/{title}", method = RequestMethod.GET)
	    public String get(@PathVariable String title, Model model) {
	        model.addAttribute("Movie", artistDao.loadArtist(title));
	        return "MovieDetail";
	    }

	    @RequestMapping(value = "/Artists/{id}", method = RequestMethod.POST)
	    public String update(Artist artist, @PathVariable int id) {
	        artistDao.updateArtist(artist); // Movie.id already set by binding
	        return "redirect:/Artists";
	    }

}
