package grammar;

import java.util.List;

import org.atilika.kuromoji.Token;
import org.atilika.kuromoji.Tokenizer;
import org.atilika.kuromoji.Tokenizer.Builder;
import org.atilika.kuromoji.Tokenizer.Mode;

public class Spliter {

	public static List<Token> split(String word){
		Builder builder = Tokenizer.builder();  
		  
		builder.mode(Mode.SEARCH); 
		Tokenizer normal = builder.build();  
		List<Token> tokens = normal.tokenize(word);  
		
		/*for(Token t: tokens){
			System.out.println(t.getSurfaceForm());
		}*/
		return tokens;
	}
}
