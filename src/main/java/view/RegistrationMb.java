package view;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.Part;
import javax.transaction.UserTransaction;
import javax.validation.constraints.NotNull;

import auth.AuthMb;
import controller.ImageController;
import controller.UserController;
import model.Image;
import model.User;

@Named
public class RegistrationMb {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Inject
	private AuthMb authMb;
	
	@Inject
	private UserController userCntr;
	
	@Inject 
	private ImageController imgCntl;
	
	private Part file;
	
	private User user = new User();
	
	@NotNull
	private String confirmPass;
	
	private String newPwd;
	
	public String register(){
		try {
			if(!confirmPass.equals(user.getPassword())){
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contraseñas no coniciden", null);
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return null;
			}
			Image img = null;
			if(file != null && file.getSize() > 0 && file.getContentType().startsWith("image/")){
				img = imgCntl.upload(file);
			}
			user.setUserpic(img);
			userCntr.create(user);
			user = null;
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registró el usuario", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "login?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error interno", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}
	}
	
	public User updatePassword(){
		try {
			if(!confirmPass.equals(newPwd)){
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contraseñas no coniciden", null);
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return null;
			}
			UserTransaction transaction = (UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");
			transaction.begin();
			User user= entityManager.find(User.class ,authMb.getUser().getId());
			user.setPassword(getNewPwd());
			transaction.commit();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Su contrasena ha sido cambiado", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error interno", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}
		
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getConfirmPass() {
		return confirmPass;
	}

	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}
	
	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}
	
	public String getNewPwd(){
        return newPwd;
    }

    public void setNewPwd(String newPwd){
        this.newPwd = newPwd;
    }
	
}
