import com.stm.pegelhub.data.FunctionModule;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class FunctionModuleController {
    @PostMapping("/functionModule")
    void createFunctionModule(FunctionModule functionModule){

    }

    @GetMapping("/functionModule")
    void getFunctionModule(UUID id){

    }

    @PutMapping("/functionModule")
    void updateFunctionModule(FunctionModule functionModule){

    }

    @DeleteMapping("/functionModule")
    void deleteFunctionModule(UUID id){

    }
}
