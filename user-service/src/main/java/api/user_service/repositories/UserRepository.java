package api.user_service.repositories;

import api.user_service.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    public boolean existsByMail(String mail);
    public UserEntity findByMail(String mail);


}
