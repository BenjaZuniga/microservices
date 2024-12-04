package api.evaluation_service.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentModel {

    private Long id;

    private Long requestId;
    private String type;
    @Lob
    private byte[] data;
}
