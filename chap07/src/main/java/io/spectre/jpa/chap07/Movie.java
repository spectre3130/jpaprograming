package io.spectre.jpa.chap07;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
@Getter
@Setter
@ToString(callSuper = true)
public class Movie extends Item{

    private String director;

    private String actor;
}
