import com.stm.pegelhub.data.Contact;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ContactController {
    @PostMapping("/contact")
    void createContact(Contact contact){

    }

    @GetMapping("/contact")
    void getContact(UUID id){

    }

    @PutMapping("/contact")
    void updateContact(Contact contact){

    }

    @DeleteMapping("/contact")
    void deleteContact(UUID id){

    }
}
