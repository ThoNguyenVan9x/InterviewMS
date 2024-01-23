package thonguyenvan.interviewms.service.user;


import thonguyenvan.interviewms.entity.user.Department;

import java.util.List;

public interface DepartmentService {

    Department findByDepartmentName (String departmentName);

    List<Department> findAllDepartment();
}
