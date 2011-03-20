package org.xaab.springmvc;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		logger.info("Welcome home!");
		return "home";
	}
	
	@RequestMapping(value="/load", method=RequestMethod.POST)
	public @ResponseBody Map<String, ? extends Object> load(PersonalContact input) {
		logger.info("Inside load");
		PersonalContact pc = new PersonalContact(1L, "Wowi", "89281932", "wo.wi@abcxyz.com");
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("success",Boolean.TRUE);
		data.put("data", pc);
		
		return data;
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public @ResponseBody Map<String, ? extends Object> add(PersonalContact input, HttpSession session) {
		logger.info("Inside add");
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		if (input.getName() == null) {
			data.put("success",Boolean.FALSE);
			data.put("errorMessage", "No Name?");			
		} else if (session.getAttribute(input.getName()) != null) {
			data.put("success",Boolean.FALSE);
			data.put("errorMessage", "There is an existing data, unable to add. Please enter a different name");
		} else {
			session.setAttribute(input.getName(), input);
			data.put("success",Boolean.TRUE);
		}

		return data;
	}
}

