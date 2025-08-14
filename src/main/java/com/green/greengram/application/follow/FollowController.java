package com.green.greengram.application.follow;

import com.green.greengram.application.follow.model.FollowPostReq;
import com.green.greengram.config.model.ResultResponse;
import com.green.greengram.config.model.UserPrincipal;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user/follow")
public class FollowController {
    private final FollowService followService;

    @PostMapping
    public ResultResponse<?> postUserFollow(@AuthenticationPrincipal UserPrincipal userPrincipal
                                            , @Valid @RequestBody FollowPostReq req){
        log.info("post fromUserId: {}", userPrincipal.getSignedUserId());
        log.info("post toUserId: {}", req.getToUserId());
        followService.postUserFollow(userPrincipal.getSignedUserId(), req.getToUserId());
        return new ResultResponse<>("팔로우 했습니다",null);
    }
    @DeleteMapping
    public ResultResponse<?> deleteUserFollow(@AuthenticationPrincipal UserPrincipal userPrincipal
                                              , @RequestParam("to_user_id") @Positive Long toUserId){
        log.info("delete fromUserId: {}", userPrincipal.getSignedUserId());
        log.info("delete toUserId: {}", toUserId);
        followService.deleteUserFollow(userPrincipal.getSignedUserId(), toUserId);
        return new ResultResponse<>("팔로우 취소",null);
    }
}
