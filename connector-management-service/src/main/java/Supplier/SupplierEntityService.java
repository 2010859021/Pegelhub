package Supplier;

import com.stm.pegelhub.component.base.service.EntityService;
import com.stm.pegelhub.data.Supplier;
import org.springframework.stereotype.Service;

@Service
public class SupplierEntityService extends EntityService<Supplier> {
    public SupplierEntityService() {
        super(Supplier.class);
    }
}
