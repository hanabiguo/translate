package grammar;

import java.util.Arrays;
import java.util.List;

import org.atilika.kuromoji.Token;
import org.atilika.kuromoji.Tokenizer;
import org.atilika.kuromoji.Tokenizer.Builder;
import org.atilika.kuromoji.Tokenizer.Mode;

public class Demo {

	public static void main(String[] args) {

		String word = "書い";  
		Builder builder = Tokenizer.builder();  
		  
		//builder.mode(Mode.SEARCH); 
		Tokenizer normal = builder.build();  
		List<Token> tokensNormal = normal.tokenize(word);  
		
		for(Token t: tokensNormal){
			System.out.println(t.getSurfaceForm());
			System.out.println("allFeatures : " + t.getAllFeatures());
		}
/*		for (Token token : tokensNormal) {  
		    System.out.println("==================================================");  
		    System.out.println("allFeatures : " + token.getAllFeatures());  
		    System.out.println("partOfSpeech : " + token.getPartOfSpeech());  
		    System.out.println("position : " + token.getPosition());  
		    System.out.println("reading : " + token.getReading());  
		    System.out.println("surfaceFrom : " + token.getSurfaceForm());  
		    System.out.println("allFeaturesArray : " + Arrays.asList(token.getAllFeaturesArray()));  
		    System.out.println("辞書にある言葉? : " + token.isKnown());  
		    System.out.println("未知語? : " + token.isUnknown());  
		    System.out.println("ユーザ定義? : " + token.isUser());  
		} */
	}

}
