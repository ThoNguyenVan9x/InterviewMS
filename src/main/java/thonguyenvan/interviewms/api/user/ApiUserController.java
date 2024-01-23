package thonguyenvan.interviewms.api.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import thonguyenvan.interviewms.service.user.UserService;
import thonguyenvan.interviewms.util.dto.user.RoleListDTO;
import thonguyenvan.interviewms.util.dto.user.UserListDTO;
import thonguyenvan.interviewms.util.page.Page;
import thonguyenvan.interviewms.util.page.PageRoles;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class ApiUserController {

    private final UserService userService;

    @GetMapping
    public Page<UserListDTO> getUsers(
            @RequestParam(defaultValue = "1", required = false, value = "pageIndex") Integer pageIndex,
            @RequestParam(defaultValue = "7", required = false, value = "pageSize") Integer pageSize,
            @RequestParam(required = false, value = "search") String search,
            @RequestParam(required = false, value = "role") String role
    ) {
        return userService.getPageUser(pageIndex, pageSize, search, role);
    }

    @GetMapping("/roles/{id}")
    public PageRoles<RoleListDTO> getRole(@PathVariable Integer id){
        return userService.getPageRole(id);
    }
}
