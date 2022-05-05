import com.stm.pegelhub.data.Supplier;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class SupplierController {
    @PostMapping("/supplier")
    void createSupplier(Supplier supplier){

    }

    @GetMapping("/supplier")
    void getSupplier(UUID id){

    }

    @PutMapping("/supplier")
    void updateSupplier(Supplier supplier){

    }

    @DeleteMapping("/supplier")
    void deleteSupplier(UUID id){

    }
}
