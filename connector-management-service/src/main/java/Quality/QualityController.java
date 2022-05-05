package Quality;

import com.stm.pegelhub.component.base.web.EntityController;
import com.stm.pegelhub.data.Quality;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class QualityController extends EntityController<Quality> {
    @PostMapping("/quality")
    void createQuality(Quality quality){
        super.dataService.save(quality);
    }

    @GetMapping("/quality")
    Quality getQuality(UUID id){
        Quality searchObj = new Quality();
        searchObj.setId(id);
        return super.dataService.findById(searchObj).block();
    }

    @PutMapping("/quality")
    void updateQuality(Quality quality){
        super.dataService.save(quality);
    }

    @DeleteMapping("/quality")
    void deleteQuality(UUID id){
        super.dataService.delete(getQuality(id));
    }
}
