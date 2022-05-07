package Supplier;

import com.stm.pegelhub.component.base.web.EntityController;
import com.stm.pegelhub.data.Supplier;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/supplier")
public class SupplierController extends EntityController<Supplier> {
    @PostMapping("/")
    Mono<Supplier> createSupplier(@RequestBody Supplier supplier) {
        return super.dataService.save(supplier);
    }

    @GetMapping("/{uuid}")
    Supplier getSupplierById(@PathVariable UUID uuid) {
        Supplier searchObj = new Supplier();
        searchObj.setId(uuid);
        return super.dataService.findById(searchObj).block();
    }

    @GetMapping("/")
    Flux<Supplier> getAllSuppliers() {
        return super.dataService.findAll();
    }

    @PutMapping("/")
    Mono<Supplier> updateSupplier(@RequestBody Supplier supplier) {
        return super.dataService.save(supplier);
    }

    @DeleteMapping("/{uuid:UUID}")
    void deleteSupplier(@PathVariable UUID uuid) {
        super.dataService.delete(getSupplierById(uuid));
    }
}
