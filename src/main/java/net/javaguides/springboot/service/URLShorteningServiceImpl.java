package net.javaguides.springboot.service;

import net.javaguides.springboot.model.URL;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserURLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;

@Service
public class URLShorteningServiceImpl implements URLShorteningService {

    @Autowired
    private UserURLRepository userURLRepository;

    @Override
    public URL shortenURL(User user, String originalURL) {
        System.out.println("Hello Buddy");
        String uniqueID = UUID.randomUUID().toString().substring(0, 6);
        String shortenedURL = "http://your-domain.com/" + uniqueID;
        URL url = new URL();
        url.setUser(user);
        url.setOriginalURL(originalURL);
        url.setShortenedURL(shortenedURL);

        URL savedUrl = userURLRepository.save(url);

        return savedUrl;
    }

    @Override
    public List<URL> getUserURLs(User user) {
        return userURLRepository.findByUser(user);
    }

}
