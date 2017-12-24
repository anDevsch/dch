package com.dch.servlet;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import com.google.zxing.BinaryBitmap;  
import com.google.zxing.LuminanceSource;  
import com.google.zxing.MultiFormatReader;  
import com.google.zxing.Result;  
import com.google.zxing.NotFoundException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;  
import com.google.zxing.common.HybridBinarizer;  



import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sch.gethtml.getpage;
import com.sch.getstring.getString;

public class Share extends ActionSupport{

	/**
	 * 
	 */	private static final long serialVersionUID = -4768319304515689077L; 
	 private final static String UPLOADDIR = "/upload";   
     //上传文件集合   
     private List<File> file;   
     //上传文件名集合   
     private List<String> fileFileName;   
     //上传文件内容类型集合   
     private List<String> fileContentType;   
     public List<File> getFile() {   
         return file;   
     }   

     public void setFile(List<File> file) {   
         this.file = file;   
     }   

    public List<String> getFileFileName() {   
        return fileFileName;   
    }   

     public void setFileFileName(List<String> fileFileName) {   
         this.fileFileName = fileFileName;   
     }   

     public List<String> getFileContentType() {   
         return fileContentType;   
     }   

     public void setFileContentType(List<String> fileContentType) {   
         this.fileContentType = fileContentType;   
     }

     public String execute() throws Exception{
    	 String jsons=null;
		//Map request = (Map) ActionContext.getContext().get("request");
		try{
		/*//图片上传。。。
		String dir = ServletActionContext.getRequest().getRealPath(UPLOADDIR);
        InputStream in = new FileInputStream(file.get(0));  
        File fileLocation = new File(dir);  
        //此处也可以在应用根目录手动建立目标上传目录  
        if(!fileLocation.exists()){  
            boolean isCreated  = fileLocation.mkdir();  
            if(!isCreated) { 
                //目标上传目录创建失败,可做其他处理,例如抛出自定义异常等,一般应该不会出现这种情况。  
                return "question";  
            }  
        }  
        String fileName=this.getFileFileName().get(0);  
        File uploadFile = new File(dir, fileName);
        String uppath=uploadFile.getPath();
        System.out.println(uppath);
        OutputStream out = new FileOutputStream(uploadFile);   
        byte[] buffer = new byte[1024 * 1024];   
        int length;   
        while ((length = in.read(buffer)) > 0) {   
            out.write(buffer, 0, length);   
        }   
        in.close();   
        out.close();   
        */
        
        String ma=decode(file.get(0).getPath());
        if(ma==null)
        {
        	jsons="{state:\"error\",reason:\"识别二维码错误\",data:[{png:'',title:''}]}";
        }
        int mal = ma.length();
        if(mal!=13&&mal!=10)
        {
        	jsons="{state:\"error\",reason:\"解析二维码错误\",data:[{png:'',title:''}]}";
        	System.out.println("error----->"+ma);
        }
        else
        {
        	System.out.println("ma----->"+ma);
        	String url = "https://s.taobao.com/search?q="+ma+"&js=1&stats_click=search_radio_all%3A1&initiative_id=staobaoz_20170307&ie=utf8";
            String regex;
            String result = getpage.getpage(url);
            //System.out.println(result);
            
            if(!getString.regexString(result, "\"noResultCode\":0(.+?)\"").equals(""))
            {
            	//System.out.println("155"+getString.regexString(result, "\"noResultCode\":0(.+?)\"")+"1");
            	jsons="{state:\"error\",reason:\"没有找到二维码对应相关书籍\",data:[{png:'',title:''}]}";
            }
            else{//System.out.println("155"+getString.regexString(result, "\"noResultCode\":0(.+?)\"")+";;");
            	jsons="{state:\"success\",reason:\"\",data:[";
            	//System.out.println("success----->"+ma);
            	
	            regex = "\"nid\":\"(.+?)\"";
	            String src = getString.regexString(result, regex);
	            System.out.println("id----->"+src);
	            url="https://detail.tmall.com/item.htm?id="+src+"&cm_id=140105335569ed55e27b&abbucket=3";
	            result = getpage.getpage(url);
	            //System.out.println(result);
	            jsons+=getbookjson(result);
		    	
	    		
	    		jsons+="]}";
            }
    		
        }
        
        
     
    } catch (java.lang.NullPointerException ex) {   
        System.out.println("上传失败!");  
        ex.printStackTrace();   
    }
		
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		//response.setContentType("application/json");
		ServletActionContext.getRequest().getSession().setAttribute("upbook", jsons);
		response.getWriter().write(jsons);
		
		
		
		
		return null;
	}
     private String getbookjson(String result) {  
    	 String regex,src,jsons="";
    	 try {
	    	 regex = "J_ImgBooth.+?src=\"//(.+?)\"";
	         //regex = new String(regex.getBytes("gbk"), "UTF-8"); 
	         src = getString.regexString(result, regex);
	 		jsons+="{png:\""+src+"\"";
	     	//request.put("books", ma);request.put("src", src);
	 		regex = "书名:&nbsp;(.+?)</li>";
	 		regex = new String(regex.getBytes("gbk"), "UTF-8");
	         src = getString.regexString(result, regex);
	         jsons+=",title:\""+src+"\"";
	     	regex = "出版社名称:&nbsp;.+?作者:&nbsp;(.+?)</li>";
	     	regex = new String(regex.getBytes("gbk"), "UTF-8");
	 		src = getString.regexString(result, regex);
	 		jsons+=",author:\""+src+"\"";//System.out.println(src);
	 		regex = "书名:&nbsp;.+?&nbsp;.+?&nbsp;(.+?)&#20803;</li>";
	 		regex = new String(regex.getBytes("gbk"), "UTF-8");
	 		src = getString.regexString(result, regex);
	 		jsons+=",priace:\""+src+"\"";
	 		regex = "出版社名称:&nbsp;(.+?)</li>";
	 		regex = new String(regex.getBytes("gbk"), "UTF-8");
	 		src = getString.regexString(result, regex);
	 		jsons+=",publicc:\""+src+"\"";
	 		regex = "出版时间:&nbsp;(.+?)</li>";
	 		regex = new String(regex.getBytes("gbk"), "UTF-8");
	 		src = getString.regexString(result, regex);
	 		jsons+=",publictime:\""+src+"\"";
	 		regex = "ISBN编号:&nbsp;(.+?)</li>";
			regex = new String(regex.getBytes("gbk"), "UTF-8");
			src = getString.regexString(result, regex);
	 		jsons+=",ISBN:\""+src+"\"}";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		return jsons;
     }
	private String decode(String imgPath) {  
        BufferedImage image = null;  
        Result result = null;  
        try {  
            
			image = ImageIO.read(new File(imgPath));
			  
            if (image == null) {  
                System.out.println("the decode image may be not exit.");  
            }  
            LuminanceSource source = new BufferedImageLuminanceSource(image);  
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));  
  
           
				result = new MultiFormatReader().decode(bitmap, null);
				return result.toString();
			   
        }catch (IOException e) { 
        	//e.printStackTrace();
        	return null; 
	    } catch (NotFoundException e) {
			// TODO Auto-generated catch block
			return null; 
		}catch(IllegalArgumentException e){
			return null; 
		}
        
    }  
}
