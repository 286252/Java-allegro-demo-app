package pl.szczerbiak.demoapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TagsDto {
    private String name;

    public  TagsDto(@JsonProperty("name") String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        TagsDto tagsDto = (TagsDto) o;
        return o.equals(tagsDto);
        //Object.equals(name, tagsDto.name);

    }

//    @Override
//    public int hashCode(){
//        return Object.hash(name);
//    }

    @Override
    public String toString() {
        return "TagsDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
