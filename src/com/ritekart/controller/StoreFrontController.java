package com.ritekart.controller;
 
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ritekart.daoImpl.CategoryDAOImpl;
import com.ritekart.model.Category;
import com.ritekart.service.CategoryService;
 
/*
 * author: Crunchify.com
 * 
 */
 
@RestController
//@Controller
//@Scope("prototype")
public class StoreFrontController {
	private static final Logger logger = LoggerFactory.getLogger(CategoryDAOImpl.class);
	private CategoryService categoryService;
	int randomNum;
	public StoreFrontController(){
		Random randomGenerator = new Random();
	    randomNum = randomGenerator.nextInt(100);
	    logger.info("random number:" + String.valueOf(randomNum));
	}
	@Autowired(required=true)
	@Qualifier(value="categoryService")
	public void setCategoryService(CategoryService cs){
		this.categoryService = cs;
	}
	/*
	// Show Login Form
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model, 
	        @RequestParam(value="error",defaultValue="") String error) {

	    // If fails to login
	    if (!error.isEmpty()){
	        model.addAttribute("error", "true");
	    }

	    return "login";

	}
	// Logout page
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {

	    return "login";

	}
	*/
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String executeSecurityAndLoadHomePage(ModelMap model){
//		String name = null;
//		Set<SimpleGrantedAuthority> role = new HashSet<SimpleGrantedAuthority>();
//		//Check if user is logged in
//		
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		if (!(auth instanceof AnonymousAuthenticationToken)) {
//			//get the user details
//			UserDetails userDetail = (UserDetails) auth.getPrincipal();
//			name = userDetail.getUsername();
//			role = (Set<SimpleGrantedAuthority>) userDetail.getAuthorities();
//		}
//		//set the model attributes
//		model.addAttribute("accountname", name);
//        model.addAttribute("userRole", role);
//
//        // go to Home page
//        return "welcome";
//	}
	
	
	@RequestMapping(value="/welcome", method=RequestMethod.GET, produces = "text/html")
	public ModelAndView helloWorld() {
		 
		
		return new ModelAndView("welcome", "message", this.categoryService.listCategory());
	}
	
	 @RequestMapping("/cart")
		public ModelAndView cart() {
	 
			String message = "<br><div style='text-align:center;'>"
					+ "<h3>********** cart</div><br><br>";
			return new ModelAndView("cart", "message", message);
		}
	 
	 @RequestMapping("/category")
		public ModelAndView category() {
	 
			String message = "<br><div style='text-align:center;'>"
					+ "<h3>********** category</div><br><br>";
			return new ModelAndView("category", "message", message);
		}
}