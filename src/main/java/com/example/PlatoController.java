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
@RequestMapping("api/platos")
public class PlatoController {

	private static final List<PlatilloComida> comidas = new ArrayList<>();
	private final AtomicLong contador = new AtomicLong();
	
	public PlatoController() {
		initData();
	}
	
	//Repositorio de datos de paises
	public void initData() {
		PlatilloComida arroz = new PlatilloComida(contador.incrementAndGet(), "arroz", 20,"arrocez",true);
		comidas.add(arroz);
		PlatilloComida fideo = new PlatilloComida(contador.incrementAndGet(), "fideo", 30,"fideoss",true);
		comidas.add(fideo);
		PlatilloComida marisco = new PlatilloComida(contador.incrementAndGet(), "marisco", 40,"peces",false);
		comidas.add(marisco);
		PlatilloComida sopa = new PlatilloComida(contador.incrementAndGet(), "sopa", 50,"calientes",true);
		comidas.add(sopa);
	}
	
	//Metodos
	@GetMapping()
	public ResponseEntity<List<PlatilloComida>> listar(){
		return new ResponseEntity<>(comidas, HttpStatus.OK);
	}
	
	@GetMapping({"/{id}"})
	public ResponseEntity<PlatilloComida> unpais(@PathVariable long id){
		PlatilloComida p = comidas.stream().filter(x -> id == x.getCodigoPlatillo()).findAny().orElse(null);
		if(p != null) {
			return new ResponseEntity<PlatilloComida>(p, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<PlatilloComida>(p, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping()
	public ResponseEntity<PlatilloComida> insertar(@RequestBody PlatilloComida p){
		PlatilloComida pais = new PlatilloComida(contador.incrementAndGet(), p.getNombrePlatillo(), p.getCostoPlatillo(), p.getCategoria(),p.isEstadoPlatillo());
		comidas.add(pais);
		
		HttpHeaders httpheaders = new HttpHeaders();
		httpheaders.add("paises", "api/paises" + pais.isEstadoPlatillo());
		
		return new ResponseEntity<>(pais, httpheaders, HttpStatus.CREATED);
	}
	
	@PutMapping({"/{id}"})
	public ResponseEntity<PlatilloComida> actualizar(@PathVariable long id, @RequestBody PlatilloComida p){
		PlatilloComida temp = null;
		for(PlatilloComida ps : comidas) {
			if(ps.getCodigoPlatillo() == id) {
				ps.setNombrePlatillo(p.getNombrePlatillo());
				ps.setCostoPlatillo(p.getCostoPlatillo());
				ps.setCategoria(p.getCategoria());
				ps.setEstadoPlatillo(p.isEstadoPlatillo());
				temp = ps;
				break;
			}
		}
		return new ResponseEntity<>(temp, HttpStatus.OK);
	}
	
	@DeleteMapping({"/{id}"})
	public ResponseEntity<PlatilloComida> eliminar(@PathVariable long id){
		PlatilloComida p = comidas.stream().filter(x -> id == x.getCodigoPlatillo()).findAny().orElse(null);
		if(p != null) {
			comidas.remove(p);
		}
		return new ResponseEntity<PlatilloComida>(HttpStatus.NO_CONTENT);
	}
}




