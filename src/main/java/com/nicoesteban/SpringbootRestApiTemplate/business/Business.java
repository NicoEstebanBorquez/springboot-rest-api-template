package com.nicoesteban.SpringbootRestApiTemplate.business;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "businesses")
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Schema( type = "string", example = "Business type")
    private String type;

    @Schema( type = "string", example = "Business name")
    private String name;

    @Schema( type = "string", example = "Business address")
    private String address;

}



