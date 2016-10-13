package com.tapthis.service;

import java.util.List;

import com.tapthis.entity.ReviewInfo;

public interface ReviewService {
	
	List<ReviewInfo> getReviewByBeerName(String beerName, String breweryName);
	List<ReviewInfo> getAllReviewsByUserId(int reviewUserID);
	List<ReviewInfo> getOneReviewByUserId(int reviewUserId, int reviewId);
	ReviewInfo getReviewById(int reviewId);
	boolean addReview(ReviewInfo reviewId);
	void updateReview(ReviewInfo reviewId);
	void deleteReview(int reviewId);
}
