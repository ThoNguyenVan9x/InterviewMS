package thonguyenvan.interviewms.service.user.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thonguyenvan.interviewms.entity.user.Department;
import thonguyenvan.interviewms.repository.user.DepartmentRepository;
import thonguyenvan.interviewms.service.user.DepartmentService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Department findByDepartmentName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

    @Override
    public List<Department> findAllDepartment() {
        return departmentRepository.findAll();
    }
}
