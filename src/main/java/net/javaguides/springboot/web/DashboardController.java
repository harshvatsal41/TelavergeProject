package net.javaguides.springboot.web;

import net.javaguides.springboot.model.URL;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserURLRepository;
import net.javaguides.springboot.service.URLShorteningService;
import net.javaguides.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private UserService userService;

    @Autowired
    private URLShorteningService urlShorteningService;

    private UserURLRepository userURLRepository;

    @GetMapping
    public String showDashboard(Model model) {
        User user = userService.getCurrentUser();
        List<URL> userURLs = urlShorteningService.getUserURLs(user);
        model.addAttribute("userURLs", userURLs);
        return "dashboard";
    }



    @PostMapping("/shorten")
    public String shortenURL(@RequestParam("originalURL") String originalURL, Model model) {
        System.out.println("ppp");
        User user = userService.getCurrentUser();
        urlShorteningService.shortenURL(user, originalURL);
        return "redirect:/dashboard";
    }
    @PostMapping("/shortendash")
    public String shortenURLDash(@RequestParam("originalURL") String originalURL, Model model) {
        System.out.println("ppp");
        User user = userService.getCurrentUser();
        URL u = urlShorteningService.shortenURL(user, originalURL);

        model.addAttribute("shortnedUrl",u.getShortenedURL());
        model.addAttribute("orignalUrl",u.getOriginalURL());
        model.addAttribute("count",u.getClickCount());
        return "index";
    }

    @GetMapping("/incrementcount/{uid}")
    public String updateCount(@PathVariable("uid")Long uId,Model model){
        System.out.println(uId);
        String a = urlShorteningService.updateCount(uId);
        return "redirect:/dashboard";
    }

    @GetMapping("/userdelete/{uid}")
    public String deleteUrl(@PathVariable("uid")Long uId,Model model){
        System.out.println(uId);
        urlShorteningService.deleteContact(uId);

        return "redirect:/dashboard";
    }



}

