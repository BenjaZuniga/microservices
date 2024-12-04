package api.request_tracking_service.services;

import api.request_tracking_service.RequestTrackingServiceApplication;
import api.request_tracking_service.models.CostsModel;
import api.request_tracking_service.models.RequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class RequestTrackingService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RequestTrackingServiceApplication requestTrackingServiceApplication;

    public ArrayList<RequestModel> getRequests(Long ownerId){
        ArrayList<RequestModel> requests = restTemplate.getForObject("http://request-service/requests/findByOwnerId/" + ownerId, ArrayList.class);
        return requests;
    }

    public CostsModel getCosts(RequestModel request){
        CostsModel costs = new CostsModel();
        Long amount = request.getAmount();
        double monthlyFee = request.getMonthlyFee();

        int insurance1 = (int) (amount * 0.0003);
        int insurance2 = 20000;
        int monthly = (int)(monthlyFee + insurance1 + insurance2);
        int administration = (int)(amount * 0.01);
        int total = (int) (monthly * request.getMonths()) + administration;

        costs.setInsurance1(insurance1);
        costs.setInsurance2(insurance2);
        costs.setAdministration(administration);
        costs.setMonthlyCost(total);

        return costs;



    }

}
