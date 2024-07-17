import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'
import HomePage from './Pages/HomePage.jsx'
import {createBrowserRouter, RouterProvider} from "react-router-dom";

const router = createBrowserRouter([
  {
  path: "/all",
  element: <HomePage/>
  }
])

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);