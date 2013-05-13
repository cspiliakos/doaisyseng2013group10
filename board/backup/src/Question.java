import java.io.Serializable;

public class Question implements Serializable{
	//class for objects questions for Quiz puzzle
	//finaly the are saved to a file for future use
	private static final long serialVersionUID = 1L;
	private String question, answer1, answer2, answer3, answer4, correctAnswer;

	public Question(String question, String answer1, String answer2, String answer3,
			String answer4, String correct) {
		//one question, 4 possible answers, 1 correct answer
		this.question = question;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.correctAnswer = correct;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public String getAnswer4() {
		return answer4;
	}

	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}

	public String getCorrect() {
		return correctAnswer;
	}

	public void setCorrect(String correct) {
		this.correctAnswer = correct;
	}
}
