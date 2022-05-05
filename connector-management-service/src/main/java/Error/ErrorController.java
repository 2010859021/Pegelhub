package Error;

import com.stm.pegelhub.data.Error;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ErrorController {
    @PostMapping("/error")
    void createError(Error error){

    }

    @GetMapping("/error")
    void getError(UUID id){

    }

    @PutMapping("/error")
    void updateError(Error error){

    }

    @DeleteMapping("/error")
    void deleteError(UUID id){

    }
}
