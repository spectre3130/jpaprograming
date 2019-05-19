package io.spectre.jpa.helloshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {

    private Date createdDate;

    private Date lastModifiedDate;
}
