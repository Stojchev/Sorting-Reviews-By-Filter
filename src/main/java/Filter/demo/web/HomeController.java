package Filter.demo.web;

import Filter.demo.model.Review;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import Filter.demo.service.ReviewService;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class HomeController {
    private final ReviewService reviewService;

    public HomeController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public String getReviews(Model model) {
        model.addAttribute("reviews", reviewService.findAll());
        return "home";
    }

    @GetMapping("/filter")
    public String getFilterPage() {
        return "filter";
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public String getReviews(@RequestParam boolean orderByRating,
                             @RequestParam String minRating,
                             @RequestParam boolean orderByDate,
                             @RequestParam boolean prioritizeText,
                             Model model) {
        List<Review> tmp = reviewService.findAll();
        tmp = reviewService.sortByDate(tmp, orderByDate);
        tmp = reviewService.sortByRating(tmp, orderByRating);
        if (prioritizeText)
            tmp = reviewService.sortByPrioritizedText(tmp);
        tmp = reviewService.filterByMinRating(tmp, Integer.parseInt(minRating));
        model.addAttribute("reviewsSorted", tmp);
        return "home";
    }
}
