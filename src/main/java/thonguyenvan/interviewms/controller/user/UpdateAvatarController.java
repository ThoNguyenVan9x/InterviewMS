package thonguyenvan.interviewms.controller.user;

import thonguyenvan.interviewms.config.security.SecurityUtils;
import thonguyenvan.interviewms.entity.user.Roles;
import thonguyenvan.interviewms.entity.user.User;
import thonguyenvan.interviewms.enums.user.UserStatus;
import thonguyenvan.interviewms.service.file.FileStorageService;
import thonguyenvan.interviewms.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Controller
@RequestMapping("/avatar")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN', 'RECRUITER', 'MANAGER', 'INTERVIEWER')")
public class UpdateAvatarController {

    private final UserService userService;
    private final FileStorageService fileStorageService;

    @GetMapping
    public String showForm(Model model) {
        String username = SecurityUtils.getCurrentUserLogin().orElse("null");
        User user = userService.findByUserName(username);

        if (Objects.isNull(user)) {
            return "error/404";
        }

        Set<String> roleSet = new HashSet<>();
        for (Roles r : user.getRoles()) {
            roleSet.add(r.getRoleName());
        }

        if (user.getStatus().equals(UserStatus.ACTIVE)) {
            model.addAttribute("active", "ACTIVE USER");
        }
        if (user.getStatus().equals(UserStatus.INACTIVE)) {
            model.addAttribute("inactive", "INACTIVE USER");
        }

        model.addAttribute("userDetail", user);
        model.addAttribute("userDetailsRole", roleSet);
        return "user/view-profile-user";
    }

    @PostMapping
    public String updateAvatar(@RequestParam("file") MultipartFile file) throws IOException {

        String username = SecurityUtils.getCurrentUserLogin().orElse("null");
        User user = userService.findByUserName(username);

        user.setAvatar(fileStorageService.saveFile(file, "avatar"));
        userService.save(user);
        return "redirect:/";
    }
}
