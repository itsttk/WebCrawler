This project crawls any website and will get the most releavant topic list


Classes:
The project contains three classes 

1.	TextFormat.java: This contains main methods and other methods to check whether URL is valid or not. If URL is valid it uses other classes to perform scrapping.
2.	TextFormat.java: This contains methods to perform text cleaning like removing stop words and special characters. Once processing is done this uses Format_helper.java class to extract common topics.
3.	Format_helper.java: It uses HashMap data structure to store keywords and their frequency. Then we will use sorting (Descending order) algorithm to sort HashMap based on value in <key, value> pair. Then we will return the top words of map (as these are most common topics in document from URL) and printing to the console.

Stop Word References:
1.https://algs4.cs.princeton.edu/35applications/stopwords.txt
2.https://github.com/stanfordnlp/CoreNLP/blob/master/data/edu/stanford/nlp/patterns/surface/stopwords.txt


External Libraries:
I have used java HTML parser (jsoup-1.11.3.jar) to perform web scrapping.






