package Contact;

import com.stm.pegelhub.component.base.web.EntityController;
import com.stm.pegelhub.data.Contact;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ContactController extends EntityController<Contact> {
    @PostMapping("/contact")
    void createContact(Contact contact){
        super.dataService.save(contact);
    }

    @GetMapping("/contact")
    void getContact(UUID id){
        super.dataService.get(id);
    }

    @PutMapping("/contact")
    void updateContact(Contact contact){
        super.dataService.save(contact);
    }

    @DeleteMapping("/contact")
    void deleteContact(UUID id){
        super.dataService.delete(contact);
    }
}
