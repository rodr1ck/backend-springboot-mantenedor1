package com.mantenedor1.mantenedor1.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.Size;

@ApiModel(description = "Información o propiedes de la Tarea")
@Entity
@Table(name = "Tarea")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ApiModelProperty(notes = "La descripcion no puede tener mas de 150 caracteres")
    @Column(name = "descripcion", length = 150)
    @Size(min = 3, max = 150, message = "La descripcion tiene un minimo de 3 y un maximo de 150 caracteres")
    private String descripcion;

    @ApiModelProperty(notes = "Fecha de creación de la tarea")
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @ApiModelProperty(notes = "Vigente es un valor booleano verdadero o falso")
    @Column(name = "vigente")
    private Boolean vigente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    @PrePersist
    public void setFechaCreacion() {
        this.fechaCreacion = LocalDateTime.now();
    }

   /* public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    } */

    public Boolean getVigente() {
        return vigente;
    }

    public void setVigente(Boolean vigente) {
        this.vigente = vigente;
    }

}
