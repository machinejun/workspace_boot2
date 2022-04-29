
package ch05;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Data {

    private Integer movieCount;
    private Integer limit;
    private Integer pageNumber;
    private List<Movie> movies = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

 

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
