package api.request_service.services;

import api.request_service.entities.RequestEntity;
import api.request_service.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class RequestService {

    @Autowired
    RequestRepository requestRepository;

    public ArrayList<RequestEntity> getAllRequests() {return (ArrayList<RequestEntity>) requestRepository.findAll();}

    public ArrayList<RequestEntity> getRequestByOwnerId(Long id) {return (ArrayList<RequestEntity>) requestRepository.findByOwnerId(id);}

    public RequestEntity getRequestById(Long id) {return requestRepository.findById(id).get();}

    public RequestEntity saveRequest(RequestEntity request) {
        Double monthlyFee = calculateMonthlyFee(request.getAmount(), request.getInterestRate(), request.getMonths());
        request.setMonthlyFee(monthlyFee);
        return requestRepository.save(request);}

    public RequestEntity updateRequest(RequestEntity request) {return requestRepository.save(request);}

    public boolean deleteRequest(Long id) throws Exception{
        try{
            requestRepository.deleteById(id);
            return true;

        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public Double calculateMonthlyFee(Long p, float r, Long n) {
        r = r / 12 / 100;
        Double m = (p * r * Math.pow((1 + r), n)) / (Math.pow((1 + r), n) - 1);
        return m; };

}
