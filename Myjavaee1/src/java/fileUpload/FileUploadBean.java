
package fileUpload;

import Mycontroller1.util.JsfUtil;
import Myentitybean1.Headpicture;
import Myfacade1.HeadpictureFacade;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.ejb.EJB;
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

    @EJB
    HeadpictureFacade picfa;
    Headpicture headpic;
    private HttpSession session;
    String userName;
    String filepath =  "F:\\github\\Myjavaee\\Myjavaee1\\web\\resources";
    String readpath="resources";
    String fileType="";
    String dir;
    private Part uploadedFile;
    
   
    public String getReadPath()
    {
        readpath="resources//"+this.getLoginUserName()+fileType;
        return readpath;
    }
    public String getdirroot()
    {
        return dir=filepath+"\\"+this.getLoginUserName()+fileType;
    }
    public FileUploadBean() {
    }
   

    public Part getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
    public String getLoginUserName()
    {
        return userName=getSession().getAttribute("name").toString();
    }
    public void setFiletype(String filename)
    {
        if(filename.lastIndexOf(".")==-1)
             JsfUtil.addSuccessMessage("文件格式错误");
        else
            fileType = filename.substring(filename.lastIndexOf("."));
    }
    public String getFileText() throws FileNotFoundException {
        if (null != uploadedFile) {
            try {
                try (InputStream is = uploadedFile.getInputStream()) {
                    this.setFiletype(uploadedFile.getSubmittedFileName());
                    if(".jpeg".equals(fileType)||".jpg".equals(fileType)||".gif".equals(fileType))
                    {     
                        JsfUtil.addSuccessMessage("文件格式正确");
                    }
                    else
                    {
                        JsfUtil.addSuccessMessage("文件格式错误");
                        return "index";
                    }           
                    OutputStream outputStream = new FileOutputStream(this.getdirroot());
                    byte[] b = new byte[1024];
                    int len;
                    while ((len = is.read(b)) != -1) {
                        outputStream.write(b, 0, len);
                    }       
                    outputStream.close();
                    is.close();
                }
          File ttt=new File(dir);
        if (ttt.isFile()) {
            if(headpic==null)
                headpic=new Headpicture();
            headpic.setName(this.getSession().getAttribute("name").toString());
            headpic.setRoot(this.getReadPath());
            this.picfa.edit(headpic);
            
            JsfUtil.addSuccessMessage( "上传成功"+ this.getdirroot());
        }  
            } catch (IOException ex) {
                
            }
        }
       
        
        
        return "headpicture";
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
