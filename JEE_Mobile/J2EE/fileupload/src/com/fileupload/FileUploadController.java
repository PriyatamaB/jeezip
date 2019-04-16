package com.fileupload;

import java.io.File;
import java.io.InputStream;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	@RequestMapping("/upload")
	public String uploadFile(FileUpload upload, ModelMap model, HttpSession session) {
		System.out.println("File Uploading ..." + upload);
		MultipartFile file = upload.getFile();
		if(file!=null && file.getSize() > 0) {
			try {
				InputStream in = file.getInputStream();
				//String path = session.getServletContext().getRealPath("/uploads/"+file.getOriginalFilename());
				String path = this.getClass().getResource("/../../uploads/").getPath();
				System.out.println("PATH : " + path);
				if(path==null)
					throw new RuntimeException("getRealPath() failed.");
				else
					path+=file.getOriginalFilename();
				File uploadPath = new File(path);
				if(uploadPath.exists())
					uploadPath.delete();
				if(uploadPath.createNewFile()) {
					FileUtils.copyInputStreamToFile(in, uploadPath);
					model.addAttribute("image", file.getOriginalFilename());
					model.addAttribute("status", "success");
				} else 
					model.addAttribute("status", "no permissions");
			} catch(RuntimeException rtex){
				model.addAttribute("status", rtex.toString());
			} catch(Exception ex){
				model.addAttribute("status", ex.toString());
			}			
			model.addAttribute("info", file);
		} else {
			model.addAttribute("status", "failed");
		}
		return "index";
	}
}
