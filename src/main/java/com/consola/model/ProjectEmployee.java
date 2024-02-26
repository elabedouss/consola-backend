package com.consola.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Project_Employee", catalog = "consola")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProjectEmployee implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private ProjectEmployeeId projectEmployeeId;

}