package Contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    // Constants
    private static final String VALID_ID = "C001";
    private static final String VALID_FIRST_NAME = "Marcia";
    private static final String VALID_LAST_NAME = "Rider";
    private static final String VALID_PHONE = "1234567890";
    private static final String VALID_ADDRESS = "133 Main Street";

    private static final String UPDATED_FIRST_NAME = "Grace";
    private static final String UPDATED_LAST_NAME = "Smith";
    private static final String UPDATED_PHONE = "0987654321";
    private static final String UPDATED_ADDRESS = "456 Oak Avenue";

    @Test
    public void testAddContact_withValidContact_expectedSuccess() {

        // Arrange
        ContactService service = new ContactService();
        Contact contact = new Contact(
                VALID_ID,
                VALID_FIRST_NAME,
                VALID_LAST_NAME,
                VALID_PHONE,
                VALID_ADDRESS);

        // Act
        service.addContact(contact);

        // Assert
        assertEquals(contact, service.getContact(VALID_ID));
    }

    @Test
    public void testAddContact_withDuplicateId_expectedException() {

        // Arrange
        ContactService service = new ContactService();

        Contact contact1 = new Contact(
                VALID_ID,
                VALID_FIRST_NAME,
                VALID_LAST_NAME,
                VALID_PHONE,
                VALID_ADDRESS);

        Contact contact2 = new Contact(
                VALID_ID,
                "Alice",
                "Brown",
                "1112223333",
                "100 First Street");

        // Act
        service.addContact(contact1);

        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> service.addContact(contact2));
    }

    @Test
    public void testDeleteContact_withExistingId_expectedContactRemoved() {

        // Arrange
        ContactService service = new ContactService();

        Contact contact = new Contact(
                VALID_ID,
                VALID_FIRST_NAME,
                VALID_LAST_NAME,
                VALID_PHONE,
                VALID_ADDRESS);

        service.addContact(contact);

        // Act
        service.deleteContact(VALID_ID);

        // Assert
        assertNull(service.getContact(VALID_ID));
    }

    @Test
    public void testUpdateContact_withValidData_expectedSuccess() {

        // Arrange
        ContactService service = new ContactService();

        Contact originalContact = new Contact(
                VALID_ID,
                VALID_FIRST_NAME,
                VALID_LAST_NAME,
                VALID_PHONE,
                VALID_ADDRESS);

        service.addContact(originalContact);
        Contact updatedContact = new Contact (
        		VALID_ID,
        		UPDATED_FIRST_NAME,
        		UPDATED_LAST_NAME,
        		UPDATED_PHONE,
        		UPDATED_ADDRESS);
        	

        // Act
        service.updateContact(updatedContact);
        
// Assert
       Contact result = service.getContact(VALID_ID);

        assertAll(
                () -> assertEquals(UPDATED_FIRST_NAME, result.getFirstName()),
                () -> assertEquals(UPDATED_LAST_NAME, result.getLastName()),
                () -> assertEquals(UPDATED_PHONE, result.getPhone()),
                () -> assertEquals(UPDATED_ADDRESS, result.getAddress())
        );
    }

    @Test
    public void testGetContact_withInvalidId_expectedNull() {

        // Arrange
        ContactService service = new ContactService();

        // Act
        Contact contact = service.getContact("BADID");

        // Assert
        assertNull(contact);
    }
}