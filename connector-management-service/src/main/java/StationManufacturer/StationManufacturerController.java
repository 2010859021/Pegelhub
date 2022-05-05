package StationManufacturer;

import com.stm.pegelhub.component.base.web.EntityController;
import com.stm.pegelhub.data.StationManufacturer;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class StationManufacturerController extends EntityController<StationManufacturer> {
    @PostMapping("/stationManufacturer")
    void createStationManufacturer(StationManufacturer stationManufacturer){
        super.dataService.save(stationManufacturer);
    }

    @GetMapping("/stationManufacturer")
    void getStationManufacturer(UUID id){
        super.dataService.get(id);
    }

    @PutMapping("/stationManufacturer")
    void updateStationManufacturer(StationManufacturer stationManufacturer){
        super.dataService.save(stationManufacturer);
    }

    @DeleteMapping("/stationManufacturer")
    void deleteStationManufacturer(UUID id){
        super.dataService.delete(stationManufacturer);
    }
}
