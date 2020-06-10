import React from 'react';
import './App.css';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom'
import DropdownButton from 'react-bootstrap/DropdownButton'
import Dropdown from 'react-bootstrap/Dropdown'
import 'bootstrap/dist/css/bootstrap.css'
import Home from './components/Home.js'

function App() {
  return (
      <div>
        <Router>
          <nav className="nav-bar">
            <div className="links">
              <div className="nav-link">Browse</div>
              <div className="nav-link">Create</div>
            </div>
            <div>
              <div className="logo">TECHCARDS</div>
            </div>
            <div className="user-dropdown">
              <DropdownButton id="dropdown-basic-button" title="Select User">
                <Dropdown.Item href="#/action-1">Action</Dropdown.Item>
                <Dropdown.Item href="#/action-2">Another action</Dropdown.Item>
                <Dropdown.Item href="#/action-3">Something else</Dropdown.Item>
              </DropdownButton>
            </div>
          </nav>

          <div className="wrapper">
            <Switch>
              <Route exact path="/" component={Home} />
            </Switch>
          </div>
        </Router>
      </div>
  );
}

export default App;
