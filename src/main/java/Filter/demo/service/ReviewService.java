package Filter.demo.service;

import Filter.demo.model.Review;

import java.util.List;

public interface ReviewService {
    public List<Review> findAll();

    public List<Review> sortByRating(List<Review> reviews, boolean byHighest);

    public List<Review> sortByDate(List<Review> reviews, boolean byHighest);

    public List<Review> sortByPrioritizedText(List<Review> reviews);

    public List<Review> filterByMinRating(List<Review> reviews, int minRating);

}
