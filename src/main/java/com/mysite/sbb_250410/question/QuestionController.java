package com.mysite.sbb_250410.question;

import com.mysite.sbb_250410.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor 
@Controller
public class QuestionController {

    private final QuestionRepository questionRepository;

    @GetMapping("/question/list") // 8080 이후에 Url 매핑을 해주면
//    @ResponseBody // return 값을 body에 담아 브라우저에 출력
    // Spring MVC에서 컨트롤러 메서드가 리턴한 값을 HTTP 응답 본문(body)에 직접 담아서 브라우저에 전달하라는 의미

    public String list(Model model) { // 매개변수로 Model을 지정하면 객체가 자동으로 생성된다.
        List<Question> questionList = this.questionRepository.findAll();
        model.addAttribute("questionList", questionList);
        return "question_list"; // 화면에 해당 문자 리턴 -> 브라우저에 실행시킬 html 파일 이름
    }
}