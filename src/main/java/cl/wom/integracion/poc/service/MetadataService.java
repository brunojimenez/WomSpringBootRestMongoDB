package cl.wom.integracion.poc.service;

import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import cl.wom.integracion.poc.repository.PocMetadataRepository;
import cl.wom.integracion.poc.repository.dto.PocMetadataDTO;
import cl.wom.integracion.poc.to.request.MetadataAlfaRequest;
import cl.wom.integracion.poc.to.request.MetadataBetaRequest;

@Service
public class MetadataService {

	@Autowired
	private PocMetadataRepository pocMetadataRepository;

	/**
	 * Log de la clase.
	 */
	private static final Logger logger = LogManager.getLogger(MetadataService.class);

	public PocMetadataDTO getMetadataWithCast(String id) {
		Optional<PocMetadataDTO> optPocMetadataDTO = pocMetadataRepository.findById(id);
		if (optPocMetadataDTO.isEmpty()) {
			return null;
		}

		PocMetadataDTO pocMetadataDTO = optPocMetadataDTO.get();
		Map<String, Object> map = pocMetadataDTO.getMap();

		ObjectMapper oMapper = new ObjectMapper();

		try {
			MetadataAlfaRequest metadataAlfaRequest = oMapper.convertValue(map, MetadataAlfaRequest.class);
			// Set a breakpoint here
			logger.info(metadataAlfaRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			MetadataBetaRequest metadataBetaRequest = oMapper.convertValue(map, MetadataBetaRequest.class);
			// Set a breakpoint here
			logger.info(metadataBetaRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pocMetadataDTO;
	}

	public PocMetadataDTO getMetadataSimple(String id) {
		Optional<PocMetadataDTO> optPocMetadataDTO = pocMetadataRepository.findById(id);
		if (optPocMetadataDTO.isEmpty()) {
			return null;
		}
		return optPocMetadataDTO.get();
	}

	public String saveMetadataAlfa(MetadataAlfaRequest metadataRequest) {

		ObjectMapper oMapper = new ObjectMapper();

		try {
			// object -> Map
			Map<String, Object> map = oMapper.convertValue(metadataRequest, Map.class);
			DBObject dbObject = new BasicDBObject(map);
			Document document = new Document(map); // Document.parse("{}");

			String id = metadataRequest.getId();

			PocMetadataDTO pocMetadataDTO = new PocMetadataDTO();
			pocMetadataDTO.setId(id);
			pocMetadataDTO.setMap(map);
			pocMetadataDTO.setDocument(document);
			pocMetadataRepository.save(pocMetadataDTO);

			return "OK";
		} catch (Exception e) {
			e.printStackTrace();
			return "NOK";
		}

	}

	public String saveMetadataBeta(MetadataBetaRequest metadataRequest) {

		ObjectMapper oMapper = new ObjectMapper();

		try {
			// object -> Map
			Map<String, Object> map = oMapper.convertValue(metadataRequest, Map.class);
			DBObject dbObject = new BasicDBObject(map);
			Document document = new Document(map); // Document.parse("{}");

			String id = metadataRequest.getId();

			PocMetadataDTO pocMetadataDTO = new PocMetadataDTO();
			pocMetadataDTO.setId(id);
			pocMetadataDTO.setMap(map);
			pocMetadataDTO.setDocument(document);
			pocMetadataRepository.save(pocMetadataDTO);

			return "OK";
		} catch (Exception e) {
			e.printStackTrace();
			return "NOK";
		}
	}

}
