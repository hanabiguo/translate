package servlet;

import grammar.Spliter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.atilika.kuromoji.Token;

public class FileServlet extends HttpServlet {
	
	static File file;
	private static RandomAccessFile raf;
	private static long point = 0;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			if(file==null){
				String webRootPath = request.getSession().getServletContext().getRealPath("/");
				file = new File(webRootPath + "txt/hyouka.txt");
			}
			
			
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<div id='text'>");
			
			for(int i=0;i<15;i++){
				out.print("<div>");
				out.print("&nbsp;&nbsp;&nbsp;&nbsp;");
				List<Token> tokens = Spliter.split(readline());
				for(Token t : tokens){
					out.print("<span>");
					out.print(t.getSurfaceForm());
					out.print("</span>");
				}
				out.print("</div>");
			}
			
			out.print("</div>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public static String readline() throws Exception{
		
		raf = new RandomAccessFile(file, "r");
		if(point!=0) raf.seek(point);
		String line = raf.readLine();
		line = new String(line.getBytes("8859_1"), "utf-8");
		point = raf.getFilePointer();
		return line;
	}

}
