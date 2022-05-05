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
    void getTakerServiceManufacturer(UUID id){
        super.dataService.get(id);
    }

    @PutMapping("/takerServiceManufacturer")
    void updateTakerServiceManufacturer(TakerServiceManufacturer takerServiceManufacturer){
        super.dataService.save(takerServiceManufacturer);
    }

    @DeleteMapping("/takerServiceManufacturer")
    void deleteTakerServiceManufacturer(UUID id){
        super.dataService.delete(takerServiceManufacturer);
    }
}
