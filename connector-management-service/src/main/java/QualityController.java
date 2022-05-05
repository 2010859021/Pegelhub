import com.stm.pegelhub.data.Quality;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class QualityController {
    @PostMapping("/quality")
    void createQuality(Quality quality){

    }

    @GetMapping("/quality")
    void getQuality(UUID id){

    }

    @PutMapping("/quality")
    void updateQuality(Quality quality){

    }

    @DeleteMapping("/quality")
    void deleteQuality(UUID id){

    }
}
