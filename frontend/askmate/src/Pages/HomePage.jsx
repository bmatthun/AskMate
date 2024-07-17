import { useEffect, useState } from "react";



export default function Homepage() {
  const [questions, setQuestions] = useState(null);

async function fetchQuestions() {
  const res = await fetch("/api/question/all");
  const data = await res.json();
  setQuestions(data);
}

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
        </div>
      ))}
    </>
  ) : (<div>Loading...</div>)
);
}


