import React from 'react';
import './App.css';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom'
import DropdownButton from 'react-bootstrap/DropdownButton'
import Dropdown from 'react-bootstrap/Dropdown'
import 'bootstrap/dist/css/bootstrap.css'
import Home from './components/Home.js'
import NavBar from "./components/NavBar";


function App() {
  return (
      <div>
        <div>
          <NavBar/>
        </div>
        <Router>
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
