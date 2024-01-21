package com.apjl.rest;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.apjl.dao.CustomersDAO;
import com.apjl.model.Customers;
import com.apjl.payload.FileResponse;
import com.apjl.services.FileService;

import jakarta.annotation.PostConstruct;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/file")
public class FileRest {

	@Autowired
	private FileService fileService;
	
	@Autowired
	private CustomersDAO customerDAO;
	
	@Value("C://ApjlProject//apjlApp//src//assets//images")	
	private String path;
	
	@Value("Imagen subida correctamente")	
	private String successMessage;
	
	@Value("La imagen no se pudo subir")	
	private String failMessage;
	
	@PostMapping("/upload")
	public ResponseEntity<FileResponse> fileUpload(@RequestParam("image") MultipartFile image){
		String fileName = null;
		try {
			fileName = this.fileService.uploadImage(path, image);
		} catch (IOException e) {
			
			return new ResponseEntity<>(new FileResponse(fileName, failMessage),HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		return new ResponseEntity<>(new FileResponse(fileName, successMessage),HttpStatus.OK);
		
	}
	@GetMapping("/prueba")
	public List<Customers> listCustomers(){
		return customerDAO.findAll();
	}
	
}
