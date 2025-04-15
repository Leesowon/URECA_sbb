package com.mysite.sbb_250410.answer;

import com.mysite.sbb_250410.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
//    Answer findBy
}
