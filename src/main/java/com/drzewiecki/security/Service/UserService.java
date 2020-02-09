package com.drzewiecki.security.Service;

import com.drzewiecki.security.entity.Employee;
import com.drzewiecki.security.entity.Role;
import com.drzewiecki.security.entity.User;
import com.drzewiecki.security.repository.RoleRepository;
import com.drzewiecki.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ApplicationContext applicationContext;
    private final RoleRepository roleRepository;

    public Optional<User> findByUserNameAndPlainTextPassword(String userName, String plainTextPassword) {
        final PasswordEncoder passwordEncoder = applicationContext.getBean(PasswordEncoder.class);

        return userRepository.findByUser(userName)
                .filter(user -> passwordEncoder.matches(plainTextPassword, user.getPassword()));
    }

    public User findByUserName(String userName) {
        return userRepository.findByUser(userName).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public String createUser(Employee employee, String plainTextPassword) {
        final PasswordEncoder passwordEncoder = applicationContext.getBean(PasswordEncoder.class);

        final String encryptedPassword = passwordEncoder.encode(plainTextPassword);
        final Role employeeRole = roleRepository.findByRoleName("employee").orElseThrow(EntityNotFoundException::new);

        userRepository.save(createNewUser(employee, encryptedPassword, employeeRole));
        return plainTextPassword;
    }

    private User createNewUser(Employee employee, String encryptedPassword, Role partnerRole) {
        return User.builder()
                .userName(employee.getName())
                .password(encryptedPassword)
                .employeeUid(employee.getEmployeeUid())
                .roles(Set.of(partnerRole))
                .build();
    }
}
