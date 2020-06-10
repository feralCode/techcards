import React from 'react';
import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom'
import DropdownButton from 'react-bootstrap/DropdownButton'
import Dropdown from 'react-bootstrap/Dropdown'
import 'bootstrap/dist/css/bootstrap.css';

function App() {
  return (
      <div>
        <Router>
          <nav className="nav-bar">
            <div className="logo">TECHCARDS</div>
            <div className="links">
              <div className="browse-link">Browse</div>
              <div className="create-link">Create</div>
            </div>
            <div className="user-dropdown">
              <DropdownButton id="dropdown-basic-button" title="Select User">
                <Dropdown.Item href="#/action-1">Action</Dropdown.Item>
                <Dropdown.Item href="#/action-2">Another action</Dropdown.Item>
                <Dropdown.Item href="#/action-3">Something else</Dropdown.Item>
              </DropdownButton>
            </div>
          </nav>
        </Router>
      </div>
  );
}

export default App;
