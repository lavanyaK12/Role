package com.example.RoleCrud.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.RoleCrud.domain.Role;
import com.example.RoleCrud.service.RoleService;

@RestController
public class RoleController {
	
	 @Autowired
	    private RoleService service;

	    @GetMapping("/abc")
	    public List<Role> listAll(){
	    	return  service.listAll();
	        
	    }

	   // @GetMapping("/new")
	   // public String add(Model model) {
	    //    model.addAttribute("role", new Role());
	   //     return "new";
	   // }

	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public ResponseEntity<String> saveStudent(@RequestBody Role rll) 
	    {
	        service.save(rll);
	        String msg="success";
	        return new ResponseEntity<>(msg,HttpStatus.OK) ;
	    }

	    @PutMapping("/edit/{id}")
	    public Role showEditRolePage(@RequestBody Role newrll , @PathVariable(name = "id") int id) {
	        Role rll=service.get(id);
	        rll.setRolename(newrll.getRolename());
	        service.save(rll);
	        return rll;
	        
	    }
	    @RequestMapping(value= "/delete/{id}", method=RequestMethod.DELETE)
	    public String deletestudent(@PathVariable(name = "id") int id) {
	        service.delete(id);
	        return "redirect:/";
	    }
	
	 
	

	
}
