package test.sondeos.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import test.sondeos.main.entitites.Tarea;

@Service
public interface ITareaService {

	public Optional<List<Tarea>> findAll();
	
	public Optional<Tarea> findById(int id);
	
	public Tarea saveTarea(Tarea tarea);
	
	public void deleteTarea(Tarea tarea);
}
