package api.request_tracking_service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CostsModel {

    private int insurance1;
    private int insurance2;
    private int administration;
    private int monthlyCost;
    private int totalCost;
}
