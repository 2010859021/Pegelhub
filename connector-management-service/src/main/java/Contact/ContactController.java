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
    Contact getContact(UUID id){
        Contact searchObj = new Contact();
        searchObj.setId(id);
        return super.dataService.findById(searchObj).block();
    }

    @PutMapping("/contact")
    void updateContact(Contact contact){
        super.dataService.save(contact);
    }

    @DeleteMapping("/contact")
    void deleteContact(UUID id){
        super.dataService.delete(getContact(id));
    }
}
