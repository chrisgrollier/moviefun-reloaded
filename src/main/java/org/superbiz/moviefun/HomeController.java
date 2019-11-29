package org.superbiz.moviefun;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	private final MoviesBean moviesBean;

	public HomeController(MoviesBean moviesBean) {
		super();
		this.moviesBean = moviesBean;
	}

	@GetMapping("/setup")
	public String setup(Model model) {
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie("Wedding Crashers", "David Dobkin", "Comedy", 7, 2005));
		movies.add(new Movie("Wedding Crashers", "David Dobkin", "Comedy", 7, 2005));
		movies.add(new Movie("Starsky & Hutch", "Todd Phillips", "Action", 6, 2004));
		movies.add(new Movie("Shanghai Knights", "David Dobkin", "Action", 6, 2003));
		movies.add(new Movie("I-Spy", "Betty Thomas", "Adventure", 5, 2002));
		movies.add(new Movie("The Royal Tenenbaums", "Wes Anderson", "Comedy", 8, 2001));
		movies.add(new Movie("Zoolander", "Ben Stiller", "Comedy", 6, 2001));
		movies.add(new Movie("Shanghai Noon", "Tom Dey", "Comedy", 7, 2000));
		this.moviesBean.addMovies(movies);
		model.addAttribute("movies", this.moviesBean.getMovies());
		return "setup";
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
