package com.green.greengram.application.feed.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.bind.annotation.BindParam;

@ToString
@Getter
public class FeedGetReq {
    @NotNull(message = "필수입니다")
    @Positive // 1이상의 데이터만 가능
    private Integer page;
    @NotNull(message = "필수입니다")
    @Min(value = 20, message = "20이상")
    @Max(value = 100, message = "100이하")
    private Integer rowPerPage;

    public FeedGetReq(Integer page,@BindParam("row_per_page") Integer rowPerPage) {
        this.page = page;
        this.rowPerPage = rowPerPage;
    }
}
