package unl.cse.rss;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RssReader {


	public static final Feed DEFAULT_FEED = Feed.BITS_AND_BYTES;

	/**
	 * Sets the URL for the source of the RSS feeds and creates and prints
	 * objects of type RSS containing individual feeds.
	 */
	public static List<Rss> getNewsFeeds() {

		List<Rss> feeds = new ArrayList<Rss>();

		try {

			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			URL u = new URL(DEFAULT_FEED.url);
			Document doc = builder.parse(u.openStream());
			NodeList nodes = null;
			if (DEFAULT_FEED.type == FeedType.RSS) {
				nodes = doc.getElementsByTagName("item");
			} else if (DEFAULT_FEED.type == FeedType.ATOM) {
				nodes = doc.getElementsByTagName("entry");
			}

			for (int i = 0; i < nodes.getLength(); i++) {

				Element element = (Element) nodes.item(i);

				String title = "", link = "", desc = "", dateString = "";
				LocalDateTime dateTime = null;

				if (DEFAULT_FEED.type == FeedType.RSS) {
					title = getElementValue(element, "title");
					link = getElementValue(element, "link");
					desc = getElementValue(element, "description");
					dateString = getElementValue(element, "pubDate");
					dateTime = LocalDateTime.parse(dateString, DEFAULT_FEED.dateFormat);
				} else if (DEFAULT_FEED.type == FeedType.ATOM) {
					title = getElementValue(element, "title");
					link = getAttributeValue(element, "link", "href");
					desc = getElementValue(element, "content");
					dateString = getElementValue(element, "updated");
					dateTime = LocalDateTime.parse(dateString, DEFAULT_FEED.dateFormat);
				}

				// TODO: instantiate/construct your RSS object using the values above
				Rss feed = null;

				feeds.add(feed);

			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return feeds;
	}

	/**
	 * Returns a string representation of the data contained in the node.
	 * 
	 * @param parent
	 *            Element contains the data in the individual node.
	 * @param label
	 *            String - the indicator text in the RSS feed.
	 * @return
	 */
	private static String getElementValue(Element parent, String label) {

		Element e = (Element) parent.getElementsByTagName(label).item(0);
		String result = "";

		try {
			Node child = e.getFirstChild();
			if (child instanceof CharacterData) {
				CharacterData cd = (CharacterData) child;
				result = cd.getData();
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

		return result;
	}

	private static String getAttributeValue(Element parent, String label, String attribute) {

		try {
			Element e = (Element) parent.getElementsByTagName(label).item(0);
			return e.getAttribute(attribute);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public static void main(String[] args) {

		List<Rss> feeds = RssReader.getNewsFeeds();

		for (Rss rss : feeds) {
			// TODO: print out each feed here
		}

	}

}
