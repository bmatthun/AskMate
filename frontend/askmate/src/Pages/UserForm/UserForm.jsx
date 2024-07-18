import { useState } from "react";

const UserForm = ({ onSave, user, onCancel }) => {
  const [userName, setUserName] = useState(user?.userName ?? "");

  const onSubmit = (e) => {
    e.preventDefault();

    if (user) {
      console.log(user)
      return onSave({
        userName 
      });
    }

    return onSave({
      userName
    });
  };

  return (
    <form className="UserForm" onSubmit={onSubmit}>
      <div className="control">
        <label htmlFor="name">Username:</label>
        <input
          value={userName}
          onChange={(e) => setUserName(e.target.value)}
          name="name"
          id="name"
        />
      </div>

      <div className="buttons">
        <button type="button" onClick={onSubmit}>
          Create user
        </button>

        <button type="button" onClick={onCancel}>
          Cancel
        </button>
      </div>
    </form>
  );
};

export default UserForm;
