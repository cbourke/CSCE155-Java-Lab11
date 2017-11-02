package unl.cse.rss;

import java.time.format.DateTimeFormatter;

public class Feed {

	/**
	 * The department's weekly news letter, CSE Bits and Bytes
	 */
	public static final Feed BITS_AND_BYTES = new Feed("https://newsroom.unl.edu/announce/cse/?format=rss",
			FeedType.RSS, DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z"));
	
	/**
	 * Husker sports news feed
	 */
	public static final Feed HUSKER_SPORTS = new Feed("http://www.huskers.com/rss.dbml?db_oem_id=100&media=news",
			FeedType.RSS, DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss z"));

	/**
	 * This is a proxy URL to avoid required usage of HTTPS and to avoid 429
	 * errors It may not work if the proxy is down or has not been maintained
	 */
	public static final Feed REDDIT = new Feed("http://cse.unl.edu/~cbourke/proxies/redditRSS.php", FeedType.ATOM, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssz"));

	public final String url;
	public final FeedType type;
	public final DateTimeFormatter dateFormat;
	
	public Feed(String url, FeedType type, DateTimeFormatter dateFormat) {
		this.url = url;
		this.type = type;
		this.dateFormat = dateFormat;
	}
}
