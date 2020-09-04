package test.sondeos.main.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import test.sondeos.main.entitites.Tarea;
import test.sondeos.main.services.ITareaService;

@RestController
@RequestMapping(path = "testSondeos")
public class TareasController {

	@Autowired
	private ITareaService tareaService;

	@GetMapping
	public ResponseEntity<Object> getAll() {

		try {
			return ResponseEntity.ok().body(this.tareaService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	@PostMapping
	public ResponseEntity<Object> saveTarea(@RequestBody String tareaParam)
			throws JsonMappingException, JsonProcessingException {

		ObjectMapper objectMapper = new ObjectMapper();

		Tarea tarea = objectMapper.readValue(tareaParam, Tarea.class);

		try {
			return ResponseEntity.status(HttpStatus.OK).body(this.tareaService.saveTarea(tarea));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> removeTarea(@PathVariable(value = "id") int id) {

		Optional<Tarea> tarea = this.tareaService.findById(id);

		try {
			this.tareaService.deleteTarea(tarea.get());
			return ResponseEntity.status(HttpStatus.OK).body(tarea);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

}
