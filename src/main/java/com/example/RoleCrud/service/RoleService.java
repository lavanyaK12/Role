package com.example.RoleCrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RoleCrud.domain.Role;
import com.example.RoleCrud.repository.RoleRepository;
import java.util.*;

@Service
public class RoleService {
	
	@Autowired
    private RoleRepository repo;
	
	public List<Role> listAll() {
       return repo.findAll();
      
        
    }
     
    public void save(Role rll) {
        repo.save(rll);
    }
     
    public Role get(long id) {
       return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
	

}
