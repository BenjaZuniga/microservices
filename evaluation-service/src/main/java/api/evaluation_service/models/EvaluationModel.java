package api.evaluation_service.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationModel {

    private Long requestId;
    private int clientAge;
    private int clientIncome;
    private boolean rule2;
    private boolean rule3;
    private boolean rule4;

    private boolean rule71;
    private boolean rule72;
    private boolean rule73;
    private boolean rule74;
    private boolean rule75;


}
