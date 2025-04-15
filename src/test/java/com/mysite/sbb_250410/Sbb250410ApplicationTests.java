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
//		Question q1 = this.questionRepository.findBySubject("sbb가 뭔가요?");
//		assertEquals(1, q1.getId());
//
//		Question q2 = this.questionRepository.findBySubjectAndContent("sbb가 뭔가요?", "sbb에 대해서 알고 싶습니다.");
//		assertEquals(1, q2.getId());
//
//		List<Question> qList1 = this.questionRepository.findBySubjectLike("sbb%");
//		Question q = qList1.get(0);
//		assertEquals("sbb가 무엇인가요?", q.getSubject());

		// 9. 데이터 수정
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent()); // false를 리턴하면 오류 발생 후 테스트 종료
//		Question q = oq.get();
//		q.setSubject("수정된 제목");
//		this.questionRepository.save(q);

		// 10. 데이터 삭제
//		assertEquals(2, this.questionRepository.count()); // 데이터가 2개이면
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		this.questionRepository.delete(q);
//		assertEquals(1, this.questionRepository.count());

		// 11. 답변 데이터 저장하기
//		Optional<Question> oq = this.questionRepository.findById(2); // id 값으로 데이터 조회
//		System.out.println("oq = " + oq);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//
//		Answer a = new Answer();
//		a.setContent("네 자동으로 생성됩니다.");
//		a.setQuestion(q); // 어떤 질문의 답변인지 알기 위해서 Question 객체 필요
//		a.setCreateDate(LocalDateTime.now());
//		this.answerRepository.save(a);

		// 12. 답변 데이터 조회하기
//		Optional<Answer> oa = this.answerRepository.findById(1); // Id 값이 1인 데이터가 있는지 조회
//		assertTrue(oa.isPresent());
//		Answer a = oa.get();
//		assertEquals(2, a.getQuestion().getId()); // 조회된 데이터가 답변한 질문이 2인지 확인

		// 13. 질문 -> 답변 찾기
		Optional<Question> oq = this.questionRepository.findById(2); // id가 2인 질문
		assertTrue(oq.isPresent());
		Question q = oq.get(); // id=2인 질문 객체 정보 얻기

		List<Answer> answerList = q.getAnswerList();

		assertEquals(1, answerList.size());
		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
	}
}