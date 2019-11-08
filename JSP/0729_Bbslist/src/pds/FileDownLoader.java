package pds;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @webServlet("/filedown")
public class FileDownLoader extends HttpServlet{

	ServletConfig mConfig = null; // 업로드한 파일의 취득 경로를 얻기위함
	static final int BUFFER_SIZE = 8192;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 서블릿 부분에서 초기화를 해주는코드
		super.init(config);
		mConfig = config;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("file downloader doget");
			
			String filename = req.getParameter("filename");
			String _seq = req.getParameter("seq");
			int seq = Integer.parseInt(_seq);
			
			// download 증가
			
			ipdsDao dao = PdsDao.getInstance();
			dao.pdsDownCount(seq);
			
			BufferedOutputStream out = new BufferedOutputStream(resp.getOutputStream());
			
			String filePath = "";
			
			// tomcat 경로 취득
			filePath = mConfig.getServletContext().getRealPath("/upload"); // 아까 설정한 upload로 경로 설정
			// 폴더 경로
			// filePath = "d:\\tmp";
			
			filePath = filePath + "\\" + filename;	// 경로와 이름을 붙인다.
			System.out.println("다운경로"+filePath);
			
			File f = new File(filePath);
			
			if(f.exists() && f.canRead()) {
				// window download 창
				resp.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\";");
				resp.setHeader("Content-Transfer-Encoding", "binary;");		// 2진수로 인코딩
				resp.setHeader("Content-Length", "" + f.length());	// 길이값을 구한다.
				resp.setHeader("Pragma", "no-cache;"); 	// 저장을 할껀지(No)
				resp.setHeader("Expires", "-1;");	// 유효기간 무한대(-1)
				
				// 파일 생성, 기입
				BufferedInputStream fileInput = new BufferedInputStream(new FileInputStream(f));
				
				byte buffer[] = new byte[BUFFER_SIZE];	// 바이트 단위의 사이즈로 잡고
				
				int read = 0;
				while((read = fileInput.read(buffer)) != -1) {	// 읽어들인거를 buffer에 집어넣는다.
					out.write(buffer, 0, read);	// 실제 다운로드
				}
				fileInput.close();
				out.close();
				
			}
			
			
	}		

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	
	
}
