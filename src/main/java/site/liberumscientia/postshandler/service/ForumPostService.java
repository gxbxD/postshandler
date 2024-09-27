package site.liberumscientia.postshandler.service;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import site.liberumscientia.postshandler.model.ForumPost;
import site.liberumscientia.postshandler.repository.ForumPostRepository;


@Service
public class ForumPostService {

    @Autowired
    private ForumPostRepository forumPostRepository;

    public ForumPost createPost(String title, String content, User user) {
        ForumPost post = new ForumPost();
        post.setTitle(title);
        post.setContent(content);
        post.setUser(user);
        post.setCreatedAt(LocalDateTime.now());
        return forumPostRepository.save(post);
    }

    public Page<ForumPost> getAllPosts(int page, int size) {
        return forumPostRepository.findAll(PageRequest.of(page, size));
    }

    public List<ForumPost> getPostsByUser(User user) {
        return ForumPostRepository.findByUser(user);
    }
}

