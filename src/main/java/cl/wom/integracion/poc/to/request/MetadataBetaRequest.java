package cl.wom.integracion.poc.to.request;

import java.util.Date;
import java.util.List;

import cl.wom.integracion.poc.repository.dto.MetaLevel1;
import lombok.Data;

@Data
public class MetadataBetaRequest {

	private String id;
	private Long longValue;
	private Float floatValue;
	private Date dateValue;
	private MetaLevel1 metaLevel1;
	private List<MetaLevel1> listMetaLevel1;

}
