package sample.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/sample")
public class SampleController {

	@RequestMapping("")
	public void basic() {
		log.info("basic");
	}
	@GetMapping("/basicGet")
	public void basicGet() {
		log.info("basicGet() 메소드 실행");
	}
		
		@GetMapping("/ex01")
		public void ex01(SampleDTO dto) {
			
		}
		
		
		@GetMapping("/ex02")
		public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
			log.info("name : " + name);
			log.info("age : " + age);
			
			return "ex02";
		}
		
		@GetMapping("/ex02List")
		public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
			log.info("ids : " + ids);
			
			return "ex02List";
			
		}
}