package test.sondeos.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.sondeos.main.entitites.Tarea;
import test.sondeos.main.repositories.ITareaRepository;

@Service
public class TareaServiceImpl implements ITareaService {

	@Autowired
	private ITareaRepository tareaRepository;

	@Override
	public Optional<List<Tarea>> findAll() {
		try {			
			return Optional.ofNullable(tareaRepository.findAll());
		} catch (Exception e) {
			return Optional.empty();
		}
	}

	@Override
	public Optional<Tarea> findById(int id) {
		return this.tareaRepository.findById(id);
	}

	@Override
	public Tarea saveTarea(Tarea tarea) {
		return tareaRepository.save(tarea);
	}

	@Override
	public void deleteTarea(Tarea tarea) {
		tareaRepository.delete(tarea);
	}

}
