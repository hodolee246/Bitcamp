package Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;

import Store.StoreDao;
import Store.StoreDto;
import Store.iStoreDao;
import sun.rmi.server.Dispatcher;
import sun.swing.StringUIClientPropertyKey;


@WebServlet("/storecontrol")
public class Controller extends HttpServlet {
	iStoreDao storeDao = StoreDao.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String command = req.getParameter("command");
		
		if(command.equals("list")) {
			int page = Integer.parseInt(req.getParameter("page"));
			List<StoreDto> list = new ArrayList<StoreDto>();
			list = storeDao.getProduct(page);
			int pCount = storeDao.countProduct();
			req.setAttribute("list", list);
			req.setAttribute("pCount", pCount);
			req.getRequestDispatcher("./store/Store_List.jsp").forward(req, resp);
		}
		
		else if(command.equals("add")) {
			resp.sendRedirect("./store/Store_Add.jsp");
		}
		
		else if(command.equals("detail")) {
			//System.out.println("GET DETAILE�뱾�뼱�샂");
			int seq = Integer.parseInt(req.getParameter("seq"));
			StoreDto storeDto = storeDao.detailProduct(seq);
			
			
			req.setAttribute("StoreDto", storeDto);
			req.getRequestDispatcher("./store/Store_Detail.jsp").forward(req, resp);
			
		}
		
		else if(command.equals("update")) {
			
			int seq = Integer.parseInt(req.getParameter("seq"));
			StoreDto storeDto = storeDao.detailProduct(seq);
			
			
			req.setAttribute("StoreDto", storeDto);
			req.getRequestDispatcher("./store/Store_Update.jsp").forward(req, resp);
		}
		
