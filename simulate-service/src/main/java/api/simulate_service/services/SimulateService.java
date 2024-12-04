package api.simulate_service.services;

import org.springframework.stereotype.Service;

@Service
public class SimulateService {

    public Double simulateCredit(Long p, float r, Long n) {
        r = r / 12 / 100;
        Double m = (p * r * Math.pow((1 + r), n)) / (Math.pow((1 + r), n) - 1);
        return m; };
}
