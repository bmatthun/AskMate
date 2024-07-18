import { useState } from "react";

const UserForm = ({ onSave, user, onCancel }) => {
  const [name, setName] = useState(user?.name ?? "");

  const onSubmit = (e) => {
    e.preventDefault();

    if (user) {
      return onSave({
        ...user,
        name
      });
    }

    return onSave({
      name
    });
  };

  return (
    <form className="UserForm" onSubmit={onSubmit}>
      <div className="control">
        <label htmlFor="name">Username:</label>
        <input
          value={name}
          onChange={(e) => setName(e.target.value)}
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
