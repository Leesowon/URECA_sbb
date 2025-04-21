package com.mysite.sbb_250410.question;

import com.mysite.sbb_250410.DataNotFoundException;
import com.mysite.sbb_250410.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    // questionRepository 객체는 @RequiredArgsConstructor에 의해 생성자 방식으로 주입

    public List<Question> getList() {
        return this.questionRepository.findAll();
    }

    public Question getQuestion(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
        if(question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }

} // class