package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Genre extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "genres")
    private List<Movie> movies;
}
