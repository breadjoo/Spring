package sample;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class sampletest1 {
	private static final Logger logger = LoggerFactory.getLogger(sampletest1.class);
	
	@RequestMapping
	public String home(Locale locale, Model model) {
		logger.info("welcome {}.", locale);
		
		Date date = new Date();
		DateFormat dateformat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateformat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		
		System.out.println(this);
		
		return "home";
	}

}
