import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class AssertionsTest {
	@Test
	void testAssertions() {
		
		assertEquals(10,7+3,"Yes 7+3=10");
		
		assertTrue(4>1,"This Condition is true");
		
		assertFalse(1>4,"This Condition is False");
		
		assertNull(null,"Assertion value is null");
		
		assertNotNull(new Object(),"An Object is created which will return a reference"
				+ " to that object which is not null");
	}
}
