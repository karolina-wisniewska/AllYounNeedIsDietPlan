package pl.coderslab.allyouneedisdietplan.model.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Link {
  private Self self;

}