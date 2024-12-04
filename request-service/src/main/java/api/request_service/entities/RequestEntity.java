package api.request_service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private Long ownerId;
    private String type;
    private String state;
    private String reasonForRejection;
    private Long amount;
    private float interestRate;
    private Long months;
    private Long propertyValue;
    private Double monthlyFee;
}
