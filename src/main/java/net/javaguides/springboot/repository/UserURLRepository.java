package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.URL;
import net.javaguides.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserURLRepository extends JpaRepository<URL , Long> {
    List<URL> findByUser(User user);
    URL findByShortenedURL(String shortenedUrl);
}
