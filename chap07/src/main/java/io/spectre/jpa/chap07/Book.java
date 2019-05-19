package io.spectre.jpa.chap07;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("B")
@PrimaryKeyJoinColumn(name = "BOOK_ID")
@Getter
@Setter
@ToString(callSuper = true)
public class Book extends Item{

    private String author;

    private String isbn;
}
