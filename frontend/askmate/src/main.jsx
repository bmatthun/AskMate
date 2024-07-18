import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'
import {createBrowserRouter, RouterProvider} from "react-router-dom";
import Layout from './Pages/Layout/Layout.jsx';
import AllQandA from './Pages/AllQandA.jsx';
import RegisterUser from './Pages/RegisterUser.jsx';
import Login from './Pages/Login.jsx';

const router = createBrowserRouter([
  {
    path: "/",
    element: <Layout/>,
    children: [
      {
      path: "/all",
      element: <AllQandA/>
      },
      {
      path: "/login",
      element: <Login/>
      },
      {
        path: "/register",
        element: <RegisterUser/>
      }
    ]  
  }
])


ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);