package Connector;

import com.stm.pegelhub.component.base.web.EntityController;
import com.stm.pegelhub.data.Connector;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ConnectorController extends EntityController<Connector> {
    @PostMapping("/connector")
    void createConnector(Connector connector){
        super.dataService.save(connector);
    }

    @GetMapping("/connector")
    void getConnector(UUID id){
        super.dataService.get(id);
    }

    @PutMapping("/connector")
    void updateConnector(Connector connector){
        super.dataService.save(connector);
    }

    @DeleteMapping("/connector")
    void deleteConnector(UUID id){
        super.dataService.delete(connector);
    }
}
