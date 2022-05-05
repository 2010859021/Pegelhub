import com.stm.pegelhub.data.Connector;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ConnectorController {
    @PostMapping("/connector")
    void createConnector(Connector connector){

    }

    @GetMapping("/connector")
    void getConnector(UUID id){

    }

    @PutMapping("/connector")
    void updateConnector(Connector connector){

    }

    @DeleteMapping("/connector")
    void deleteConnector(UUID id){

    }
}
