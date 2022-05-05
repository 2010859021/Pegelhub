package Supplier;

import com.stm.pegelhub.component.base.web.EntityController;
import com.stm.pegelhub.data.Supplier;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class SupplierController extends EntityController<Supplier> {
    @PostMapping("/supplier")
    void createSupplier(Supplier supplier){
        super.dataService.save(supplier);
    }

    @GetMapping("/supplier")
    Supplier getSupplier(UUID id){
        Supplier searchObj = new Supplier();
        searchObj.setId(id);
        return super.dataService.findById(searchObj).block();
    }

    @PutMapping("/supplier")
    void updateSupplier(Supplier supplier){
        super.dataService.save(supplier);
    }

    @DeleteMapping("/supplier")
    void deleteSupplier(UUID id){
        super.dataService.delete(getSupplier(id));
    }
}
