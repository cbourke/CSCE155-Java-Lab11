package unl.soc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

/**
 * A JUnit test suite for methods in the {@link Rss} class. 
 * 
 */
public class RssTests {

	/**
	 * Tests the {@link Rss} class by instantiating an instance
	 * and testing the {@link Rss#toString()} method.
	 */
	@Test
	public void testRss001() {

		Rss r = new Rss("RSS TEST 001 - Title", "RSS TEST 001 - Link", "RSS TEST 001 - Content",
		          LocalDateTime.of(2016, 11, 2, 8, 2));
		String s = r.toString();
		assertTrue(s.contains("RSS TEST 001 - Title"), "The title does not appear in the output: "+s);
		assertTrue(s.contains("RSS TEST 001 - Link"), "The link does not appear in the output: "+s);
		assertTrue(s.contains("RSS TEST 001 - Content"), "The content does not appear in the output: "+s);
		assertTrue(s.contains("2016-11-02T08:02"), "The date does not appear in the output: "+s);
	}
	
	/**
	 * Tests the {@link Rss} class by instantiating an instance
	 * and testing the {@link Rss#toString()} method.
	 */
	@Test
	public void testRss002() {

		Rss r = new Rss("RSS TEST 002 - Title", "RSS TEST 002 - Link", "RSS TEST 002 - Content",
		          LocalDateTime.of(1908, 10, 14, 13, 25));
		String s = r.toString();
		assertTrue(s.contains("RSS TEST 002 - Title"), "The title does not appear in the output: "+s);
		assertTrue(s.contains("RSS TEST 002 - Link"), "The link does not appear in the output: "+s);
		assertTrue(s.contains("RSS TEST 002 - Content"), "The content does not appear in the output: "+s);
		assertTrue(s.contains("1908-10-14T13:25"), "The date does not appear in the output: "+s);
	}


}
