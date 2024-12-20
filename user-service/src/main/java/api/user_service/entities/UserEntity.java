package api.user_service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private int role;
    private int age;
    private Long salary;
    private String rut;
    private String name;
    private String mail;
    private String password;
    private String number;
    private Long salaryDocumentId;
    private Long personalDocumentId;
}
