package FunctionModule;

import com.stm.pegelhub.component.base.service.EntityService;
import com.stm.pegelhub.data.FunctionModule;
import org.springframework.stereotype.Service;

@Service
public class FunctionModuleEntityService extends EntityService<FunctionModule> {
    protected FunctionModuleEntityService() {
        super(FunctionModule.class);
    }
}
