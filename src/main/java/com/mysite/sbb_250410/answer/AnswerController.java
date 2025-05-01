package com.mysite.sbb_250410.answer;

import com.mysite.sbb_250410.entity.Question;
import com.mysite.sbb_250410.question.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/answer")
@RequiredArgsConstructor // 생성자를 만들어줌 그러면 생성자 ioc 컨테이너가 그 생성자를 보고 의존성 주입
@Controller
public class AnswerController {

    private final QuestionService questionService; // final 필드만 선언해주면 생성자 자동 생성 by @RequiredArgsConstructor
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model
            , @PathVariable("id") Integer id
            , @Valid AnswerForm answerForm, BindingResult bindingResult) {

        Question question = this.questionService.getQuestion(id);

        if (bindingResult.hasErrors()) {
            model.addAttribute("question", question);
            return "question_detail"; // 다시 답변을 할 수 있는 템플릿 출력
        }
        this.answerService.create(question, answerForm.getContent());

        return String.format("redirect:/question/detail/%s", id);

    } // createAnswer
} // class