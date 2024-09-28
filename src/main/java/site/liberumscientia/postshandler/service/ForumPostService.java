package site.liberumscientia.postshandler.service;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import site.liberumscientia.postshandler.model.User; // Certifique-se de que a importação está correta


import site.liberumscientia.postshandler.model.ForumPost;
import site.liberumscientia.postshandler.repository.ForumPostRepository;


@Service
public class ForumPostService<UserRepository> {

    @Autowired
    private ForumPostRepository forumPostRepository;

    User user = ForumPostRepository.findByUser(user);


    public ForumPost createPost(String title, String content, User user) {
        ForumPost post = new ForumPost();
        post.setTitle(title);
        post.setContent(content);
        post.setUser(user);
        post.setCreatedAt(LocalDateTime.now());
        return forumPostRepository.save(post);
    }

    // Método para obter todas as postagens com paginação
    public Page<ForumPost> getAllPosts(Pageable pageable) {
        return forumPostRepository.findAll(pageable);
    }

    // Método para obter postagens por usuário
    public Page<ForumPost> getPostsByUser(User user, Pageable pageable) {
        return forumPostRepository.findByUser(user, pageable); // Usando o método do repositório
    }
}