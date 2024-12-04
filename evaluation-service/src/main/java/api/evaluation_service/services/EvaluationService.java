package api.evaluation_service.services;

import api.evaluation_service.models.EvaluationModel;
import api.evaluation_service.models.RequestModel;
import api.evaluation_service.models.DocumentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;


@Service
public class EvaluationService {

    @Autowired
    RestTemplate restTemplate;

    public RequestModel evaluate(EvaluationModel evaluationModel) {

        RequestModel requestModel = getRequest(evaluationModel.getRequestId());

        Double monthlyFee = requestModel.getMonthlyFee();
        String requestType = requestModel.getType();
        Long amount = requestModel.getAmount();
        Long propertyValue = requestModel.getPropertyValue();
        Long months = requestModel.getMonths();
        int clientIncome = evaluationModel.getClientIncome();
        int clientAge = evaluationModel.getClientAge();
        String reason = "";
        String state = requestModel.getState();

        boolean rule1;
        boolean rule2 = evaluationModel.isRule2();
        boolean rule3 = evaluationModel.isRule3();
        boolean rule4 = evaluationModel.isRule4();
        boolean rule5;
        boolean rule6;
        boolean rule7;

        boolean rule71 = evaluationModel.isRule71();
        boolean rule72 = evaluationModel.isRule72();
        boolean rule73 = evaluationModel.isRule73();
        boolean rule74 = evaluationModel.isRule74();
        boolean rule75 = evaluationModel.isRule75();


        Double relationMF_CI = monthlyFee / clientIncome * 100;
        float relationAmount_PropertyValue = amount / propertyValue *100;
        float requestYears = months / 12;
        float maxClientAge = clientAge + requestYears;


        if( relationMF_CI > 35){
            rule1 = false;
            reason = "La relación cuota/ingreso supera el 35%\n";
        }else{
            rule1 = true;
        }

        if(!rule2){
            reason += "Historial crediticio no apropiado\n";
        }

        if(!rule3){
            reason += "Estabilidad laboral no apropiada\n";
        }

        if(!rule4){
            reason += "Relación deuda/ingreso supera el 50%\n";

        }

        rule5 = checkRule5(requestType, relationAmount_PropertyValue);

        if(!rule5){
            reason += "Monto máximo de finaciamiento excedido\n";
        }



        if(maxClientAge <= 75){
            rule6 = true;
        }else{
            rule6 = false;
            reason += "El cliente supera los 75 años al final del prestamo\n";
        }

        if(rule71 && rule72 && rule73 && rule74 && rule75){
            rule7 = true;
        }else{
            int cont = 0;
            if(rule71){
                cont++;
            }
            if(rule72){
                cont++;
            }
            if(rule73){
                cont++;
            }
            if(rule74){
                cont++;
            }
            if(rule75){
                cont++;
            }

            if(cont > 2){
                rule7 = true;
                state = "Revisión adicional";
            }else{
                rule7 = false;
                reason += "No cumple con la capacidad de ahorro requerida\n";
            }
        }

        if(rule1 && rule2 && rule3 && rule4 && rule5 && rule6 && rule7){
            if(state.equals("Revisión Adicional")){
                requestModel.setState(state);
                restTemplate.put("http://request-service/requests/",requestModel);
                return requestModel;
            }else{
                requestModel.setState("Pre-aprobado");
                restTemplate.put("http://request-service/requests/",requestModel);
                return requestModel;
            }

        }else{
            requestModel.setState("Rechazado");
            requestModel.setReasonForRejection(reason);
            restTemplate.put("http://request-service/requests/",requestModel);
            return requestModel;
        }

    }

    public boolean checkRule5(String type, float relation){
        switch (type) {
            case "Primera vivienda":
                if (relation <= 80) {
                    return true;
                } else {
                    return false;
                }

            case "Segunda vivienda":
                if (relation <= 70) {
                    return true;
                } else {
                    return false;
                }

            case "Propiedades comerciales":
                if (relation <= 60) {
                    return true;
                } else {
                    return false;
                }
            case "Remodelación":
                return relation <= 50;
        }
        return false;

    }

    public ArrayList<RequestModel> getRequests(){
        ArrayList<RequestModel> requests = restTemplate.getForObject("http://request-service/requests/", ArrayList.class);
        return requests;
    }

    public RequestModel getRequest(Long requestId){
        RequestModel request = restTemplate.getForObject("http://request-service/requests/"+requestId, RequestModel.class);
        return request;
    }

    public ArrayList<DocumentModel> getDocumentsByRequest(Long requestId){
        ArrayList<DocumentModel> documents = restTemplate.getForObject("http://request-service/requests/documents/findByRequestId/" + requestId, ArrayList.class);
        return documents;
    }
}
