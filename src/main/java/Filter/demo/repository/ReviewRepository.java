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

    public List<Review> sortByRating(List<Review> reviews, boolean byHighest) {
        if (byHighest) {
            return reviews.stream().sorted(Comparator.comparing(Review::getRating, Comparator.reverseOrder())).collect(Collectors.toList());
        } else {
            return reviews.stream().sorted(Comparator.comparing(Review::getRating)).collect(Collectors.toList());
        }
    }

    public List<Review> sortByDate(List<Review> reviews, boolean byHighest) {
        if (byHighest) {
            return reviews.stream().sorted(Comparator.comparing(Review::getReviewCreatedOnDate, Comparator.reverseOrder())).collect(Collectors.toList());
        } else
            return reviews.stream().sorted(Comparator.comparing(Review::getReviewCreatedOnDate)).collect(Collectors.toList());
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
}
