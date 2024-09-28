package site.liberumscientia.postshandler.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import site.liberumscientia.postshandler.model.ForumPost;
import site.liberumscientia.postshandler.model.User;


public interface ForumPostRepository extends JpaRepository<ForumPost, Long> {
    Page<ForumPost> findAll(Pageable pageable);
    Page<ForumPost> findByUser(User user, Pageable pageable);

}
