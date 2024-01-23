package thonguyenvan.interviewms.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import thonguyenvan.interviewms.entity.user.Roles;

public interface RolesRepository extends JpaRepository<Roles, Integer>, UserRepositoryCustom {

    Roles findByRoleName(String roleName);
}
