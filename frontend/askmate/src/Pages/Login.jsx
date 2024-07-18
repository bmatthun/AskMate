import { useState } from "react";

export default function Login() {

  const [user, setUser] = useState();

  async function fetchUser(name) {
    const res = await fetch(`/api/user/${name}`);
    const data = await res.json();
    setUser(data);
  }

  const onSubmit = (e) => {
    e.preventDefault();
    fetchUser(user);
  };

  return (
    <form className="UserForm" onSubmit={onSubmit}>
      <div className="control">
        <label htmlFor="name">Username: </label>
        <input
          value={user}
          onChange={(e) => setUser(e.target.value)}
          name="name"
          id="name"
        />
      </div>
      <button type="button" onClick={onSubmit}>
          Login
        </button>
    </form>
  );
}