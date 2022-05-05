package Quality;

import com.stm.pegelhub.component.base.service.EntityService;
import com.stm.pegelhub.data.Quality;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class QualityEntityService extends EntityService<Quality> {
    protected QualityEntityService(Class<Quality> qualityClass) {
        super(qualityClass);
    }
}
