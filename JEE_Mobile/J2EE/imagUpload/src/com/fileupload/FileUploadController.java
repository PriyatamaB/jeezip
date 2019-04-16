package com.fileupload;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.eclipse.jdt.internal.compiler.flow.LoopingFlowContext;
import org.hibernate.Hibernate;
import org.hibernate.LobHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.pojos.Dept;
import com.pojos.Emp;
import com.service.FileService;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

@Controller
public class FileUploadController {
	@Autowired
	FileService service;

	
	 @RequestMapping(value = "/upload", method = RequestMethod.GET)
	    public String showUpload(Model model)
	    {
		 List<Dept> dlist=service.getDeptList();
		    model.addAttribute("deptList",dlist);
		    model.addAttribute("emp",new Emp());
	        return "profile";
	    }
	     
	    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
	    public String handleFileUpload(@ModelAttribute("emp") Emp e, HttpServletRequest request,
	            @RequestParam MultipartFile fileUpload) throws Exception {
	    	    System.out.println("here..."+e);
	        if (fileUpload != null) {
	        	
	        	//Blob blob = new SerialBlob(fileUpload.getBytes());
	                System.out.println("Saving file: " + fileUpload.getOriginalFilename());
	                
	                e.setFile_upload(fileUpload.getBytes());
	                service.upload(e);               
	           
	        }
	  
	        return "Home";
	    } 
	    
	    @RequestMapping(value = "/download", method = RequestMethod.GET)
	    public String showDownload(Model model)
	    {
	    	Emp e= new Emp();
	        model.addAttribute("emp",e);
	        return "showProfile";
	    }
	    @RequestMapping(value = "/download", method = RequestMethod.POST)
	    public String showDownload_AfterPost(Model model,@ModelAttribute("emp") Emp id)
	    {
	    		Emp e= service.findEmp(id.getName());
				byte[] imgContent=e.getFile_upload();
				
				
				
				String url="data:image/jpeg;base64,"+Base64.encode(imgContent);
			
				
				
				model.addAttribute("url",url);
				model.addAttribute("emp",e);
			
	        return "showProfile";
	    }
	    
	    /*public String showDownload_AfterPost(Model model,@ModelAttribute("emp") Emp id)
	    {
	    	Emp e= service.findEmp(id.getName());
	    	byte[] imgContent=e.getFile_upload();
	    	String url="data:image/jpeg;base64,"+Base64.encode(imgContent);
	    	
            model.addAttribute("url",url);
		    model.addAttribute("emp",e);
	        return "showProfile";
	    }*/
	
	    
	 
	
}
