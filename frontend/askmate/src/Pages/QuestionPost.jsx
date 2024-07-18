import { useState } from "react";

export default function QuestionPost() {

  const [newQuestion, setNewQuestion] = useState("");
  const [description, setDescription] = useState("");
  const [userName, setUserName] = useState("");
  const [userId, setUserId] = useState(0);
  const [title, setTitle] = useState("");


  async function fetchUser() {
    const res = await fetch(`/api/user/name/${userName}`);
    const user = await res.json();
  
    return user.id;
  }


async function fetchNewQuestion(id, question) {
  const response = await fetch(`/api/question/${id}`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(question),
  });
  return response.json();
}

const onSubmit = async (e) => {
  e.preventDefault();
  try {
    const fetchUserId = await fetchUser();


    const newQuestion = {
      title: title,
      description: description
    };

    setNewQuestion(newQuestion);

    await fetchNewQuestion(fetchUserId, newQuestion);

    console.log(userId);
    console.log(newQuestion);

  } catch (error) {
    console.error("Failed to submit question:", error);
  }
};

return (
  <form className="QuestionForm" onSubmit={onSubmit}>
    <div className="control">
      <label htmlFor="description">Title: </label>
      <input
        value={title}
        onChange={(e) => setTitle(e.target.value)}
        name="title"
        id="title"
      />
      <label htmlFor="description">Question: </label>
      <input
        value={description}
        onChange={(e) => setDescription(e.target.value)}
        name="description"
        id="description"
      />
      <label htmlFor="userName">Username: </label>
        <input
          value={userName}
          onChange={(e) => setUserName(e.target.value)}
          name="userName"
          id="userName"
        />
    </div>


    <div className="buttons">
      <button type="submit">
        Submit question
      </button>
    </div>
  </form>
);

}