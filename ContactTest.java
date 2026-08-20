package Contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactTest {
	
	// Constants 
	private static final String VALID_ID = "C001";
	private static final String VALID_FIRST_NAME = "Marcia";
	private static final String VALID_LAST_NAME = "Rider";
	private static final String VALID_PHONE = "1234567890";
	private static final String VALID_ADDRESS = "133 Main Street";
	
	@Test
	public void testCreateContact_withValidData_expectedSuccess() {
		
	// Arrange & Act 
		Contact contact = new Contact(VALID_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS); 
		// Assert 
		assertAll( () -> assertEquals(VALID_ID, contact.getContactId()), 
				() -> assertEquals(VALID_FIRST_NAME, contact.getFirstName()),
				() -> assertEquals(VALID_LAST_NAME, contact.getLastName()),
				() -> assertEquals(VALID_PHONE, contact.getPhone()),
				() -> assertEquals(VALID_ADDRESS, contact.getAddress()) );			
	}
	@Test
	public void testCreateContact_withNullId_expectedException() {
		
		assertThrows(IllegalArgumentException.class, () -> new Contact(null, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS));
	}
	@Test
	public void testCreateContact_withLongId_expectedException() {
		
		assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS));
	}
	@Test
	public void testContactId_withNoSetter_expectedNotEditable() {
	
		// Arrange 
		Contact contact = new Contact (VALID_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS);
		
		//Assert
		assertEquals(VALID_ID, contact.getContactId());
	}
	@Test
	public void testCreateContact_withNullFirstName_expectedException() {
		assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, null, VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS));
	}
	@Test
	public void testCreateContact_withLongFirstName_expectedException() {
		assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, "VeryLongName", VALID_LAST_NAME, VALID_PHONE, VALID_ADDRESS));	
	}
	@Test
	public void testCreateContact_withNullLastName_expectedException() {
		assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_FIRST_NAME, null, VALID_PHONE, VALID_ADDRESS));
	}
	@Test 
	public void testCreateContact_withLongLastName_expectedException() {
		assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_FIRST_NAME, "VeryLongLastName", VALID_PHONE, VALID_ADDRESS));
	}
	@Test
	public void testCreateContact_withNullPhone_expectedException() {
		assertThrows(IllegalArgumentException.class, () -> new Contact( VALID_ID, VALID_FIRST_NAME, VALID_LAST_NAME, null, VALID_ADDRESS));
	}
	@Test
	public void testCreateContact_withInvalidPhone_expectedException() {
	assertThrows(IllegalArgumentException.class, () -> new Contact( VALID_ID, VALID_FIRST_NAME, VALID_LAST_NAME, "12345", VALID_ADDRESS));
	}
	@Test
	public void testCreateContact_withNullAddress_ExpectedException() {
		assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, null));
	}
	
	@Test
	public void testCreateContact_withLongAddress_expectedException() {
		assertThrows(IllegalArgumentException.class, () -> new Contact(VALID_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_PHONE, "1234567890123456789012345678901"));
	}
	

	@Test
	public void testSetFirstName_withValidData_expectedSuccess() {

	    // Arrange
	    Contact contact = new Contact(
	            VALID_ID,
	            VALID_FIRST_NAME,
	            VALID_LAST_NAME,
	            VALID_PHONE,
	            VALID_ADDRESS);

	    // Act
	    contact.setFirstName("Grace");

	    // Assert
	    assertEquals("Grace", contact.getFirstName());
	}

	@Test
	public void testSetLastName_withValidData_expectedSuccess() {

	    Contact contact = new Contact(
	            VALID_ID,
	            VALID_FIRST_NAME,
	            VALID_LAST_NAME,
	            VALID_PHONE,
	            VALID_ADDRESS);

	    contact.setLastName("Smith");

	    assertEquals("Smith", contact.getLastName());
	}

	@Test
	public void testSetPhone_withValidData_expectedSuccess() {

	    Contact contact = new Contact(
	            VALID_ID,
	            VALID_FIRST_NAME,
	            VALID_LAST_NAME,
	            VALID_PHONE,
	            VALID_ADDRESS);

	    contact.setPhone("0987654321");

	    assertEquals("0987654321", contact.getPhone());
	}

	@Test
	public void testSetAddress_withValidData_expectedSuccess() {

	    Contact contact = new Contact(
	            VALID_ID,
	            VALID_FIRST_NAME,
	            VALID_LAST_NAME,
	            VALID_PHONE,
	            VALID_ADDRESS);

	    contact.setAddress("456 Oak Avenue");

	    assertEquals("456 Oak Avenue", contact.getAddress());
	}
	@Test
	public void testSetFirstName_withNull_expectedException() {

	    Contact contact = new Contact(
	            VALID_ID,
	            VALID_FIRST_NAME,
	            VALID_LAST_NAME,
	            VALID_PHONE,
	            VALID_ADDRESS);

	    assertThrows(IllegalArgumentException.class,
	            () -> contact.setFirstName(null));
	}
	@Test
	public void testSetLastName_withNull_expectedException() {

	    Contact contact = new Contact(
	            VALID_ID,
	            VALID_FIRST_NAME,
	            VALID_LAST_NAME,
	            VALID_PHONE,
	            VALID_ADDRESS);

	    assertThrows(IllegalArgumentException.class,
	            () -> contact.setLastName(null));
	}
	@Test
	public void testSetPhone_withInvalidPhone_expectedException() {

	    Contact contact = new Contact(
	            VALID_ID,
	            VALID_FIRST_NAME,
	            VALID_LAST_NAME,
	            VALID_PHONE,
	            VALID_ADDRESS);

	    assertThrows(IllegalArgumentException.class,
	            () -> contact.setPhone("12345"));
	}
	@Test
	public void testSetAddress_withNull_expectedException() {

	    Contact contact = new Contact(
	            VALID_ID,
	            VALID_FIRST_NAME,
	            VALID_LAST_NAME,
	            VALID_PHONE,
	            VALID_ADDRESS);

	    assertThrows(IllegalArgumentException.class,
	            () -> contact.setAddress(null));
	}
	@Test
	public void testHashCode_withEqualObjects_expectedSameHashCode() {

	    Contact contact1 = new Contact(
	            VALID_ID,
	            VALID_FIRST_NAME,
	            VALID_LAST_NAME,
	            VALID_PHONE,
	            VALID_ADDRESS);

	    Contact contact2 = new Contact(
	            VALID_ID,
	            VALID_FIRST_NAME,
	            VALID_LAST_NAME,
	            VALID_PHONE,
	            VALID_ADDRESS);

	    assertEquals(contact1.hashCode(), contact2.hashCode());
	}
	@Test
	public void testEquals_withNull_expectedFalse() {

	    Contact contact = new Contact(
	            VALID_ID,
	            VALID_FIRST_NAME,
	            VALID_LAST_NAME,
	            VALID_PHONE,
	            VALID_ADDRESS);

	    assertFalse(contact.equals(null));
	}
	
	@Test
	public void testEquals_withDifferentObject_expectedFalse() {

	    Contact contact = new Contact(
	            VALID_ID,
	            VALID_FIRST_NAME,
	            VALID_LAST_NAME,
	            VALID_PHONE,
	            VALID_ADDRESS);

	    assertFalse(contact.equals("Not a Contact"));
	}
	@Test
	public void testEquals_withSameObject_expectedTrue() {

	    Contact contact = new Contact(
	            VALID_ID,
	            VALID_FIRST_NAME,
	            VALID_LAST_NAME,
	            VALID_PHONE,
	            VALID_ADDRESS);

	    assertTrue(contact.equals(contact));
	}
	@Test
	public void testEquals_withEqualContacts_expectedTrue() {

	    Contact contact1 = new Contact(
	            VALID_ID,
	            VALID_FIRST_NAME,
	            VALID_LAST_NAME,
	            VALID_PHONE,
	            VALID_ADDRESS);

	    Contact contact2 = new Contact(
	            VALID_ID,
	            VALID_FIRST_NAME,
	            VALID_LAST_NAME,
	            VALID_PHONE,
	            VALID_ADDRESS);

	    assertTrue(contact1.equals(contact2));
	}
	@Test
	public void testEquals_withDifferentContacts_expectedFalse() {

	    Contact contact1 = new Contact(
	            VALID_ID,
	            VALID_FIRST_NAME,
	            VALID_LAST_NAME,
	            VALID_PHONE,
	            VALID_ADDRESS);

	    Contact contact2 = new Contact(
	            VALID_ID,
	            "Grace",
	            VALID_LAST_NAME,
	            VALID_PHONE,
	            VALID_ADDRESS);

	    assertFalse(contact1.equals(contact2));
	}
}
	