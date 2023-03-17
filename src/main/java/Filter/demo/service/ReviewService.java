package Filter.demo.service;

import Filter.demo.model.Review;

import java.util.Comparator;
import java.util.List;

public interface ReviewService {
    public List<Review> findAll();

    public List<Review> sortByRating(List<Review> reviews, boolean byHighest);

    public List<Review> sortByDate(List<Review> reviews, boolean byHighest);

    public List<Review> sortByPrioritizedText(List<Review> reviews);

    public List<Review> filterByMinRating(List<Review> reviews, int minRating);

    public Comparator<Review> sortByRatingWithComparator(boolean byHighest);

    public Comparator<Review> sortByDateWithComparator(boolean byHighest);

    public Comparator<Review> sortByPrioritizedTextWithComparator();


}
