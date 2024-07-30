package com.example.userservice.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.example.userservice.dto.PhoneDTO;
import com.example.userservice.dto.UserRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  private UserRequestDTO validUserRequest;

  @BeforeEach
  void setUp() {
    validUserRequest = new UserRequestDTO();
    validUserRequest.setName("John Doe");
    validUserRequest.setEmail("john.doe@example.com");
    validUserRequest.setPassword("Passw0rd");
    validUserRequest.setPhones(List.of(new PhoneDTO("123456789", "1", "1")));
  }

  @Test
  @Order(0)
  void createUser_ShouldReturnCreated() throws Exception {
    mockMvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(validUserRequest)))
        .andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON));
  }

  @Test
  @Order(1)
  void createUser_ShouldReturnConflict_WhenEmailExists() throws Exception {
    validUserRequest.setEmail("other_mail@example.com");
    mockMvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(validUserRequest)))
        .andExpect(status().isCreated());

    mockMvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(validUserRequest)))
        .andExpect(status().isConflict());
  }

  @Test
  @Order(2)
  void createUser_ShouldReturnBadRequest_WhenPasswordInvalid() throws Exception {
    validUserRequest.setEmail("and_other_mail@example.com");
    validUserRequest.setPassword("123"); // Invalid password
    mockMvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(validUserRequest)))
        .andExpect(status().isBadRequest());
  }

  @Test
  @Order(3)
  void createUser_ShouldReturnBadRequest_WhenEmailInvalid() throws Exception {
    validUserRequest.setEmail("invalid-email"); // Invalid email
    mockMvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(validUserRequest)))
        .andExpect(status().isBadRequest());
  }

  @Test
  @Order(4)
  void createUser_ShouldReturnCreated_WhenNoPhones() throws Exception {
    validUserRequest.setEmail("mail@example.com");
    validUserRequest.setPhones(List.of()); // No phones
    mockMvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(validUserRequest)))
        .andExpect(status().isCreated()).andExpect(content().contentType(MediaType.APPLICATION_JSON));
  }

  @Test
  @Order(5)
  void createUser_ShouldReturnBadRequest_WhenNoName() throws Exception {
    validUserRequest.setName(""); // No name
    validUserRequest.setEmail("mail_other@example.com");
    mockMvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(validUserRequest)))
        .andExpect(status().isBadRequest());
  }
}
