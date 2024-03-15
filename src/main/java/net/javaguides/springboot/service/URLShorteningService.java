package net.javaguides.springboot.service;

import net.javaguides.springboot.model.URL;
import net.javaguides.springboot.model.User;

import java.util.List;

public interface URLShorteningService {
    public URL shortenURL(User user, String originalURL);
    public List<URL> getUserURLs(User user);
}
