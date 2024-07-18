import { Outlet, Link } from "react-router-dom";

const Layout = () => (
  <>
  <h1>
    Welcome to AskMáté.com
  </h1>
  <h3>
  Providing answers to your most burning questions since...yesterday
  </h3>
  <div className="Layout">
    <nav>
      <ul>
        <li>
          <Link to="/login">
            <button type="button">Login</button>
          </Link>
        </li>
        <li>
          <Link to="/register">
          <button type="button">Register</button>
          </Link>
        </li>
      </ul>
    </nav>
    <Outlet />
  </div>
  </>
);

export default Layout;