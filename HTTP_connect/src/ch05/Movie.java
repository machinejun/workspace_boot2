
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
public class Movie {

    private Integer id;
    private String url;
    private String imdbCode;
    private String title;
    private String titleEnglish;
    private String titleLong;
    private String slug;
    private Integer year;
    private Double rating;
    private Integer runtime;
    private List<String> genres = null;
    private String summary;
    private String descriptionFull;
    private String synopsis;
    private String ytTrailerCode;
    private String language;
    private String mpaRating;
    private String backgroundImage;
    private String backgroundImageOriginal;
    private String smallCoverImage;
    private String mediumCoverImage;
    private String largeCoverImage;
    private String state;
    private String dateUploaded;
    private Integer dateUploadedUnix;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

 
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
