package net.javaguides.springboot.service;

import net.javaguides.springboot.model.URL;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserURLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

@Service
public class URLShorteningServiceImpl implements URLShorteningService {

    @Autowired
    private UserURLRepository userURLRepository;

    @Override
    public URL shortenURL(User user, String originalURL) {
        String uniqueID = UUID.randomUUID().toString().substring(0, 6);
        String shortenedURL = "http://localhost:9191/" + uniqueID;
        URL url = new URL();
        url.setUser(user);
        url.setOriginalURL(originalURL);
        url.setShortenedURL(shortenedURL);
        URL savedUrl = userURLRepository.save(url);

        return savedUrl;
    }
    public String deleteContact(Long id){
        Optional<URL> urlOptional = this.userURLRepository.findById(id);
        URL url = urlOptional.get();
        url.getUser();
        this.userURLRepository.delete(url);


        return "Done";
    }
    @Override
    public String updateCount(Long id) {
        Optional<URL> urlOptional = this.userURLRepository.findById(id);
        URL url = urlOptional.get();
        url.setClickCount(url.getClickCount()+1);
        this.userURLRepository.save(url);
        return url.getOriginalURL();
    }


    @Override
    public List<URL> getUserURLs(User user) {
        return userURLRepository.findByUser(user);
    }



}
