import React, { Component } from 'react'
import { Link } from 'react-router-dom'
import AuthenticationService from './services/AuthenticationService'


class HeaderComponent extends Component {
    render() {
        const isUserLoggedIn = AuthenticationService.isUserLoggedIn();
        return (
            <header>
                <nav className="navbar navbar-expand-sm bg-primary navbar-dark">
                    <div className="navbar-brand">COGNIZANT CHALLENGE</div>
                    <ul className="navbar-nav">
                        {isUserLoggedIn && <li><Link className="nav-link" to="/welcome">SOLVE</Link></li>}
                        {isUserLoggedIn && <li><Link className="nav-link" to="/todos">TOP3</Link></li>}
                    </ul>
                    <ul className="navbar-nav navbar-collapse justify-content-end">
                        {!isUserLoggedIn && <li><Link className="nav-link" to="/login">Login</Link></li>}
                        {isUserLoggedIn && <li><Link className="nav-link" to="/logout" onClick={AuthenticationService.logout}>Logout</Link></li>}
                    </ul>
                </nav>
            </header>
        )
    }
}

export default HeaderComponent