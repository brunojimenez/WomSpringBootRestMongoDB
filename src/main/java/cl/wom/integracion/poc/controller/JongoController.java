package cl.wom.integracion.poc.controller;

import java.text.ParseException;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jongo.MongoCursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.wom.integracion.poc.repository.dto.JongoUsersDTO;
import cl.wom.integracion.poc.service.JongoService;
import cl.wom.integracion.poc.to.request.JongoRequest;

@RestController
@RequestMapping("/jongo")
public class JongoController {

	/**
	 * Log de la clase.
	 */
	private static final Logger logger = LogManager.getLogger(JongoController.class);

	/**
	 * Servicio que administra la logica de negocio.
	 */
	@Autowired
	private JongoService jongoService;

	@PostMapping("/find")
	public ResponseEntity<MongoCursor<JongoUsersDTO>> find(@RequestBody JongoRequest jongoRequest) {
		logger.info("[get]");
		MongoCursor<JongoUsersDTO> response = jongoService.find(jongoRequest);
		if (response != null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@PostMapping("/findOne")
	public ResponseEntity<JongoUsersDTO> findOne(@RequestBody JongoRequest jongoRequest) {
		logger.info("[get]");
		JongoUsersDTO response = jongoService.findOne(jongoRequest);
		if (response != null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		return new ResponseEntity<>(new JongoUsersDTO(), HttpStatus.OK);
	}

	@PostMapping("/findByDate")
	public ResponseEntity<MongoCursor<JongoUsersDTO>> findByDate(@RequestBody JongoRequest jongoRequest)
			throws ParseException {
		logger.info("[get]");
		MongoCursor<JongoUsersDTO> response = jongoService.findByDate(jongoRequest);
		if (response != null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody @Valid JongoRequest jongoRequest) {
		logger.info("[save]");
		String response = jongoService.save(jongoRequest);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
