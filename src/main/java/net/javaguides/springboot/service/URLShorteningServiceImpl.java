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
        // Generate a unique identifier for the shortened URL
        String uniqueID = UUID.randomUUID().toString().substring(0, 6); // Example: Generate a 6-character unique ID

        // Construct the shortened URL
        String shortenedURL = "http://your-domain.com/" + uniqueID; // Replace "your-domain.com" with your actual domain

        // Create a new UserURL object
        URL url = new URL();
        url.setUser(user);
        url.setOriginalURL(originalURL);
        url.setShortenedURL(shortenedURL);

        // Save the URL in the database
        URL savedUrl = userURLRepository.save(url);

        // Return the saved URL
        return savedUrl;
    }

    @Override
    public List<URL> getUserURLs(User user) {
        return userURLRepository.findByUser(user);
    }

    // Other methods as needed
}
