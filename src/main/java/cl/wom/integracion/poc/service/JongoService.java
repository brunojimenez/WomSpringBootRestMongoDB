package cl.wom.integracion.poc.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.wom.integracion.poc.repository.dto.JongoUsersDTO;
import cl.wom.integracion.poc.to.request.JongoRequest;

@Service
public class JongoService {

	@Autowired
	private Jongo jongo;

	/**
	 * Log de la clase.
	 */
	private static final Logger logger = LogManager.getLogger(JongoService.class);

	public MongoCursor<JongoUsersDTO> find(JongoRequest jongoRequest) {
		logger.info("[get]");
		MongoCollection collectionJongoUsersDTO = jongo.getCollection(jongoRequest.getCollection());
		return collectionJongoUsersDTO.find(jongoRequest.getQuery()).as(JongoUsersDTO.class);
	}

	public JongoUsersDTO findOne(JongoRequest jongoRequest) {
		logger.info("[get]");

		MongoCollection collectionJongoUsersDTO = jongo.getCollection(jongoRequest.getCollection());
		JongoUsersDTO one = collectionJongoUsersDTO.findOne(jongoRequest.getQuery()).as(JongoUsersDTO.class);
		return one;
	}

	public MongoCursor<JongoUsersDTO> findByDate(JongoRequest jongoRequest) throws ParseException {
		logger.info("[get]");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date fecha = sdf.parse(jongoRequest.getFecha());

		MongoCollection collectionJongoUsersDTO = jongo.getCollection(jongoRequest.getCollection());
		return collectionJongoUsersDTO.find(jongoRequest.getQuery(), fecha).as(JongoUsersDTO.class);

	}

	public String save(JongoRequest metadataRequest) {
		logger.info("[save]");
		return null;
	}

}
