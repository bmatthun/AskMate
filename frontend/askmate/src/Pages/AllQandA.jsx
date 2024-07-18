import { useEffect, useState } from "react";
import AnswerForm from "./AnswerForm/AnswerForm";
import { useNavigate } from "react-router-dom";


export default function AllQandA() {
  const [questions, setQuestions] = useState(null);
  const [answer, setAnswer] = useState();

async function fetchQuestions() {
  const res = await fetch("/api/question/all");
  const data = await res.json();
  setQuestions(data);
}

const deleteAnswer = (id) => {
  return fetch(`/api/answer/${id}`, { method: "DELETE" }).then((res) =>
    res.json()
  );
};

const deleteQuestion = (id) => {
  return fetch(`/api/question/${id}`, { method: "DELETE" }).then((res) =>
    res.json()
  );
};

const handleDeleteAnswer = (id) => {
  deleteAnswer(id);
  setAnswer((answer) => {
    return answer.filter((answer) => answer.id !== id);
  });
};

const handleDeleteQuestion = (id) => {
  deleteQuestion(id);
  setQuestions((question) => {
    console.log(question)
    return question.filter((question) => question.id !== id);
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
  createAnswer(answer)
    .then(() => {
      navigate("/");
    })
};

useEffect(() => {
  fetchQuestions();
}, []);

return (
  questions ? (
    <>
      {questions.map((question) => (
        <div key={question.id}>
          <div>Title: {question.title}</div>
          <div>Description: {question.description}</div>
          <button type="button" onClick={() => handleDeleteQuestion(question.id)}>
                Delete
              </button>
              <AnswerForm
                onCancel={() => navigate("/")}
                onSave={handleCreateAnswer}
              />
        </div>
      ))}
    </>
  ) : (
    <div>Loading...</div>
  )
)
}