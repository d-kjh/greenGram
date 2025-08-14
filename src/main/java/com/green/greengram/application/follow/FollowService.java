package com.green.greengram.application.follow;

import com.green.greengram.application.follow.model.FollowPostReq;
import com.green.greengram.entity.User;
import com.green.greengram.entity.UserFollow;
import com.green.greengram.entity.UserFollowIds;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FollowService {
    private final FollowRepository followRepository;

    private UserFollowIds getIds(long fromUserId, long toUserId) {
        return UserFollowIds.builder()
                            .toUserId(toUserId)
                            .fromUserId(fromUserId)
                            .build();
    }
    public void postUserFollow(long fromUserId, long toUserId) {
        UserFollowIds followIds = getIds(fromUserId, toUserId);

        User fromUser = new User();
        fromUser.setUserId(fromUserId);

        User toUser = new User();
        toUser.setUserId(toUserId);

        UserFollow userFollow = UserFollow.builder()
                .userFollowIds(followIds)
                .fromUser(fromUser)
                .toUser(toUser)
                .build();

        followRepository.save(userFollow);
    }

    public void deleteUserFollow(long fromUserId, long toUserId) {
        UserFollowIds followIds = getIds(fromUserId, toUserId);

        followRepository.deleteById(followIds);
    }
}
