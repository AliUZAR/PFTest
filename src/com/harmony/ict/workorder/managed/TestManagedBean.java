package com.harmony.ict.workorder.managed;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean ( name = "testManagedBean" )
@ViewScoped
public class TestManagedBean implements Serializable
{
	private static final long serialVersionUID = 4426815554605967048L;
	
	public TestManagedBean() // find current user
	{
	}
	
    private UploadedFile file;
    
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
     
    public void upload() {
        if(file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        else
        {
        	FacesMessage message = new FacesMessage("No file Selected");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        
        FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = ( HttpServletRequest ) context.getExternalContext().getRequest ();

		FacesMessage message = new FacesMessage(request.getHeader("User-Agent"));
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
	public void handleFileUpload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);        
    }
	    
}
