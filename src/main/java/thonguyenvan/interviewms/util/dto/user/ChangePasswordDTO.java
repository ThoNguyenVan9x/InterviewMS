package thonguyenvan.interviewms.util.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import thonguyenvan.interviewms.util.validation.checkRepasswordUser.FieldMatchChangePassword;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@FieldMatchChangePassword({"newPassword", "confirmPassword"})
public class ChangePasswordDTO {

    @NotBlank(message = "Old Password can not be blank")
    private String oldPassword;

    @NotBlank(message = "New Password can not be blank")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", message = "{ME007}")
    private String newPassword;

    @NotBlank(message = "Re-Password can not be blank")
    private String confirmPassword;

}
