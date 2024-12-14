package api.evaluation_service.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

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
