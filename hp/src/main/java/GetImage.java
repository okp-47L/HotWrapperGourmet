import java.io.File;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


@MultipartConfig
@WebServlet(urlPatterns = {"/getimage"})
public class GetImage extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		Part part=request.getPart("file");
		String original=part.getSubmittedFileName();
		String extension=original.substring(original.lastIndexOf("."));
		int amount=0;
		File dir = new File("\\\\192.168.33.122\\upload");
		
			if (dir.isDirectory()) {
				 File[] file=dir.listFiles(File::isFile);
				 amount=file.length;
				 amount++;
			} 
			
		String filename="storeImage"+amount+extension;
		
		
		part.write("\\\\192.168.33.122\\upload\\"+filename);
		
	
		String Path ="http://192.168.33.122:8080/HotWrapperGourmet/upload/"+filename;
		
		request.setAttribute("file", Path);
		request.getRequestDispatcher("/result.jsp").forward(request, response);
		
}}