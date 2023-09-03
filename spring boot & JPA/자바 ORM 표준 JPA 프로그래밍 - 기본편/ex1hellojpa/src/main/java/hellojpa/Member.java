package hellojpa;

import javax.persistence.*;

@Entity
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String name;
    private int age;
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;
}