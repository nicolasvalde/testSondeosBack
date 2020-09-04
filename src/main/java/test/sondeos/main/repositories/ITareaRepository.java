package test.sondeos.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.sondeos.main.entitites.Tarea;

@Repository
public interface ITareaRepository extends JpaRepository<Tarea, Integer> {
	
}
