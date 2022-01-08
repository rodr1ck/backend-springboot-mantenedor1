package com.mantenedor1.mantenedor1.repository;

import java.util.List;

import com.mantenedor1.mantenedor1.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TareaRepository extends JpaRepository<Tarea, Integer> {

}
