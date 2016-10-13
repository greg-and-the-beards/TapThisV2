package com.tapthis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.tapthis.entity.ReviewInfo;
import com.tapthis.entity.UserInfo;
import com.tapthis.service.ReviewService;
import com.tapthis.service.UserService;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebsiteController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ReviewService reviewService;
	
	//index
	@RequestMapping("/")
	public ModelAndView home(ModelAndView mv) {
		mv.setViewName("index");
		return mv;
 	}
	
	// HttpSession example
	// java: @RequestMapping("/")
	//public ModelAndView home(ModelAndView mv, HttpSession sessionObj) {
	//	sessionObj.setAttribute("message", "blah blah blah");
	//	mv.setViewName("index");
	//	return mv; }
	// html: in a span or div >>> <span th:text = "${session.message}"></span>
	// to end a session: session.invalidate();
	
	//user search results page with multiple beers
	@RequestMapping("/APIResults")
	public ModelAndView APIResults(ModelAndView mv) {
		return mv;
 	}
	
	//specific beer selected from APIResults page

	@RequestMapping("/beerDetails")
	public ModelAndView beerDetails(ModelAndView mv) {
		return mv;
 	}
	
	// registration page form for writing one user to database
	@RequestMapping("/register")
	public ModelAndView register(ModelAndView mv) {
		return mv;
	}

	// POST one user to user table
	@RequestMapping(value= "/user", method = RequestMethod.POST)
	public ModelAndView eachUser(@ModelAttribute UserInfo user, ModelAndView mv) {
        userService.addUser(user);
        return new ModelAndView("redirect:/");
	}
	
	// GET one user from user table
	@RequestMapping("/updateUser/{id}")
	public ModelAndView editUser(@PathVariable("id") int id, ModelAndView mv) {
		mv.addObject("user", this.userService.getUserById(id));
		mv.setViewName("updateUser");
		return mv;
	}
	
	// PUT one user to user table
	@RequestMapping(value="/updateUser/{id}", method = RequestMethod.POST )
	public ModelAndView updateUser(@ModelAttribute UserInfo user, @PathVariable("id") int id, ModelAndView mv) {
		mv.addObject("user", this.userService.getUserById(id));
		userService.updateUser(user);
		return new ModelAndView("redirect:/");
	}
	
	//has not been implemented
	//DELETE one user to user table
	@RequestMapping(value="/user/{id}", method = RequestMethod.DELETE )
	public ResponseEntity<UserInfo> deleteUser(@PathVariable("id") Integer userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<UserInfo>(HttpStatus.NO_CONTENT);
	}	

	// POST one review to review table
	@RequestMapping(value= "/beerDetails", method = RequestMethod.POST)
	public ModelAndView eachReview(@ModelAttribute ReviewInfo review, ModelAndView mv) {
		reviewService.addReview(review);
        return new ModelAndView("redirect:/");
	}
	
	
	//GET all reviews by one beerName from review table
	@RequestMapping("/beerDetails?beerInfo={breweryName}{beerName}}")
	public ModelAndView getReviewsByBeerName(@PathVariable("brewery") String breweryName, @PathVariable("beerName") String beerName, ModelAndView mv) {
		mv.addObject("review", this.reviewService.getReviewByBeerName(beerName, breweryName));
		mv.setViewName("beerDetails");
		return mv;
	}
	
//	
//	
//	
}