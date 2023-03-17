package Filter.demo.repository;

import Filter.demo.data.DataHolder;
import Filter.demo.model.Review;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ReviewRepository {
    public List<Review> findAll() {
        return DataHolder.reviews;
    }
    //First solution working with the list directly
    public List<Review> sortByRating(List<Review> reviews, boolean byHighest) {
        if (byHighest) {
            return reviews.stream().sorted(Comparator.comparing(Review::getRating, Comparator.reverseOrder())).collect(Collectors.toList());
        } else {
            return reviews.stream().sorted(Comparator.comparing(Review::getRating)).collect(Collectors.toList());
        }
    }
    public List<Review> sortByDate(List<Review> reviews, boolean byHighest) {
        Comparator<Review> comparator = Comparator.comparing(Review::getReviewCreatedOnDate);
        if (byHighest) {
            comparator = comparator.reversed();
        }
        return reviews.stream().sorted(comparator).collect(Collectors.toList());
    }
    public List<Review> sortByPrioritizedText(List<Review> reviews) {
        //Here I am going with the implementation of a comparator to compare empty strings only
        //For example "asd" and "pst" here are equal
        //where "asd" && "" are not equal, so it is sorting by empty text only
        //If I want to compare it by String I will go with this implementation
        //return reviews.stream().sorted(Comparator.comparing(Review::getReviewFullText)).collect(Collectors.toList());
        Comparator<Review> comparator = (o1, o2) -> {
            if (o1.getReviewText().isEmpty() && !o2.getReviewText().isEmpty())
                return 1;
            if (o2.getReviewText().isEmpty() && !o1.getReviewText().isEmpty())
                return -1;
            else return 0;
        };
        return reviews.stream().sorted(comparator).collect(Collectors.toList());
    }
    public List<Review> filterByMinRating(List<Review> reviews, int minRating) {
        return reviews.stream().filter(review -> review.getRating() >= minRating).collect(Collectors.toList());
    }

    //Second solution is where we just create comparators in functions and work with comparator rather than the list
    //This is more optimal solution
    public Comparator<Review> sortByPrioritizedTextWithComparator() {
        //Same implementation explained in the sortByPrioritizedText() function
        return (o1, o2) -> {
            if (o1.getReviewText().isEmpty() && !o2.getReviewText().isEmpty())
                return 1;
            if (o2.getReviewText().isEmpty() && !o1.getReviewText().isEmpty())
                return -1;
            else return 0;
        };
    }
    public Comparator<Review> sortByDateWithComparator(boolean byHighest) {
        Comparator<Review> comparator = Comparator.comparing(Review::getReviewCreatedOnDate);
        return byHighest ? comparator.reversed() : comparator;
    }
    public Comparator<Review> sortByRatingWithComparator(boolean byHighest) {
        Comparator<Review> comparator = Comparator.comparing(Review::getRating);
        return byHighest ? comparator.reversed() : comparator;
    }
}
