package com.mantenedor1.mantenedor1.service.impl;

import com.mantenedor1.mantenedor1.model.Tarea;
import com.mantenedor1.mantenedor1.repository.TareaRepository;
import com.mantenedor1.mantenedor1.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TareaServiceImpl implements TareaService {

    private final TareaRepository tareaRepository;

    @Autowired
    public TareaServiceImpl(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    @Override
    public List<Tarea> findAll() {
        return tareaRepository.findAll();
    }

    @Override
    public Tarea findById(Integer id) {
        Optional<Tarea> op = tareaRepository.findById(id);
        return op.isPresent() ? op.get() : new Tarea();
    }

    @Override
    public Tarea save(Tarea tarea) {
        return tareaRepository.save(tarea);
    }
}
