package Filter.demo.service.impl;

import Filter.demo.model.Review;
import Filter.demo.service.ReviewService;
import org.springframework.stereotype.Service;
import Filter.demo.repository.ReviewRepository;

import java.util.Comparator;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> sortByRating(List<Review> reviews, boolean byHighest) {
        return reviewRepository.sortByRating(reviews, byHighest);
    }

    @Override
    public List<Review> sortByDate(List<Review> reviews, boolean byHighest) {
        return reviewRepository.sortByDate(reviews, byHighest);
    }

    @Override
    public List<Review> sortByPrioritizedText(List<Review> reviews) {
        return reviewRepository.sortByPrioritizedText(reviews);
    }

    @Override
    public List<Review> filterByMinRating(List<Review> reviews, int minRating) {
        return reviewRepository.filterByMinRating(reviews,minRating);
    }

    @Override
    public Comparator<Review> sortByRatingWithComparator(boolean byHighest) {
        return reviewRepository.sortByRatingWithComparator(byHighest);
    }

    @Override
    public Comparator<Review> sortByDateWithComparator(boolean byHighest) {
        return reviewRepository.sortByDateWithComparator(byHighest);
    }

    @Override
    public Comparator<Review> sortByPrioritizedTextWithComparator() {
        return reviewRepository.sortByPrioritizedTextWithComparator();
    }



}
