package unl.cse.rss;

import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document; 
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList; 


public class unlRSS {
    
	public static final String HUSKER_SPORTS_URL = "http://www.huskers.com/rss.dbml?db_oem_id=100&media=news";
	public static final String UNL_NEWS_URL = "http://ucommxsrv1.unl.edu/rssfeeds/unlinthenewsrss.xml";
	public static final String SCARLET_URL = "http://scarlet.unl.edu/?feed=rss2";
	
	public static final String DEFAULT_URL = SCARLET_URL;
	
    /**
     * Sets the URL for the source of the RSS feeds and creates and prints 
     * objects of type RSS containing individual feeds.
     */
    public static rss[] getNewsFeeds() {
        
    	rss[] feeds = null;
        try {
            
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        
            URL u = new URL( DEFAULT_URL );
        
            Document doc = builder.parse( u.openStream() );
        
            NodeList nodes = doc.getElementsByTagName( "item" );

            feeds = new rss[nodes.getLength()];
        
            for( int i=0; i<nodes.getLength(); i++ ) {
                
                Element element = (Element)nodes.item( i );

                String author = getElementValue(element, "dc:creator");
                String title  = getElementValue(element, "title");
                String link   = getElementValue(element, "link");
                String desc   = getElementValue(element, "description");
                String date   = getElementValue(element, "pubDate");
                
                rss feed = null;
                
                //TODO: instantiate/construct your RSS object using the values above
                
                feeds[i] = feed;
                
            } // End for loop
        
        }catch( Exception ex ) {
            ex.printStackTrace();
            
        } // End try-catch block
    
        return feeds;
    } 
    
    /**
     * Obtains the text of the news feed.
     * @param e An instantiated element representing an feed element.
     * @return String - text of the news feed.
     */
    private static String getCharacterDataFromElement( Element e ) {
        
        try {
            Node child = e.getFirstChild();
        
            if( child instanceof CharacterData ) {
            
                CharacterData cd = (CharacterData) child;
            
                return cd.getData();
            }
        }catch( Exception charErr ) {
            System.out.println( charErr.getMessage() );

        } 
        
        return "";
        
    } 
    
    /**
     * Returns a string representation of the data contained in the node.
     * @param parent Element contains the data in the individual node.
     * @param label String - the indicator text in the RSS feed.
     * @return 
     */
    private static String getElementValue( Element parent, String label ) {
        
        return getCharacterDataFromElement( (Element)parent.getElementsByTagName(label).item(0) );
        
    } 
    
    public static void main( String[] args ) {
        
        rss[] feeds = unlRSS.getNewsFeeds();
        
        for(int i=0; i<feeds.length; i++) {
        	//TODO: print out each feed here
        }
        
    } 
    
} 
