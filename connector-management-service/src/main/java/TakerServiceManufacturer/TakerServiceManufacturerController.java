package TakerServiceManufacturer;

import com.stm.pegelhub.component.base.web.EntityController;
import com.stm.pegelhub.data.TakerServiceManufacturer;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class TakerServiceManufacturerController extends EntityController<TakerServiceManufacturer> {
    @PostMapping("/takerServiceManufacturer")
    void createTakerServiceManufacturer(TakerServiceManufacturer takerServiceManufacturer){
        super.dataService.save(takerServiceManufacturer);
    }

    @GetMapping("/takerServiceManufacturer")
    TakerServiceManufacturer getTakerServiceManufacturer(UUID id){
        TakerServiceManufacturer searchObj = new TakerServiceManufacturer();
        searchObj.setId(id);
        return super.dataService.findById(searchObj).block();
    }

    @PutMapping("/takerServiceManufacturer")
    void updateTakerServiceManufacturer(TakerServiceManufacturer takerServiceManufacturer){
        super.dataService.save(takerServiceManufacturer);
    }

    @DeleteMapping("/takerServiceManufacturer")
    void deleteTakerServiceManufacturer(UUID id){
        super.dataService.delete(getTakerServiceManufacturer(id));
    }
}
