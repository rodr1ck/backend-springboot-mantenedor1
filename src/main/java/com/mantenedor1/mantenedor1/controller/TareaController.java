package com.mantenedor1.mantenedor1.controller;

import java.util.List;

import com.mantenedor1.mantenedor1.model.Tarea;
import com.mantenedor1.mantenedor1.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarea")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping
    @CrossOrigin
    public List<Tarea> findAll(){
        return tareaService.findAll();
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public Tarea findById(@PathVariable("id") Integer id){
        return tareaService.findById(id);
    }

    @PostMapping
    @CrossOrigin
    public @ResponseBody Tarea save(@RequestBody Tarea tarea){
        return tareaService.save(tarea);
    }

}
