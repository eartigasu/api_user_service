package com.example.userservice.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.example.userservice.dto.PhoneDTO;
import com.example.userservice.dto.UserRequestDTO;
import com.example.userservice.dto.UserResponseDTO;
import com.example.userservice.exception.InvalidInputException;
import com.example.userservice.exception.UserAlreadyExistsException;
import com.example.userservice.model.Phone;
import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.security.JwtTokenUtil;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Value("${validation.password.regex}")
  private String passwordRegex;

  public UserResponseDTO createUser(UserRequestDTO userRequest) {

    validatePassword(userRequest.getPassword());

    checkIfEmailExists(userRequest.getEmail());

    User newUser = buildUserFromRequest(userRequest);
    User savedUser = userRepository.save(newUser);

    return mapToUserResponseDto(savedUser);
  }

  private void validatePassword(String password) {
    if (!Pattern.matches(passwordRegex, password)) {
      throw new InvalidInputException("La contraseña no cumple con los requisitos.");
    }
  }

  private void checkIfEmailExists(String email) {
    userRepository.findByEmail(email).ifPresent(user -> {
      throw new UserAlreadyExistsException("Usuario con el correo ya existe");
    });
  }

  private User buildUserFromRequest(UserRequestDTO userRequest) {
    return User.builder().id(UUID.randomUUID()).name(userRequest.getName()).email(userRequest.getEmail()).password(userRequest.getPassword())
        .created(LocalDateTime.now()).modified(LocalDateTime.now()).lastLogin(LocalDateTime.now())
        .token(jwtTokenUtil.generateToken(userRequest.getEmail(), jwtTokenUtil.generateKey())).isActive(true)
        .phones(mapToPhones(userRequest.getPhones())).build();
  }

  private List<Phone> mapToPhones(List<PhoneDTO> phoneDTOs) {
    return phoneDTOs.stream().map(phoneDto -> new Phone(null, phoneDto.getNumber(), phoneDto.getCitycode(), phoneDto.getContrycode())).toList();
  }

  private UserResponseDTO mapToUserResponseDto(User user) {
    return UserResponseDTO.builder().id(user.getId()).name(user.getName()).email(user.getEmail()).created(user.getCreated())
        .modified(user.getModified()).lastLogin(user.getLastLogin()).token(user.getToken()).isActive(user.isActive())
        .phones(user.getPhones().stream().map(phone -> new PhoneDTO(phone.getNumber(), phone.getCitycode(), phone.getContrycode())).toList()).build();
  }
}
