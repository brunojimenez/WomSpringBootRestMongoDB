package cl.wom.integracion.poc.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.wom.integracion.poc.repository.dto.PocMetadataDTO;
import cl.wom.integracion.poc.service.MetadataService;
import cl.wom.integracion.poc.to.request.MetadataAlfaRequest;
import cl.wom.integracion.poc.to.request.MetadataBetaRequest;

@RestController
@RequestMapping("/metadata")
public class MetadataController {

	/**
	 * Log de la clase.
	 */
	private static final Logger logger = LogManager.getLogger(MetadataController.class);

	/**
	 * Servicio que administra la logica de negocio.
	 */
	@Autowired
	private MetadataService metadataService;

	/**
	 * Method to get a alfa or beta structure from mongodb with casting inside.
	 * 
	 * GET http://localhost:8889/ocp/poc/metadata/getMetadataWithCast/444
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getMetadataWithCast/{id}")
	public ResponseEntity<PocMetadataDTO> getMetadataWithCast(@PathVariable String id) {
		logger.info("[getMetadataWithCast]");
		PocMetadataDTO response = metadataService.getMetadataWithCast(id);
		if (response != null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		return new ResponseEntity<>(new PocMetadataDTO(), HttpStatus.OK);
	}

	/**
	 * Method to get a alfa or beta structure from mongodb.
	 * 
	 * GET http://localhost:8889/ocp/poc/metadata/getMetadataSimple/444
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getMetadataSimple/{id}")
	public ResponseEntity<PocMetadataDTO> getMetadataSimple(@PathVariable String id) {
		logger.info("[getMetadataSimple]");
		PocMetadataDTO response = metadataService.getMetadataSimple(id);
		if (response != null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		return new ResponseEntity<>(new PocMetadataDTO(), HttpStatus.OK);
	}

	/**
	 * Method to save estructure alfa in mongodb.
	 * 
	 * @param metadataAlfaRequest
	 * @return
	 */
// EXAMPLE
// POST http://localhost:8889/ocp/poc/metadata/saveMetadataAlfa
//		{
//		    "id" : "111",
//			"boolValue" : true,
//			"intValue" : 123
//		}
	@PostMapping("/saveMetadataAlfa")
	public ResponseEntity<String> saveMetadataAlfa(@RequestBody @Valid MetadataAlfaRequest metadataAlfaRequest) {
		logger.info("[saveMetadataAlfa]");
		String response = metadataService.saveMetadataAlfa(metadataAlfaRequest);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Method to save estructure beta in mongodb.
	 * 
	 * @param metadataBetaRequest
	 * @return
	 */
// EXAMPLE
// POST http://localhost:8889/ocp/poc/metadata/saveMetadataBeta
//	{
//	    "id": "444",
//	    "longValue": 1.0,
//	    "floatValue": 123,
//	    "dateValue": "2012-04-23T18:25:43.511Z",
//	    "metaLevel1": {
//	        "data1": "clap",
//	        "metaLevel2": {
//	            "data2": "everybody"
//	        }
//	    },
//	    "listMetaLevel1": [
//	        {
//	            "data1": "baquita",
//	            "metaLevel2": {
//	                "data2": "loca"
//	            }
//	        },
//	        {
//	            "data1": "pollito",
//	            "metaLevel2": {
//	                "data2": "pio"
//	            }
//	        }
//	    ]
//	}
	@PostMapping("/saveMetadataBeta")
	public ResponseEntity<String> saveMetadataBeta(@RequestBody @Valid MetadataBetaRequest metadataBetaRequest) {
		logger.info("[saveMetadataBeta]");
		String response = metadataService.saveMetadataBeta(metadataBetaRequest);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
