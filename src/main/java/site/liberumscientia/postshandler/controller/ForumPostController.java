package site.liberumscientia.postshandler.controller;
import org.springframework.web.bind.annotation.RestController;
import site.liberumscientia.postshandler.service.ForumPostService;

import site.liberumscientia.postshandler.dto.ForumPostRequest;
import site.liberumscientia.postshandler.model.ForumPost;
import site.liberumscientia.postshandler.model.User;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/forum")
public class ForumPostController {

    @Autowired
    private ForumPostService forumPostService;

    @PostMapping("/create")
    public ResponseEntity<ForumPost> createPost(
        @RequestBody ForumPostRequest request, 
        @AuthenticationPrincipal UserDetails userDetails // Extraindo o usuário autenticado
    ) {
        ForumPost post = forumPostService.createPost(request.getTitle(), request.getContent(), (User) userDetails);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/posts")
    public Page<ForumPost> getAllPosts(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        return forumPostService.getAllPosts(page, size);
    }
}


