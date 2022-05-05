import com.stm.pegelhub.data.StationManufacturer;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class StationManufacturerController {
    @PostMapping("/stationManufacturer")
    void createStationManufacturer(StationManufacturer stationManufacturer){

    }

    @GetMapping("/stationManufacturer")
    void getStationManufacturer(UUID id){

    }

    @PutMapping("/stationManufacturer")
    void updateStationManufacturer(StationManufacturer stationManufacturer){

    }

    @DeleteMapping("/stationManufacturer")
    void deleteStationManufacturer(UUID id){

    }
}
