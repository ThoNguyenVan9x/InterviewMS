package thonguyenvan.interviewms.service.user.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import thonguyenvan.interviewms.entity.user.Roles;
import thonguyenvan.interviewms.repository.user.RolesRepository;
import thonguyenvan.interviewms.service.user.RolesService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RolesServiceImpl implements RolesService {

    private final RolesRepository rolesRepository;

    @Override
    public Roles findByRoleName(String roleName) {
        return rolesRepository.findByRoleName(roleName);
    }

    @Override
    public Roles findByRoleId(Integer id) {
        return rolesRepository.findById(id).orElse(null);
    }

    @Override
    public List<Roles> findAllRoles() {
        return rolesRepository.findAll();
    }
}
