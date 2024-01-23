package thonguyenvan.interviewms.util.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import thonguyenvan.interviewms.entity.candidates.Positions;
import thonguyenvan.interviewms.entity.user.Roles;
import thonguyenvan.interviewms.enums.user.UserStatus;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserListDTO {

    private Integer id;

    private String username;

    private String email;

    private String phoneNumber;

    private Positions position;

    private Roles role;

    private UserStatus status;
}
