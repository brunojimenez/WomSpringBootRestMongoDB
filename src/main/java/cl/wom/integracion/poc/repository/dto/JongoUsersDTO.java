package cl.wom.integracion.poc.repository.dto;

import java.util.Date;

import org.springframework.data.mongodb.core.index.Indexed;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JongoUsersDTO {

	@Indexed
	private String _id;
	private String rut;
	private Date fecha;
	private Boolean boolValue;
	private Integer intValue;

}
