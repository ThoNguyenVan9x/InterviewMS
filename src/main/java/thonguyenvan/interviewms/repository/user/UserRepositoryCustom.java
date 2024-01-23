package thonguyenvan.interviewms.repository.user;


import thonguyenvan.interviewms.entity.user.User;
import thonguyenvan.interviewms.util.dto.user.RoleListDTO;
import thonguyenvan.interviewms.util.dto.user.UserListDTO;

import java.util.List;

public interface UserRepositoryCustom {

    List<UserListDTO> getAllUser(String search, String field);

    List<UserListDTO> getUserPaging(Integer pageIndex, Integer pageSize, String search, String role);

    List<User> getUsersIsManager();
    List<RoleListDTO> getRolesById(Integer id);
}
