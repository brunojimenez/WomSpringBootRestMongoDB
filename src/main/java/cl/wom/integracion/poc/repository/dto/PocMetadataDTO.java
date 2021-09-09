package cl.wom.integracion.poc.repository.dto;

import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "PocMetadata")
public class PocMetadataDTO {

	@Indexed
	private String id;
	private org.bson.Document document;
	private Map<String, Object> map;

	// No converter found capable of converting from type [org.bson.Document] to
	// type [com.mongodb.DBObject]
	// private DBObject dbObject;

}
