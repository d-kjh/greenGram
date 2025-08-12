package com.green.greengram.application.feedcomment;

import com.green.greengram.application.feedcomment.model.FeedCommentPostReq;

import com.green.greengram.entity.Feed;
import com.green.greengram.entity.FeedComment;
import com.green.greengram.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedCommentService {
    private final FeedCommentRepository feedCommentRepository;

    public long postFeedComment(long userId, FeedCommentPostReq req){
        User user = new User();
        user.setUserId(userId);

        Feed feed = Feed.builder()
                .feedId(req.getFeedId())
                .build();

        FeedComment feedComment = FeedComment.builder()
                .user(user)
                .feed(feed)
                .comment(req.getComment())
                .build();

        feedCommentRepository.save(feedComment);
        return feedComment.getFeedCommentId();
    }
}
