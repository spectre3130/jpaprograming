package io.spectre.jpa.chap05;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Member() {
    }

    public Member(String username) {
        this.username = username;
    }

    public Member(String username, Team team) {
        this.username = username;
        this.team = team;
    }

    public void setTeam(Team team) {
//        if(this.team != null) {
//            this.team.getMembers().remove(this);
//        }
        this.team = team;
        this.team.getMembers().add(this);
    }

}
