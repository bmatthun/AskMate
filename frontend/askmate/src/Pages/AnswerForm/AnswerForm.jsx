import { useState } from "react";

const AnswerForm = ({ onSave, onCancel, questionId }) => {
  const [description, setDescription] = useState("");
  const [userName, setUserName] = useState("");
  const [userId, setUserId] = useState(0);
  const [answer, setAnswer] = useState(null);

  async function fetchUser() {
    const res = await fetch(`/api/user/name/${userName}`);
    const user = await res.json();
    return user.id;
  }

  async function fetchAnswer(answer) {
    const response = await fetch(`/api/answer/${answer.userId}/${answer.questionId}`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(answer),
    });
    return response.json();
  }

  const onSubmit = async (e) => {
    e.preventDefault();
    try {
      const fetchedUserId = await fetchUser();
      setUserId(fetchedUserId);

      const newAnswer = {
        userId: fetchedUserId,
        questionId: questionId,
        description: description
      };

      setAnswer(newAnswer);

      const savedAnswer = await fetchAnswer(newAnswer);
      if (onSave) {
        onSave(savedAnswer);
      }
      console.log(fetchedUserId);
      console.log(newAnswer);
      console.log(savedAnswer);
    } catch (error) {
      console.error("Failed to submit answer:", error);
    }
  };

  return (
    <form className="AnswerForm" onSubmit={onSubmit}>
      <div className="control">
        <label htmlFor="description">Answer: </label>
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
          Submit answer
        </button>

        <button type="button" onClick={onCancel}>
          Cancel
        </button>
      </div>
    </form>
  );
};

export default AnswerForm;
