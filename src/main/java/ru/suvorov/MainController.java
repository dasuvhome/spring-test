package ru.suvorov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.suvorov.models.Review;
import ru.suvorov.models.ReviewRepository;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
   private ReviewRepository reviewRepository;

    @GetMapping("/start")
    public String greeting(Map<String, Object> model) {
        model.put("name", "World");
        return "start";
    }

    @GetMapping("/about")
    public String about(Map<String, Object> model) {
        model.put("title", "Страница про нас");
        return "about";
    }

    @GetMapping("/reviews")
    public String reviews(Map<String, Object> model) {
        Iterable<Review> reviews = reviewRepository.findAll();
        model.put("title", "Страница про нас");
        model.put("reviews", reviews);
        return "reviews";
    }

}