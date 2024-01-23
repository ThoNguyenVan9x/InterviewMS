package thonguyenvan.interviewms.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import thonguyenvan.interviewms.entity.BaseEntity;
import thonguyenvan.interviewms.entity.offer.Offer;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Department extends BaseEntity<Integer> {

    @Id
    @Column(name = "department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "department_name", nullable = false)
    private String departmentName;

    @OneToMany (mappedBy = "department")
    private List<User> user;

    @OneToMany (mappedBy = "department")
    private Set<Offer> offer;


}
