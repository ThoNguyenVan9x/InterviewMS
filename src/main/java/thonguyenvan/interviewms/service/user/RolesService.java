package thonguyenvan.interviewms.service.user;


import thonguyenvan.interviewms.entity.user.Roles;

import java.util.List;

public interface RolesService {

    Roles findByRoleName (String roleName);

    Roles findByRoleId (Integer id);
    List<Roles> findAllRoles();
}
