package cl.wom.integracion.poc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cl.wom.integracion.poc.repository.dto.PocMetadataDTO;

public interface PocMetadataRepository extends MongoRepository<PocMetadataDTO, String> {

}
