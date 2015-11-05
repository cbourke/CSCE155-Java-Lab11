package unl.cse.rss;

import java.net.URL;
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
    
	public static final String UNL_NEWS_URL = "http://newsroom.unl.edu/releases/?format=xml";
	public static final String HUSKER_SPORTS_URL = "http://www.huskers.com/rss.dbml?db_oem_id=100&media=news";
	public static final String REDDIT_URL = "https://www.reddit.com/.rss";
	
	public static final String DEFAULT_URL = UNL_NEWS_URL;
	
    /**
     * Sets the URL for the source of the RSS feeds and creates and prints 
     * objects of type RSS containing individual feeds.
     */
    public static List<Rss> getNewsFeeds() {
        
    	List<Rss> feeds = new ArrayList<Rss>();

        try {
            
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            URL u = new URL(DEFAULT_URL);
            Document doc = builder.parse(u.openStream());
            NodeList nodes = doc.getElementsByTagName("item");

            for( int i=0; i<nodes.getLength(); i++ ) {
                
                Element element = (Element)nodes.item( i );

                String title  = getElementValue(element, "title");
                String link   = getElementValue(element, "link");
                String desc   = getElementValue(element, "description");
                String date   = getElementValue(element, "pubDate");
                
                //TODO: instantiate/construct your RSS object using the values above
                Rss feed = null;
                
                feeds.add(feed);

            }

        } catch(Exception e) {
        	throw new RuntimeException(e);
        }
        
        return feeds;
    } 
    
    /**
     * Returns a string representation of the data contained in the node.
     * @param parent Element contains the data in the individual node.
     * @param label String - the indicator text in the RSS feed.
     * @return 
     */
    private static String getElementValue(Element parent, String label) {
    	
    	Element e = (Element)parent.getElementsByTagName(label).item(0);
    	String result = "";
        
        try {
            Node child = e.getFirstChild();
            if( child instanceof CharacterData ) {
                CharacterData cd = (CharacterData) child;
                result = cd.getData();
            }
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        } 
        
        return result;
    } 
    
    public static void main( String[] args ) {
        
        List<Rss> feeds = RssReader.getNewsFeeds();

        for(Rss rss : feeds) {
        	//TODO: print out each feed here
        }
        
    } 
    
} 
