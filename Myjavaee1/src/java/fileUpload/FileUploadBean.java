
package fileUpload;

import Mycontroller1.util.JsfUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@Named
@RequestScoped
public class FileUploadBean {

    private HttpSession session;
    String filepath =  "F:\\github\\headpicture";
    String fileType="";
    public FileUploadBean() {
    }
    private Part uploadedFile;

    public Part getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
    
    public String getFileText() throws FileNotFoundException {
       
        if (null != uploadedFile) {
            try {
                InputStream is = uploadedFile.getInputStream();
                 
        File usrFilePath = new File(filepath);
        if(uploadedFile.getSubmittedFileName().lastIndexOf(".")==-1)
           JsfUtil.addSuccessMessage("文件格式错误");
        fileType = uploadedFile.getSubmittedFileName().substring(uploadedFile.getSubmittedFileName().lastIndexOf("."));
        if(".jpeg".equals(fileType)||".jpg".equals(fileType)||".gif".equals(fileType))
        {     JsfUtil.addSuccessMessage("文件格式正确");
        }
        else
        {    JsfUtil.addSuccessMessage("文件格式错误");
        return "index";
        }
        fileType = uploadedFile.getSubmittedFileName().substring(uploadedFile.getSubmittedFileName().lastIndexOf("."));
       
        File dir = new File(filepath+"\\"+this.getSession().getAttribute("name").toString()+fileType);
         
        OutputStream outputStream = null;//输出流写到硬盘
        outputStream = new FileOutputStream(dir);
        
        byte[] b = new byte[1024];
            int len;
            while ((len = is.read(b)) != -1) {
                outputStream.write(b, 0, len);
            }
            outputStream.close();
            is.close();
            // 检查是否写入成功，成功的话给予提示   
        if (dir.isFile()) {
            JsfUtil.addSuccessMessage( "上传成功"+ filepath+"\\"+getSession().getAttribute("name").toString()+fileType);
        }  
            } catch (IOException ex) {
                
            }
        }
       
        
        
        return "index";
    }

    public HttpSession getSession() {
         session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
         if(session.getAttribute("login")==null||(boolean)session.getAttribute("login")==false)
         {
             session.setAttribute("login",false);
             session.setAttribute("name", "null");
             return session;
         }
         return session;
    }
    
}
