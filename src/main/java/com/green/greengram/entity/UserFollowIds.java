package com.green.greengram.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable // 포함될 수 있는
public class UserFollowIds implements Serializable {
    private Long fromUserId;
    private Long toUserId;
}
