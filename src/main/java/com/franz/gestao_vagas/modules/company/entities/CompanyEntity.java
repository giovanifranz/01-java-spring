package com.franz.gestao_vagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity(name = "company")
@Data
public class CompanyEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  public UUID id;
  public String name;

  @NotBlank(message = "o campo [username] não pode ser vazio")
  @Pattern(regexp = "^\\S+", message = "o campo [username] não pode ser vazio [espaços em branco]")
  private String username;

  @Email(message = "o campo [email] deve conter um e-mail válido")
  private String email;

  @Length(min = 10, max = 100, message = "o campo [password] deve conter entre 10 e 100 caracteres")
  private String password;
  public String website;
  public String description;

  @CreationTimestamp
  private LocalDateTime createdAt;

}
