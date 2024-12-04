package api.user_service.services;

import api.user_service.entities.UserEntity;
import api.user_service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ArrayList<UserEntity> getUsers() { return (ArrayList<UserEntity>) userRepository.findAll();}

    public UserEntity getUserById(Long id) { return userRepository.findById(id).get();}

    public UserEntity getUserByMail(String mail) { return userRepository.findByMail(mail);}

    public boolean existsByMail(String mail) { return userRepository.existsByMail(mail);}

    public UserEntity saveUser(UserEntity user) {return userRepository.save(user);}

    public UserEntity updateUser(UserEntity user) {return userRepository.save(user);}

    public boolean deleteUser(Long id) throws Exception{
        try{
            userRepository.deleteById(id);
            return true;

        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
