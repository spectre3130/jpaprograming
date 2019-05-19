package io.spectre.jpa.chap07;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Child {

    @Id
    private String id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "C_PARENT_ID1", referencedColumnName = "PARENT_ID1"),
            @JoinColumn(name = "C_PARENT_ID2", referencedColumnName = "PARENT_ID2")
    })
    private Parent parent;
}
