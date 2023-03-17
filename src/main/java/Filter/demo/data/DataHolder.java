package Filter.demo.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import Filter.demo.model.Review;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
@Getter
public class DataHolder {
    public static List<Review> reviews;
    @PostConstruct
    public void init(){
        //Here I am pulling the data from the json file and creating
        //object of class Review with the values
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "C:\\Users\\angel\\Desktop\\demo\\src\\main\\java\\Filter\\demo\\data\\json\\reviews.json";
        try {
            reviews = mapper.readValue(new File(jsonString), new TypeReference<List<Review>>(){});;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
