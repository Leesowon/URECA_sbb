package com.mysite.sbb_250410;

import com.mysite.sbb_250410.answer.AnswerRepository;
import com.mysite.sbb_250410.entity.Answer;
import com.mysite.sbb_250410.entity.Question;
import com.mysite.sbb_250410.question.QuestionRepository;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Sbb250410ApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Transactional
	@Test
	void testJpa() {
		// 13. 질문 -> 답변 찾기
		Optional<Question> oq = this.questionRepository.findById(2); // id가 2인 질문
		assertTrue(oq.isPresent());
		Question q = oq.get(); // id=2인 질문 객체 정보 얻기

		List<Answer> answerList = q.getAnswerList();

		assertEquals(1, answerList.size());
		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
	}
}