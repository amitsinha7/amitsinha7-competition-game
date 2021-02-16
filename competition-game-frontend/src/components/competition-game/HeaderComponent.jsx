import React, { Component } from "react";
import { Link } from "react-router-dom";
import AuthenticationService from "../../api/jwt/AuthenticationService";

class HeaderComponent extends Component {
  render() {
    const isUserLoggedIn = AuthenticationService.isUserLoggedIn();
    return (
      <header>
        <nav className="navbar navbar-expand-sm bg-primary navbar-dark">
          <div className="navbar-brand">COGNIZANT CHALLENGE</div>
          <ul className="navbar-nav navbar-collapse justify-content-end">
            {isUserLoggedIn && (
              <li>
                <Link
                  className="btn btn-outline-success my-2 my-sm-0 navbar-brand"
                  to="/submitchallenge"
                >
                  SOLVE
                </Link>
              </li>
            )}
            {isUserLoggedIn && (
              <li>
                <Link
                  className="btn btn-outline-success my-2 my-sm-0 navbar-brand"
                  to="/scores"
                >
                  TOP 3
                </Link>
              </li>
            )}
            {!isUserLoggedIn && (
              <li>
                <Link
                  className="btn btn-outline-success my-2 my-sm-0 navbar-brand"
                  to="/login"
                >
                  Login
                </Link>
              </li>
            )}
            {isUserLoggedIn && (
              <li>
                <Link
                  className="btn btn-outline-success my-2 my-sm-0 navbar-brand"
                  to="/logout"
                  onClick={AuthenticationService.logout}
                >
                  Logout
                </Link>
              </li>
            )}
          </ul>
        </nav>
      </header>
    );
  }
}

export default HeaderComponent;
