import { useNavigate } from "react-router-dom";
import UserForm from "./UserForm/UserForm";


const createUser = (user) => {
  return fetch("/api/user/create", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(user),
  }).then((res) => res.json());
};

const UserCreator = () => {
  const navigate = useNavigate();

  const handleCreateUser = (user) => {

    createUser(user)
      .then(() => {
        navigate("/");
      })
  };

  return (
    <UserForm
      onCancel={() => navigate("/")}
      onSave={handleCreateUser}
    />
  
  );
};

export default UserCreator;