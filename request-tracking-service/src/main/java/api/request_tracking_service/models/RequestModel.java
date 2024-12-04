package api.request_tracking_service.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestModel {

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
