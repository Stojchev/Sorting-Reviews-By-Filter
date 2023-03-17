package Filter.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Review {
    public Review() {
    }

    public String getReviewCreatedOnDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        return dateFormat.format(reviewCreatedOnDate);
    }

    public Review(int id,
                  String reviewId,
                  String reviewFullText,
                  String reviewText,
                  int numLikes,
                  int numComments,
                  int numShares,
                  int rating,
                  String reviewCreatedOn,
                  Date reviewCreatedOnDate,
                  int reviewCreatedOnTime,
                  String reviewerId,
                  Object reviewerUrl,
                  String reviewerName,
                  Object reviewerEmail,
                  String sourceType,
                  boolean isVerified,
                  String source,
                  String sourceName,
                  String sourceId,
                  ArrayList<Object> tags,
                  Object href,
                  Object logoHref,
                  ArrayList<Object> photos) {
        this.id = id;
        this.reviewId = reviewId;
        this.reviewFullText = reviewFullText;
        this.reviewText = reviewText;
        this.numLikes = numLikes;
        this.numComments = numComments;
        this.numShares = numShares;
        this.rating = rating;
        this.reviewCreatedOn = reviewCreatedOn;
        this.reviewCreatedOnDate = reviewCreatedOnDate;
        this.reviewCreatedOnTime = reviewCreatedOnTime;
        this.reviewerId = reviewerId;
        this.reviewerUrl = reviewerUrl;
        this.reviewerName = reviewerName;
        this.reviewerEmail = reviewerEmail;
        this.sourceType = sourceType;
        this.isVerified = isVerified;
        this.source = source;
        this.sourceName = sourceName;
        this.sourceId = sourceId;
        this.tags = tags;
        this.href = href;
        this.logoHref = logoHref;
        this.photos = photos;
    }

    private int id;
    private String reviewId;
    private String reviewFullText;
    private String reviewText;
    private int numLikes;
    private int numComments;
    private int numShares;
    private int rating;
    private String reviewCreatedOn;
    private Date reviewCreatedOnDate;
    private int reviewCreatedOnTime;
    private String reviewerId;
    private Object reviewerUrl;
    private String reviewerName;
    private Object reviewerEmail;
    private String sourceType;
    private boolean isVerified;
    private String source;
    private String sourceName;
    private String sourceId;
    private ArrayList<Object> tags;
    private Object href;
    private Object logoHref;
    private ArrayList<Object> photos;
}
