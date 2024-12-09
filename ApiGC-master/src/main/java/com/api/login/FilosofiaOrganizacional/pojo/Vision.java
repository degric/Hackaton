package com.api.login.FilosofiaOrganizacional.pojo;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Vision")
public class Vision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVision;

    @Column(length = 5000)
    private String contenido;

    private LocalDate fecha;
}

