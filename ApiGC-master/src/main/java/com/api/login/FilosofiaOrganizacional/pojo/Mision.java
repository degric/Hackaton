package com.api.login.FilosofiaOrganizacional.pojo;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.Length;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Mision")
public class Mision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMision;

    @Column(length = 5000)
    private String contenido;

    private LocalDate fecha;
}
