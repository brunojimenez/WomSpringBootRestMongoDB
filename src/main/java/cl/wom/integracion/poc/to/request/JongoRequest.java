package cl.wom.integracion.poc.to.request;

import lombok.Data;

@Data
public class JongoRequest {

	private String collection;
	private String query;
	private String fecha;

}
