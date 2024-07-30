package com.example.userservice.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_example")
public class User {

  @Id
  @GeneratedValue
  private UUID id;
  private String name;
  private String email;
  private String password;
  private LocalDateTime created;
  private LocalDateTime modified;
  private LocalDateTime lastLogin;

  @Column(columnDefinition = "TEXT")
  private String token;
  private boolean isActive;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Phone> phones;
}
