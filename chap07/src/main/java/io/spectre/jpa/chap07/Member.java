package io.spectre.jpa.chap07;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Member extends BaseEntity {

    private String email;

}
