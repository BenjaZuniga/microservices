package api.simulate_service.controllers;

import api.simulate_service.services.SimulateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/simulate")
public class SimulateController {

    @Autowired
    private SimulateService simulateService;

    @GetMapping("/")
    public ResponseEntity<Double> getRequestByCredit(
            @RequestParam("amount") Long p,
            @RequestParam("interestRate") float r,
            @RequestParam("months") Long n) {
        Double m = simulateService.simulateCredit(p, r, n);
        return ResponseEntity.ok(m);
    }

    @GetMapping("/prueba")
    public ResponseEntity<String> getPrueba() {
        System.out.println("hola");
        return ResponseEntity.ok("funciona");
    }
}
