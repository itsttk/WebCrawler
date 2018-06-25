/**
 * 
 * @author Teja
 * This is the class with Main Methods
 */
package webScrapper;

import java.io.IOException; 
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Scrapper {
	
	private String url;
	private TextFormat text_format;
	
	
	/**
	 * This is the Main function 
	 * @param args
	 * @throws IOException
	 */	
	
	public static void main(String[] args) throws IOException {
		
		//no:of relevant topics: change as per requirement
		int k=10;
		Scrapper object=new Scrapper();
		object.isValidInput(args);
		object.relevantTopicsList(k);
	}
	

	
	/**
	 * This is a method to check whether user has given input or not
	 * @param args
	 * @throws IOException
	 */
	
	private void isValidInput(String[] args) throws IOException{
		if(args.length<=0) throw new IOException("Please provide URL for crawling");
		url=args[0];
		isURL(url); //checking whether url is valid or not
	}
	

	
	/**
	 * This is a method to check whether user given input is valid url or not 
	 * @param url: url of the website
	 */
	
	private void isURL(String url){    
		try {
				new URL(url).toURI();
			} catch (MalformedURLException | URISyntaxException e) {
	            System.out.println("invalid URL , please check and try again");
				e.printStackTrace();
			}
     }

  
  
    /**
     * This is a method to generate Document of text from given URL
     * @param url
     * @return returns Document 
     */
  
  	public Document getDom(String url){
        Document doc=null;
        try {
            doc=Jsoup.connect(url).get();
        } catch (IOException e) {
            System.out.println("Document is empty:IP address not found for given URL ");
            e.printStackTrace();
        }
        return doc;
    }

  
  
    /**
     * This is the method to generate the top k frequency relevant topic list
     * @param k
     * @return list of relevant topics
     */
    
	private List<String> relevantTopicsList(int k){
		
		Document temp=getDom(url);
		text_format=new TextFormat(temp);
		text_format.textParse();
		List<String> res=Format_helper.getTopics(k);
		return res;
		
	}
}
