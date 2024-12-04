package api.request_service.controllers;

import api.request_service.entities.RequestEntity;
import api.request_service.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
public class RequestController {
    @Autowired
    private RequestService requestService;

    @GetMapping("/")
    public ResponseEntity<List<RequestEntity>> getAllRequests() {
        System.out.println("hola");
        List<RequestEntity> requests = requestService.getAllRequests();
        return ResponseEntity.ok(requests);
    }

    @GetMapping("/findByOwnerId/{id}")
    public ResponseEntity<List<RequestEntity>> getRequestByOwnerId(@PathVariable Long id) {
        List<RequestEntity> requests = requestService.getRequestByOwnerId(id);
        return ResponseEntity.ok(requests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestEntity> getRequestById(@PathVariable Long id) {
        RequestEntity request = requestService.getRequestById(id);
        return ResponseEntity.ok(request);
    }

    @PostMapping("/")
    public ResponseEntity<RequestEntity> addRequest(@RequestBody RequestEntity request) {
        RequestEntity newRequest = requestService.saveRequest(request);
        return ResponseEntity.ok(newRequest);
    }

    @PutMapping("/")
    public ResponseEntity<RequestEntity> updateRequest(@RequestBody RequestEntity request) {
        RequestEntity updatedRequest = requestService.updateRequest(request);
        return ResponseEntity.ok(updatedRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) throws Exception {
        var isDeleted = requestService.deleteRequest(id);
        return ResponseEntity.noContent().build();
    }
}
