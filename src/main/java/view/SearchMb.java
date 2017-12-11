package view;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import controller.UserController;
import model.User;

@Named
@SessionScoped
public class SearchMb{
	
	@Inject
	private UserController userCntr;
	
	private String userName;
	 
	public String getUserName() {
		return userName;
	}
 
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	private String displayResult;
	
	public void setDisplayResult(String displayResult) {
		this.displayResult = displayResult;
	}

	public String getDisplayResult() {
		return displayResult;
	}
 
	private User user;
 
	public User getUser() {
		return user;
	}
 
	public void setUser(User user) {
		this.user = user;
	}
 
	public String searchUser() {
		userCntr.findByName(userName);
		return null;
	}
}

