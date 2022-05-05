import com.stm.pegelhub.data.Taker;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class TakerController {
    @PostMapping("/taker")
    void createTaker(Taker taker){

    }

    @GetMapping("/taker")
    void getTaker(UUID id){

    }

    @PutMapping("/taker")
    void updateTaker(Taker taker){

    }

    @DeleteMapping("/taker")
    void deleteTaker(UUID id){

    }
}
