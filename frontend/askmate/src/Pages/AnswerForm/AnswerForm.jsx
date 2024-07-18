import { useState } from "react";

const AnswerForm = ({ onSave, answer, onCancel }) => {
  const [description, setDescription] = useState(answer?.description ?? "");

  const onSubmit = (e) => {
    e.preventDefault();

    if (answer) {
      return onSave({
        ...answer,
        description
      });
    }

    return onSave({
      description
    });
  };

  return (
    <form className="AnswerForm" onSubmit={onSubmit}>
      <div className="control">
        <label htmlFor="name">Answer: </label>
        <input
          value={answer}
          onChange={(e) => setDescription(e.target.value)}
          name="name"
          id="name"
        />
      </div>

      <div className="buttons">
        <button type="button" onClick={onSubmit}>
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
