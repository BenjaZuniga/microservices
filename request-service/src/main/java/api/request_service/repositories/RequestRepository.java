package api.request_service.repositories;

import api.request_service.entities.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<RequestEntity, Long> {

    public List<RequestEntity> findByOwnerId(Long id);

}
