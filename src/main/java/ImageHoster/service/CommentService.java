package ImageHoster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepo;
	
	//Calls the addNewComment method in the repository to persist data for the newly added comment
	public void addComment(Comment newComment) {
		commentRepo.addNewComment(newComment);
	}
	
	//Calls the getCommentsForImage method in the repository to access all comments for a given image
	public List<Comment> getCommentsForImage(Image image){
		return commentRepo.getCommentsForImage(image);
	}
}
