import com.stm.pegelhub.data.TakerServiceManufacturer;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class TakerServiceManufacturerController {
    @PostMapping("/takerServiceManufacturer")
    void createTakerServiceManufacturer(TakerServiceManufacturer takerServiceManufacturer){

    }

    @GetMapping("/takerServiceManufacturer")
    void getTakerServiceManufacturer(UUID id){

    }

    @PutMapping("/takerServiceManufacturer")
    void updateTakerServiceManufacturer(TakerServiceManufacturer takerServiceManufacturer){

    }

    @DeleteMapping("/takerServiceManufacturer")
    void deleteTakerServiceManufacturer(UUID id){

    }
}
