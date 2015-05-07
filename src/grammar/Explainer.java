package grammar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.atilika.kuromoji.Token;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Explainer {
	
	public static String explain(Token t) {

		String baseForm = t.getBaseForm();
		if(baseForm==null) baseForm = t.getSurfaceForm();
		
		String result = null;
		try {
			//Document document = Jsoup.connect("http://dict.hjenglish.com/jp/jc/" +URLEncoder.encode(str, "utf-8")).get();
			URL url = new URL("http://dict.hjenglish.com/jp/jc/" + URLEncoder.encode(baseForm, "utf-8"));
			Document document = Jsoup.parse(url, 3000);
			
			Element word = null;
			int i = 0;
			do {
				word = document.getElementById("amw_word_"+i);
				if(word==null){
					word = document.getElementById("amw_word_0");
					break;
				}
				i++;
			} while (!baseForm.equals(word.attr("value")));
			
			if(word==null) return "没有搜索结果";
			Element comment = word.nextElementSibling();
			result = t.getSurfaceForm()+comment.attr("value").replaceAll("<img.+>", "<a></a>");

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "查词失败";
		}
		return result;
	}
	
	public static String explain(String word){
		return explain(Spliter.split(word).get(0));
	}
	
	private static String connect(String s) throws Exception{
		
		URL url = new URL(s);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String line = null;
		StringBuffer sb = new StringBuffer();
		while((line=br.readLine())!=null){
			sb.append(line);
		}
		
		return null;
	}
	
}




