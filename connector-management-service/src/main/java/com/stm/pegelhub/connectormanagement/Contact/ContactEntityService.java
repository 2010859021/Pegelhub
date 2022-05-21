package com.stm.pegelhub.connectormanagement.Contact;

import com.stm.pegelhub.component.base.service.EntityService;
import com.stm.pegelhub.data.Contact;
import org.springframework.stereotype.Service;

@Service
public class ContactEntityService extends EntityService<Contact> {

    protected ContactEntityService() {
        super(Contact.class);
    }
}
