package view;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import auth.AuthMb;
import controller.CommentController;
import model.Comment;
import model.Post;
import model.User;

@Named
public class CommentMb {

	@Inject
	private CommentController commentCntrl;
	
	@Inject
	private AuthMb authMb;
	
	@NotNull
	@Size(min=2,max=255)
	private String comment;
	
	public void create(Post post){
		User user = authMb.getUser();
		commentCntrl.create(user, post, comment);
	}
	
	public List<Comment> getMyCommentList(){
		try{
			return commentCntrl.from(authMb.getUser(), 0, 10);
		} catch (Exception e){
			e.printStackTrace();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error del metodo getMyPostList", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}
	}

	public List<Comment> listByPost(Post post){
		return commentCntrl.byPost(post);
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
