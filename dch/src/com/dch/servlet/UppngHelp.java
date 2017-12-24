package com.dch.servlet;

import java.io.File;  
import java.io.IOException;  
import java.util.Date;  
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;  
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
 
public class UppngHelp {
    private static String filen; 
	public static String uploadFile(File file,String path) {
		try {    
			File nfile = new File(path);     
            // 如果指定的路径没有就创建    
               if (!nfile.exists()) {    
                   nfile.mkdirs(); 
               }    
               String oname = file.getName();
               //String m = file.getAbsolutePath();
               //System.out.println(m);
               String filename = new Date().getTime()+".jpg";//oname.substring(oname.lastIndexOf("."), oname.length());
               FileUtils.copyFile(file, new File(nfile, filename));
               filen = filename;
        } catch (IOException e) {    
           e.printStackTrace();    
        }
        return filen;
         
    }  

}
