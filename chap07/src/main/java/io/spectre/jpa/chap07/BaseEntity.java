package io.spectre.jpa.chap07;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

    @Id @GeneratedValue
    private Long id;

    private String name;
}
