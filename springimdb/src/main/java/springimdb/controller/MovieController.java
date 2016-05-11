package springimdb.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springimdb.dataacess.IMovieDAO;
import springimdb.model.Movie;

@Controller
public class MovieController {
	
	 @Resource
	    private IMovieDAO movieDao;

	    @RequestMapping("/")
	    public String redirectRoot() {
	        return "redirect:/Movies";
	    }

	    @RequestMapping(value = "/Movies", method = RequestMethod.GET)
	    public String getAll(Model model) {
	        model.addAttribute("Movies", movieDao.getMovies());
	        return "MovieList";
	    }

	    @RequestMapping(value = "/Movies", method = RequestMethod.POST)
	    public String add(Movie movie) {
	        movieDao.saveMovie(movie);
	        return "redirect:/Movies";
	    }

	    @RequestMapping(value = "/Movies/{title}", method = RequestMethod.GET)
	    public String get(@PathVariable String title, Model model) {
	        model.addAttribute("Movie", movieDao.loadMovie(title));
	        return "MovieDetail";
	    }

	    @RequestMapping(value = "/Movies/{id}", method = RequestMethod.POST)
	    public String update(Movie movie, @PathVariable int id) {
	        movieDao.updateMovie(movie); // Movie.id already set by binding
	        return "redirect:/Movies";
	    }

	

	   

}
