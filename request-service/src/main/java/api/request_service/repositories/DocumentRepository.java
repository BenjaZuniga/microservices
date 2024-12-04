package api.request_service.repositories;

import api.request_service.entities.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<DocumentEntity, Long> {

    public List<DocumentEntity> findByRequestId(Long requestId);

}
