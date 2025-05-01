package com.mysite.sbb_250410.answer;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class AnswerForm {

    @NotEmpty(message = "내용은 필수항목입니다.")
    private String content;
}
