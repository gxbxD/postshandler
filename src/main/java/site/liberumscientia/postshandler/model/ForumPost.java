package site.liberumscientia.postshandler.model;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ForumPost {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;  // Título da postagem
    private String content;  // Conteúdo da postagem

    @ManyToOne
    private User user;  // Relacionamento com o usuário que criou a postagem

    private LocalDateTime createdAt;  // Data e hora da criação

    // Getters and Setters

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        id = this.id;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        title = this.title;
    }

    public String getContent () {
        return content;
    }

    public void setContent (String content) {
        content = this.content;
    }

    public String getUser () {
        return user;
    }

    public void setUser (String user) {
        user = this.user;
    }

    public DateTime getCreatedAt () {
        return createdAt;
    }

    public void setCreatedAt (DateTime createdAt) {
        createdAt = this.createdAt;
    }
}