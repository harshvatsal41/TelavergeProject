package net.javaguides.springboot.web;

import net.javaguides.springboot.model.URL;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.service.URLShorteningService;
import net.javaguides.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private UserService userService;

    @Autowired
    private URLShorteningService urlShorteningService;

    @GetMapping
    public String showDashboard(Model model) {
        User user = userService.getCurrentUser();
        List<URL> userURLs = urlShorteningService.getUserURLs(user);
        model.addAttribute("userURLs", userURLs);
        return "dashboard";
    }

    @PostMapping("/shorten")
    public String shortenURL(@RequestParam("originalURL") String originalURL, Model model) {
        User user = userService.getCurrentUser();
        urlShorteningService.shortenURL(user, originalURL);
        return "redirect:/dashboard";
    }

    // Other methods as needed
}

