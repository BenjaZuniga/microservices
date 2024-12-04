package api.request_tracking_service.controllers;

import api.request_tracking_service.models.CostsModel;
import api.request_tracking_service.models.RequestModel;
import api.request_tracking_service.services.RequestTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requestTracking")
public class RequestTrackingController {

    @Autowired
    private RequestTrackingService requestTrackingService;

    @GetMapping("/{id}")
    public ResponseEntity<List<RequestModel>> getAllRequests(@PathVariable Long id) {
        return ResponseEntity.ok(requestTrackingService.getRequests(id));
    }

    @PostMapping("/costs")
    public ResponseEntity<CostsModel> getCosts(@RequestBody RequestModel request) {
        return ResponseEntity.ok(requestTrackingService.getCosts(request));
    }

    @GetMapping("/prueba")
    public ResponseEntity<String> getPrueba() {
        return ResponseEntity.ok("Request-tracking-Service funcionando");
    }
}
