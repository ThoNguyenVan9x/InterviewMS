package thonguyenvan.interviewms.config.security;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import thonguyenvan.interviewms.entity.user.User;
import thonguyenvan.interviewms.enums.user.UserStatus;
import thonguyenvan.interviewms.repository.user.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class SpringUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (userRepository.findByUsernameIgnoreCaseAndStatus(username, UserStatus.INACTIVE).isPresent()) {
            throw new UsernameNotFoundException("Account is inactive");
        }

        Optional<User> userOpt = userRepository.findByUsernameIgnoreCaseAndStatus(username, UserStatus.ACTIVE);

        if(userOpt.isEmpty()) {
            throw new UsernameNotFoundException("Account is Invalid");
        }

        User user = userOpt.get();

        List<GrantedAuthority> authorityList = user.getRoles()
                .stream().map(authority -> "ROLE_" + authority.getRoleName())
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList());

        return new Users(user.getUsername(), user.getPassword(), user.getDepartment().getDepartmentName(), authorityList);

    }
}