		else if(command.equals("delete")) {
			System.out.println("SEQ紐⑥쓬:"+req.getParameter("seq"));
			String sseq = req.getParameter("seq");
			int count = StringUtils.countMatches(sseq, ",");
			//System.out.println("count:"+count);
			String s_seq[] = sseq.split(",");
			iStoreDao storeDao = StoreDao.getInstance();
			for (int i = 0; i < s_seq.length; i++) {
				/* System.out.println("s_seq["+i+"] = "+s_seq[i]); */
				storeDao.deleteProduct(Integer.parseInt(s_seq[i]));
			}
			List<StoreDto> list = new ArrayList<StoreDto>();
			list = storeDao.getProduct(0);
			int pCount = storeDao.countProduct();
			req.setAttribute("list", list);
			req.setAttribute("pCount", pCount);
			req.getRequestDispatcher("./store/Store_List.jsp").forward(req, resp);
		}
		else if(command.equals("top")) {
			System.out.println("top 도착");
			int page = Integer.parseInt(req.getParameter("page"));
			List<StoreDto> list = new ArrayList<StoreDto>();
			list = storeDao.getProduct(page);
			
			req.setAttribute("list", list);
			req.getRequestDispatcher("./store/Store_Top.jsp").forward(req, resp);
			System.out.println("top 나감");
		}
		else if(command.equals("finding")) {
			String sel = req.getParameter("select");
			String fText = req.getParameter("fText");
			int page = Integer.parseInt(req.getParameter("page"));
//			System.out.println("sel:"+sel+", fText:"+fText);
			
			List<StoreDto> list = new ArrayList<StoreDto>();
			list = storeDao.findProduct(sel, fText,page);
			req.setAttribute("list", list);
			req.setAttribute("fText", fText);
			req.getRequestDispatcher("./store/Store_FindList.jsp").forward(req, resp);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String command = req.getParameter("command");

			if(command.equals("addProduct")) {
				String fupload = "d:\\123\\WebContent\\store_images"; //占쏙옙占시몌옙占쏙옙占싱쇽옙占쏙옙 folder占쏙옙占쏙옙 upload占쏙옙占� 占쏙옙占쏙옙

				// 占쏙옙占쏙옙 占쏙옙占쏙옙(on,off占쌔듸옙 占쌘뤄옙占싱삼옙 X)
				//String fupload = "d:\\tmp";

				System.out.println("占쏙옙占싹억옙占싸듸옙 占쏙옙占쏙옙:"+fupload);

				String yourTempDir = fupload;
				int yourMaxRequestSize = 100 * 1024 * 1024;	//	1Mbyte
				int yourMaxMemorySize = 100 * 1024;			// 	1Kbyte

				// form field占쏙옙 占쏙옙占쏙옙占싶몌옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙(getParmeter占쏙옙 占쏙옙占쌨아울옙!)
						
				int price = 0;
				int pCount_ = 0;
				String pCode = "";
				String pName = "";
				String content = "";
				String pSize = "";

				// file name(DB占쏙옙 占쌍억옙慣占� 占쏙옙占쏙옙 占쌜억옙)
				List<String> filename = new ArrayList<String>();
				
				boolean isMultipart = ServletFileUpload.isMultipartContent(req);	//isMultipartContent占쏙옙 占쏙옙占식쇽옙 占싶억옙占싼댐옙~

				if(isMultipart){	// multipart占쏙옙 풀占쏙옙 占쏙옙치占쏙옙 占쌜억옙
						// FileItem占쏙옙 占쏙옙占쏙옙
						DiskFileItemFactory factory = new DiskFileItemFactory();
						factory.setSizeThreshold(yourMaxMemorySize);
						factory.setRepository(new File(yourTempDir));
						
						ServletFileUpload upload = new ServletFileUpload(factory);
						upload.setSizeMax(yourMaxRequestSize);
						
						//list 占쏙옙占쏙옙
						List<FileItem> items = null;
						try {
							items = upload.parseRequest(req);
							
						} catch (FileUploadException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Iterator<FileItem> it = items.iterator();
						while(it.hasNext()){
							FileItem item = it.next();
							
							if(item.isFormField()){	// id,title,content占쏙옙 占싼억옙占�
								if(item.getFieldName().equals("price")){
									price = Integer.parseInt((item.getString("utf-8")));	// id占쏙옙 占쌨울옙占쏙옙
								}
								else if(item.getFieldName().equals("pCount")){
									pCount_ = Integer.parseInt(item.getString("utf-8"));	// title占쏙옙 占쌨울옙占쏙옙
								}
								else if(item.getFieldName().equals("pCode")) {
									pCode = item.getString("utf-8");
								}
								else if(item.getFieldName().equals("title")){
									pName = item.getString("utf-8");	// content占쏙옙 占쌨울옙占쏙옙
								}
								else if(item.getFieldName().equals("pSize")) {
									pSize = item.getString("utf-8");
								}
								else if(item.getFieldName().equals("content")) {
									content = item.getString("utf-8");
								}
							}
							else{	// fileload(input type="file")占쏙옙 占싼억옙占�
								if(item.getFieldName().equals("fileload1")){
									
										filename.add(processUploadFile(item, fupload));
									
								}
								else if(item.getFieldName().equals("fileload2")) {
									
										filename.add(processUploadFile(item, fupload));
									
								}
								else if(item.getFieldName().equals("fileload3")) {
									
										filename.add(processUploadFile(item, fupload));
									
								}
								else if(item.getFieldName().equals("fileload4")) {
									
										filename.add(processUploadFile(item, fupload));
									
								}
									
								
							}
						}
					
				}
				else{
					System.out.println("multipart 占싣댐옙");
				}
				System.out.println("filename:"+filename.toString());
				String finFileName = "";
				for (int i = 0; i < filename.size(); i++) {
					if(filename.get(i).toString().equals("") || filename.get(i) == null) {
						System.out.println("�뿬湲� �뱾�뼱�솕�뒿�땲�떎.");
						finFileName += " ,";
					}
					else {
						finFileName += filename.get(i).toString()+",";
					}
					
				/*
				 * if( i == filename.size()-1 && !filename.get(i).toString().equals("")) {
				 * finFileName += filename.get(i).toString(); } else if(i != filename.size()-1){
				 * finFileName += filename.get(i).toString()+","; }
				 */
					
				}
				System.out.println("finFileName:"+finFileName);
				iStoreDao storeDao = StoreDao.getInstance();
				StoreDto storeDto = new StoreDto(pCode, pName, pCount_, price, content, finFileName, pSize);
				boolean a = storeDao.addProduct(storeDto);
				
				
				List<StoreDto> list = new ArrayList<StoreDto>();
				list = storeDao.getProduct(0);
				int pCount = storeDao.countProduct();
				req.setAttribute("list", list);
				req.setAttribute("pCount", pCount);
				req.getRequestDispatcher("./store/Store_List.jsp").forward(req, resp);
				
				 
			}
			
			else if(command.equals("updateProduct")) {
			/* System.out.println("POST updateProduct�뱾�뼱�샂"); */
				iStoreDao storeDao = StoreDao.getInstance();
				String fupload = "d:\\123\\WebContent\\store_images"; //占쏙옙占시몌옙占쏙옙占싱쇽옙占쏙옙 folder占쏙옙占쏙옙 upload占쏙옙占� 占쏙옙占쏙옙



				System.out.println("占쏙옙占싹억옙占싸듸옙 占쏙옙占쏙옙:"+fupload);

				String yourTempDir = fupload;
				int yourMaxRequestSize = 100 * 1024 * 1024;	//	1Mbyte
				int yourMaxMemorySize = 100 * 1024;			// 	1Kbyte

				
				int seq = 0;		
				int price = 0;
				int pCount = 0;
				String pCode = "";
				String pName = "";
				String content = "";
				String pSize = "";


				List<String> filename = new ArrayList<String>();
				
				boolean isMultipart = ServletFileUpload.isMultipartContent(req);	//isMultipartContent占쏙옙 占쏙옙占식쇽옙 占싶억옙占싼댐옙~

				if(isMultipart){	

						DiskFileItemFactory factory = new DiskFileItemFactory();
						factory.setSizeThreshold(yourMaxMemorySize);
						factory.setRepository(new File(yourTempDir));
						
						ServletFileUpload upload = new ServletFileUpload(factory);
						upload.setSizeMax(yourMaxRequestSize);
						

						List<FileItem> items = null;
						try {
							items = upload.parseRequest(req);
							
						} catch (FileUploadException e) {	
							e.printStackTrace();
						}
						Iterator<FileItem> it = items.iterator();
						while(it.hasNext()){
							FileItem item = it.next();
							
							if(item.isFormField()){	
								if(item.getFieldName().equals("price")){
									price = Integer.parseInt((item.getString("utf-8")));	// id占쏙옙 占쌨울옙占쏙옙
								}
								else if(item.getFieldName().equals("pCount")){
									pCount = Integer.parseInt(item.getString("utf-8"));	// title占쏙옙 占쌨울옙占쏙옙
								}
								else if(item.getFieldName().equals("pCode")) {
									pCode = item.getString("utf-8");
								}
								else if(item.getFieldName().equals("title")){
									pName = item.getString("utf-8");	// content占쏙옙 占쌨울옙占쏙옙
								}
								else if(item.getFieldName().equals("pSize")) {
									pSize = item.getString("utf-8");
								}
								else if(item.getFieldName().equals("content")) {
									content = item.getString("utf-8");
								}
								else if(item.getFieldName().equals("seq")) {
									seq = Integer.parseInt((item.getString("utf-8")));
								}
							}
							else{	
								if(item.getFieldName().equals("fileload1")){
							
										
										filename.add(processUploadFile(item, fupload));
	
								}
								else if(item.getFieldName().equals("fileload2")) {
						
										filename.add(processUploadFile(item, fupload));
									
								}
								else if(item.getFieldName().equals("fileload3")) {
						
										filename.add(processUploadFile(item, fupload));
									
								}
								else if(item.getFieldName().equals("fileload4")) {
						
										filename.add(processUploadFile(item, fupload));
									
								}
									
								
							}
						}
					
				}
				else{
					System.out.println("multipart 占싣댐옙");
				}
				
				System.out.println("filename Update:"+filename.toString());
				String finFileName = "";
				for (int i = 0; i < filename.size(); i++) {
					if(filename.get(i).toString().equals("") || filename.get(i) == null) {
						System.out.println("Update if �뿬湲� �뱾�뼱�솕�뒿�땲�떎.");
						finFileName += " ,";
					}
					else {
						System.out.println("Update else �뿬湲� �뱾�뼱�솕�뒿�땲�떎.");
						finFileName += filename.get(i).toString()+",";
					}
				}
				String str = storeDao.findImg(seq);
				String fFileName = "";
				String fileName_[] = finFileName.split(",");
				String str_[] = str.split(",");
				System.out.println("fileName_:"+fileName_[0]+","+fileName_[1]+","+fileName_[2]+","+fileName_[3]+",");
				System.out.println("str_:"+str_[0]+","+str_[1]+","+str_[2]+","+str_[3]+",");
				for (int i = 0; i < str_.length; i++) {
					if(fileName_[i].equals(" ") || fileName_[i] == null) {
						System.out.println(i+"踰덉㎏ if �뱾�뼱�샂");
						fFileName += str_[i]+",";
					}
					else {
						System.out.println(i+"踰덉㎏ else �뱾�뼱�샂");
						fFileName += fileName_[i]+",";
					}
				}
				System.out.println("fFileName:"+fFileName);
				StoreDto storeDto = new StoreDto(seq, pCode, pName, pCount, price, content, fFileName, pSize);
				storeDao.updateProduct(storeDto);
				resp.sendRedirect("./store/Store_List.jsp");

		
			}
	
	}
	
	public String processUploadFile(FileItem fileItem,String dir) throws IOException{
		
		String filename = fileItem.getName();	// 占쏙옙占� + 占쏙옙占싹몌옙占쏙옙 占쏙옙占쏙옙 占싼억옙占�
		long sizeInBytes = fileItem.getSize();	// 占쏙옙占쏙옙占쏙옙 크占쏙옙
		
		
		
		if(sizeInBytes > 0){	//占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占싹띰옙  ex) d:\\tmp\\abc.txt or d:/tmp/abc.txt
			int idx = filename.lastIndexOf("\\");	//占쌘울옙占쏙옙占쏙옙占쏙옙 \\占쏙옙 占쌍댐옙 index占싼뱄옙占쏙옙 占쏙옙占쏙옙
			if(idx == -1){	// "\\"占쏙옙 占쏙옙찾占쏙옙占쏙옙占쏙옙占� -1占쏙옙 占쏙옙占쏙옙
				idx = filename.lastIndexOf("/");
			}

			filename = filename.substring(idx+1);	// idx占쏙옙占쏙옙 \\or/占쏙옙 占싸듸옙占쏙옙占쏙옙 찾占쏙옙占쏙옙占쏙옙 占쌓곤옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙尻占�
			File uploadFile = new File(dir,filename);	// 占식띰옙占쏙옙叩占쏙옙占쏙옙占� 占쏙옙占�(dir)占쏙옙 占쏙옙占쏙옙占싱몌옙(filename)占쏙옙 占쏙옙占쏙옙娩占�
			try{
				fileItem.write(uploadFile);	//占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占싸듸옙 占싹댐옙 占싸븝옙
			}catch(Exception e){}
			
		}
		
		return filename;	//占쏙옙占쏙옙 占싱몌옙 확占싸울옙
	}
	
}
