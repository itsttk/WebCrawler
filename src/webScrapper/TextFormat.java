/**
 * 
 * @author Teja
 *
 */
package webScrapper;

import java.util.HashSet; 
import java.util.Scanner;
import org.jsoup.nodes.Document;

public class TextFormat {
	
	private HashSet<String> stopWordsSet;
	private Document doc;
	
	/**
	 * Constructor for TextFormat class with a specified Document 
	 * @param doc
	 */
	
	public TextFormat(Document doc){
		this.doc=doc;
		stopWordsSet=new HashSet<String>();
	}

	
	
	/**
	 * This is a method to parse Text
	 */
	
	public void textParse(){
		getStopword();
		getKeyWord();
	}

	
	
	/**
	 * This is a method to load stopwords from .txt file into stopWordsSet
	 */

	private void getStopword(){
		Scanner scan = new Scanner(getClass().getResourceAsStream("stopwords.txt"));
		while (scan.hasNext()) {
			stopWordsSet.add(scan.next());
		}
		scan.close();
	}

	
	
	/**
	 * This is a method to check whether a give string is a stopword or not
	 * @param String s
	 * @return boolean
	 */

	private boolean isStopWord(String s){
		return stopWordsSet.contains(s.toLowerCase());
	}
	

	
	
    /**
     * This is a method to filter key words from a given document and removing stopwords
     */

	private void getKeyWord(){
		
		Scanner scan=new Scanner(doc.text());
		
		while(scan.hasNext()){
			String line=scan.next();
			String temp=removePunctuation(line);
		
			if(!isStopWord(temp)&&!temp.isEmpty()) {
				new Format_helper().addWord(temp);
			}
		}
		scan.close();
	}
	

	
	
	/**
	 * This is a method to remove punctuation, any special characters or any spaces
	 * @param String s
	 * @return String
	 */

	private String removePunctuation(String s){
		
		String str = s.trim(); //remove space
		str = s.replaceAll("[^A-Za-z0-9]", "");	 //replace all the characters other than letters and digits
		
		return str;						
	}
	
}
