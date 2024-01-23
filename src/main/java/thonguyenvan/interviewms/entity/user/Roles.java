package thonguyenvan.interviewms.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import thonguyenvan.interviewms.entity.BaseEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Roles extends BaseEntity<Integer> {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role_name", nullable = false)
    private String roleName;

}
