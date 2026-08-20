package Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactService {

    private final List<Contact> contacts;

    public ContactService() {
        contacts = new ArrayList<>();
    }

    // Add contact
    public void addContact(Contact contact) {

        if (getContact(contact.getContactId()) != null) {
            throw new IllegalArgumentException("Contact ID already exists.");
        }

        contacts.add(contact);
    }

    // Delete contact
    public void deleteContact(String contactId) {

        Contact contact = findContact(contactId);

        if (contact != null) {
            contacts.remove(contact);
        }
    }

    // Update contact
    public void updateContact(Contact updatedContact) {

        Contact contact = findContact(updatedContact.getContactId());

        if (contact != null) {
           contact.setFirstName(updatedContact.getFirstName());
           
           contact.setLastName(updatedContact.getLastName());
           contact.setPhone(updatedContact.getPhone());
           contact.setAddress(updatedContact.getAddress());
        }
    }

    // Return a copy of the contact
    public Contact getContact(String contactId) {

        Contact contact = findContact(contactId);

        if (contact == null) {
            return null;
        }

        return new Contact(
                contact.getContactId(),
                contact.getFirstName(),
                contact.getLastName(),
                contact.getPhone(),
                contact.getAddress());
    }

    // Private helper method
    private Contact findContact(String contactId) {

        for (Contact contact : contacts) {

            if (contact.getContactId().equals(contactId)) {
                return contact;
            }
        }

        return null;
    }
}