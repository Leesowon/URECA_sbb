package com.mysite.sbb_250410.question;

import com.mysite.sbb_250410.answer.AnswerForm;
import com.mysite.sbb_250410.entity.Question;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/question")
@RequiredArgsConstructor 
@Controller
public class QuestionController {

//    private final QuestionRepository questionRepository;
    private final QuestionService questionService;

    @GetMapping("/list") // 8080 이후에 Url 매핑을 해주면
//    @ResponseBody // return 값을 body에 담아 브라우저에 출력
    // Spring MVC에서 컨트롤러 메서드가 리턴한 값을 HTTP 응답 본문(body)에 직접 담아서 브라우저에 전달하라는 의미

    public String list(Model model) { // 매개변수로 Model을 지정하면 객체가 자동으로 생성된다.
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list"; // 화면에 해당 문자 리턴 -> 브라우저에 실행시킬 html 파일 이름
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) { // 조회를 위해 question_form을 실행할 때 th:oject의 객체를 넘겨줘야 한다.
        return "question_form";
    }

    // 오버로딩
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list";
    }
}