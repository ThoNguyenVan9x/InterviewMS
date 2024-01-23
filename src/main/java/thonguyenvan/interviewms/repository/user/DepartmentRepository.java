package thonguyenvan.interviewms.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import thonguyenvan.interviewms.entity.user.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Department findByDepartmentName(String departmentName);
}
