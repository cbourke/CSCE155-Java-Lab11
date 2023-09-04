package unl.soc;

import java.time.format.DateTimeFormatter;

public class Feed {

	/**
	 * The department's weekly news letter, CSE Bits and Bytes
	 */
	public static final Feed BITS_AND_BYTES = new Feed("https://newsroom.unl.edu/announce/cse/?format=rss",
			FeedType.RSS, DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z"));
	
	/**
	 * University of Nebraska-Lincoln RSS news feed
	 */
	public static final Feed UNL = new Feed("https://events.unl.edu/upcoming/?format=rss", 
			FeedType.RSS, 
			DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z"));

	/**
	 * Pintrest RSS feed
	 */
	public static final Feed PINTREST = new Feed("https://newsroom.pinterest.com/en/feed/news.xml", 
			FeedType.RSS, 
			DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));

	public final String url;
	public final FeedType type;
	public final DateTimeFormatter dateFormat;
	
	public Feed(String url, FeedType type, DateTimeFormatter dateFormat) {
		this.url = url;
		this.type = type;
		this.dateFormat = dateFormat;
	}
}
