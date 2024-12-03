package com.jsp_spring.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jsp_spring.demo.entity.Laptop;
import com.jsp_spring.demo.repository.LaptopRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {   
	
	@Autowired
	private LaptopRepository laptopRepository;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/updateData")
	public String update() {
		return "updateData";
	}
	
	/*@PostMapping("/saveLaptopData")
	@ResponseBody
	public String saveData(@RequestParam("id") int id,@RequestParam("brand") String brand, @RequestParam("price") String price) {
	   Laptop laptop=new Laptop(id, brand, price);
	   Laptop lap1 = laptopRepository.save(laptop);
	   System.out.println(lap1);
	   return "Data saved successfully!!!";	
	}*/
	
	@PostMapping("/saveLaptopData")
	@ResponseBody
	public String saveData(Laptop laptop) {
	   laptopRepository.save(laptop);
	   return "Data saved successfully!!!";	
	}
	
	@GetMapping("/getSingleLaptop/{id}")	
	public String getSingleData(@PathVariable int id, HttpSession session) {
		Optional<Laptop> findById = laptopRepository.findById(id);
		Laptop laptop = findById.get();
		session.setAttribute("laptop",laptop);
		return "showSingleData";
	}
	
	/*@GetMapping("/getAllLaptop")	
	public String getAllLaptop(HttpSession session){
		List<Laptop> findAllLaptop = laptopRepository.findAll();
		session.setAttribute("AllLaptop", findAllLaptop);
		return "showAllLaptopList";
	}*/
	
	@GetMapping("/getAllLaptop")	
	public ModelAndView getAllLaptop(HttpSession session){
		ModelAndView mv = new ModelAndView();
		List<Laptop> findAllLaptop = laptopRepository.findAll();
		mv.addObject("AllLaptop", findAllLaptop);
		mv.setViewName("showAllLaptopList");
		return mv;
	}
	
	@PostMapping("/updateLaptopData")
	@ResponseBody
	public String updateLaptopData(@RequestBody Laptop laptop) {
		Laptop laptop1 = laptopRepository.save(laptop);
		System.out.println(laptop1);
		return "Updated Successfully!!";
	}
	
	@GetMapping("/deleteData/{id}")
	@ResponseBody
	public String DeleteData(@PathVariable int id) {
	    Optional<Laptop> findById = laptopRepository.findById(id);
	    if (findById.isPresent()) {
	        Laptop laptop = findById.get();
	        laptopRepository.delete(laptop);
	        return "Data Deleted Successfully!!!";
	    } else {
	        return "Laptop not found!";
	    }
	}
	
}
