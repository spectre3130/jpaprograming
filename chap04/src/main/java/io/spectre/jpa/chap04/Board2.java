package io.spectre.jpa.chap04;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "BOARD_SUB")
@TableGenerator(
        name = "BOARD2_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnName = "BOARD_SEQ", allocationSize = 1
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Board2 {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,
                    generator = "BOARD2_SEQ_GENERATOR")
    private Long id;

    private String title;


}
