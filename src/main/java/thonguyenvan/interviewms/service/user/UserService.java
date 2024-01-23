package thonguyenvan.interviewms.service.user;


import thonguyenvan.interviewms.entity.user.User;
import thonguyenvan.interviewms.util.dto.user.RoleListDTO;
import thonguyenvan.interviewms.util.dto.user.UserListDTO;
import thonguyenvan.interviewms.util.page.Page;
import thonguyenvan.interviewms.util.page.PageRoles;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Page<UserListDTO> getPageUser(Integer pageIndex, Integer pageSize, String search, String field);

    Optional<User> findByUserId(Integer id);

    void updateResetPasswordToken(String token, String email);

    User getByResetPasswordToken(String token);

    void updatePassword(User user, String newPassword);

    void save(User user);

    User saveUser(User user);

    void deleteUser(Integer id);

    boolean existByUserName(String username);

    boolean existByPhoneNumber(String phoneNumber);

    boolean existByEmail(String email);

    boolean existById(Integer id);

    String findFullNameByUserName(String userName);

    User findByUserName(String userName);

    List<User> getUsersIsManager();

    boolean existByIdAndEmail(Integer id, String email);

    boolean existByIdAndPhoneNumber(Integer id, String phoneNumber);

    List<User>findAll();

    void saveAllUser(List<User>list);

    PageRoles<RoleListDTO> getPageRole(Integer id);

}
