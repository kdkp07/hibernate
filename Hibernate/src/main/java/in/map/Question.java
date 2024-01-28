package in.map;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Question {
	@Id
	@Column(name = "question_id")
	private int questionId;
	private String question;

	@OneToMany(mappedBy = "question")
	private List<Answer> ans ; 


	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<Answer> getAns() {
		return ans;
	}
	public void setAns(List<Answer> ans) {
		this.ans = ans;
	}
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + ", ans=" + ans + "]";
	}



}
