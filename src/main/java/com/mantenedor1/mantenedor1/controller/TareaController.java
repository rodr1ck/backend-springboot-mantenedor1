package com.mantenedor1.mantenedor1.controller;

import java.util.List;

import com.mantenedor1.mantenedor1.model.Tarea;
import com.mantenedor1.mantenedor1.service.TareaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/tarea")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @ApiOperation(value = "Obtener todos las tareas",
            notes = "No necesita parametros de entrada",
            response = List.class,
            responseContainer = "Tareas")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, tarea no encontrada"),
            @ApiResponse(code = 405, message = "No se encontraron tareas en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @GetMapping
    @CrossOrigin
    public List<Tarea> findAll(){
        return tareaService.findAll();
    }

    @ApiOperation(value = "Obtener una tarea",
            notes = "Necesita el id de entrada",
            response = List.class,
            responseContainer = "Tarea")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, tarea no encontrada"),
            @ApiResponse(code = 405, message = "No se encontraron tareas en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @GetMapping("/{id}")
    @CrossOrigin
    public Tarea findById(@PathVariable("id") Integer id){
        return tareaService.findById(id);
    }

    @ApiOperation(value = "Guarda una tarea",
            notes = "Necesita ingresar los datos de la tarea",
            response = List.class,
            responseContainer = "Tareas")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrada"),
            @ApiResponse(code = 405, message = "No se encontraron tareas en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @PostMapping
    @CrossOrigin
    public @ResponseBody Tarea save(@RequestBody Tarea tarea){
        return tareaService.save(tarea);
    }

    @ApiOperation(value = "Acualizar un tarea",
            notes = "Necesita ingresar la tarea a actualizar",
            response = List.class,
            responseContainer = "Tarea")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, tarea no encontrada"),
            @ApiResponse(code = 405, message = "No se encuentra la tarea en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @PutMapping
    public ResponseEntity<Tarea> modificar(@Valid @RequestBody Tarea tarea) {
        Tarea obj = tareaService.update(tarea);
        return new ResponseEntity<Tarea>(obj, HttpStatus.OK);
    }

    @ApiOperation(value = "Borra una tarea",
            notes = "Necesita ingresar el id de la tarea a eliminar",
            response = List.class,
            responseContainer = "Tarea")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, tarea no encontrada"),
            @ApiResponse(code = 405, message = "No se encuentra la tarea en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) throws Exception {
        tareaService.delete(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}
