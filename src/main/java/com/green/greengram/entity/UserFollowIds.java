package com.green.greengram.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable // 포함될 수 있는
public class UserFollowIds implements Serializable {
    private Long fromUserId;
    private Long toUserId;
}
