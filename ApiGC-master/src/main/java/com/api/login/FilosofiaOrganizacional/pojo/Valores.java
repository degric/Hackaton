package com.api.login.FilosofiaOrganizacional.pojo;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Valores")
public class Valores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idValores;

    @Column(length = 5000)
    private String contenido;

    private LocalDate fecha;
}

