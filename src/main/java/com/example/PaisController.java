package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/paises")
public class PaisController {

	private static final List<Pais> paises = new ArrayList<>();
	private final AtomicLong contador = new AtomicLong();
	
	public PaisController() {
		initData();
	}
	
	//Repositorio de datos de paises
	public void initData() {
		Pais peru = new Pais(contador.incrementAndGet(), "Perú", 33035304);
		paises.add(peru);
		Pais ecuador = new Pais(contador.incrementAndGet(), "Ecuador", 17268000);
		paises.add(ecuador);
		Pais venezuela = new Pais(contador.incrementAndGet(), "Venezuela", 28515829);
		paises.add(venezuela);
	}
	
	//Metodos
	@GetMapping()
	public ResponseEntity<List<Pais>> listar(){
		return new ResponseEntity<>(paises, HttpStatus.OK);
	}
	
	@GetMapping({"/{id}"})
	public ResponseEntity<Pais> unpais(@PathVariable long id){
		Pais p = paises.stream().filter(x -> id == x.getId()).findAny().orElse(null);
		if(p != null) {
			return new ResponseEntity<Pais>(p, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Pais>(p, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping()
	public ResponseEntity<Pais> insertar(@RequestBody Pais p){
		Pais pais = new Pais(contador.incrementAndGet(), p.getNombre(), p.getPoblacion());
		paises.add(pais);
		
		HttpHeaders httpheaders = new HttpHeaders();
		httpheaders.add("paises", "api/paises" + pais.getId());
		
		return new ResponseEntity<>(pais, httpheaders, HttpStatus.CREATED);
	}
	
	@PutMapping({"/{id}"})
	public ResponseEntity<Pais> actualizar(@PathVariable long id, @RequestBody Pais p){
		Pais temp = null;
		for(Pais ps : paises) {
			if(ps.getId() == id) {
				ps.setNombre(p.getNombre());
				ps.setPoblacion(p.getPoblacion());
				temp = ps;
				break;
			}
		}
		return new ResponseEntity<>(temp, HttpStatus.OK);
	}
	
	@DeleteMapping({"/{id}"})
	public ResponseEntity<Pais> eliminar(@PathVariable long id){
		Pais p = paises.stream().filter(x -> id == x.getId()).findAny().orElse(null);
		if(p != null) {
			paises.remove(p);
		}
		return new ResponseEntity<Pais>(HttpStatus.NO_CONTENT);
	}
}




