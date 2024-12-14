package api.evaluation_service.controllers;

import api.evaluation_service.models.DocumentModel;
import api.evaluation_service.models.EvaluationModel;
import api.evaluation_service.models.RequestModel;
import api.evaluation_service.models.UserModel;
import api.evaluation_service.services.EvaluationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/evaluate")
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;

    @PostMapping("/")
    public ResponseEntity<RequestModel> evaluate(@RequestBody EvaluationModel evaluation) {
        return ResponseEntity.ok(evaluationService.evaluate(evaluation));
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserModel> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(evaluationService.getUser(id));
    }

    @GetMapping("/getRequests")
    public ResponseEntity<List<RequestModel>> getRequests() {
        return ResponseEntity.ok(evaluationService.getRequests());
    }

    @GetMapping("/getRequest/{id}")
    public ResponseEntity<RequestModel> getRequests(@PathVariable Long id) {
        return ResponseEntity.ok(evaluationService.getRequest(id));
    }

    @GetMapping("/getDocuments/{id}")
    public ResponseEntity<List<DocumentModel>> getDocuments(@PathVariable Long id) {
        return ResponseEntity.ok(evaluationService.getDocumentsByRequest(id));
    }

    @GetMapping("/prueba")
    public ResponseEntity<String> getPrueba() {
        return ResponseEntity.ok("Evaluation-Service funcionando");
    }
}
