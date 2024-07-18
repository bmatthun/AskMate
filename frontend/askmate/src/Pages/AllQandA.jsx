import { useEffect, useState } from "react";
import AnswerForm from "./AnswerForm/AnswerForm";
import { useNavigate } from "react-router-dom";
import QuestionPost from "./QuestionPost";

export default function AllQandA() {
  const [questions, setQuestions] = useState(null);
  const [answerList, setAnswerList] = useState([]);

  async function fetchQuestions() {
    const res = await fetch("/api/question/all");
    const data = await res.json();
    setQuestions(data);
  }

  async function fetchAnswersToOneQuestion(questionId) {
    const res = await fetch(`/api/answer/${questionId}`);
    const data = await res.json();
    setAnswerList(data);
  }

  const deleteAnswer = (id) => {
    const data = fetch(`/api/answer/${id}`, { method: "DELETE" }).then((res) =>
      res.json()
    );
    console.log(data);
    return data
  };

  const deleteQuestion = (id) => {
    return fetch(`/api/question/${id}`, { method: "DELETE" }).then((res) =>
      res.json()
    );
  };

  const handleDeleteAnswer = (id) => {
    deleteAnswer(id);
    setAnswerList((answers) => {
      return answers.filter((answer) => answer.id !== id);
    });
  };

  const handleDeleteQuestion = (id) => {

    console.log(id);
    deleteQuestion(id);
    setQuestions((questions) => {
      return questions.filter((question) => question.id !== id);
    });
  };

  const createAnswer = (answer) => {
    return fetch("/api/answer/create", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(answer),
    }).then((res) => res.json());
  };

  const navigate = useNavigate();

  const handleCreateAnswer = (answer) => {
    createAnswer(answer).then(() => {
      navigate("/");
    });
  };

  useEffect(() => {
    fetchQuestions();
  }, []);

  return questions ? (
    <>
     <QuestionPost/>
      {questions.map((question) => (
        <div key={question.id}>
          <div>Title: {question.title}</div>
          <div>Description: {question.description}</div>
          <button type="button" onClick={() => fetchAnswersToOneQuestion(question.id)}>
            Show answers
          </button>
          {answerList && answerList.map((answer, i) => (
            <ul key={i}>
              <li>
                {answer.description}
              </li>
            </ul>
          ))}
          <button type="button" onClick={() => handleDeleteQuestion(question.id)}>
            Delete
          </button>
          <AnswerForm
            questionId={question.id}
            onCancel={() => navigate("/")}
            onSave={handleCreateAnswer}
          />
        </div>
      ))}
    </>
  ) : (
    <div>Loading...</div>
  );
}
