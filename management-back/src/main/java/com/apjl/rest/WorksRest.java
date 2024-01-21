package com.apjl.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apjl.dao.WorksDAO;
import com.apjl.model.Customers;
import com.apjl.model.Works;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("trabajos")
public class WorksRest {

	@Autowired
	private WorksDAO workDAO;
	
	@PostMapping("/nuevo")
	public void saveWork(@RequestBody Works work) {
		workDAO.save(work);
	}
	
	@GetMapping("/listar")
	public List<Works> listWorks(){
		return workDAO.findAll();
	}
	
	@GetMapping("/listar/{id}")
	public Works getWorkById(@PathVariable("id") Integer id){
		return workDAO.findById(id).get();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void deleteWork(@PathVariable("id") Integer id) {
		workDAO.deleteById(id);
	}
	
	@PutMapping("/actualizar/{id}")
	public void updateWork(@PathVariable("id") Integer id, @RequestBody Works work) {
		
		Works workAux = workDAO.findById(id).get();
		
		workAux.setName(work.getName());
		workAux.setDescription(work.getDescription());
		workAux.setAddress(work.getAddress());
		workAux.setCity(work.getCity());
		workAux.setPrice(work.getPrice());
		workAux.setPaid(work.getPaid());
		workAux.setCustomer(work.getCustomer());
		
		workDAO.save(workAux);
		
	}
}
