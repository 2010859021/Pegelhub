package Taker;

import com.stm.pegelhub.component.base.web.EntityController;
import com.stm.pegelhub.data.Taker;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class TakerController extends EntityController<Taker> {
    @PostMapping("/taker")
    void createTaker(Taker taker){
        super.dataService.save(taker);
    }

    @GetMapping("/taker")
    Taker getTaker(UUID id){
        Taker searchObj = new Taker();
        searchObj.setId(id);
        return super.dataService.findById(searchObj).block();
    }

    @PutMapping("/taker")
    void updateTaker(Taker taker){
        super.dataService.save(taker);
    }

    @DeleteMapping("/taker")
    void deleteTaker(UUID id){
        super.dataService.delete(getTaker(id));
    }
}
