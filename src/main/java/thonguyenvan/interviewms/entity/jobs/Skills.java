package thonguyenvan.interviewms.entity.jobs;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import thonguyenvan.interviewms.entity.BaseEntity;
import thonguyenvan.interviewms.entity.candidates.Candidates;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Skills extends BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "skill_name")
    private String skillName;

    @ManyToMany(mappedBy = "skillsSet")
    private Set<Jobs> jobsSet=new HashSet<>();

    @ManyToMany(mappedBy = "skillsSet")
    private Set<Candidates> candidatesSet = new HashSet<>();
}
