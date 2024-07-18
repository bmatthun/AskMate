import { Outlet, Link } from "react-router-dom";

const Layout = () => (
  <div className="Layout">
    <nav>
      <ul>
        <li>
          <Link to="/login">
            <button type="button">Log in</button>
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
);

export default Layout;