package thonguyenvan.interviewms.entity.jobs;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import thonguyenvan.interviewms.entity.BaseEntity;
import thonguyenvan.interviewms.entity.offer.Offer;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Levels extends BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="level_name")
    private String levelName;


    @ManyToMany(mappedBy = "levelsSet")
    private Set<Jobs> jobsSet=new HashSet<>();

    @OneToMany(mappedBy = "level")
    private Set<Offer> offersSet =new HashSet<>();
}
