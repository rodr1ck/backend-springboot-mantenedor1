package com.mantenedor1.mantenedor1.service;

import com.mantenedor1.mantenedor1.model.Tarea;

import java.util.List;

public interface TareaService {

    List<Tarea> findAll();

    Tarea findById(Integer id);

    Tarea save(Tarea tarea);

}
