package view;

import javax.inject.Inject;
import javax.inject.Named;

import auth.AuthMb;
import controller.LikeController;
import model.Post;
import model.User;

@Named
public class LikeMb {

	@Inject
	private LikeController likeCntrl;
	
	@Inject
	private AuthMb authMb;
	
	private String like;
	
	public void create(Post post){
		User user = authMb.getUser();
		likeCntrl.create(user, post, like);
	}
}
