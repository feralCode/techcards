import React from 'react';
import './App.css';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom'
import 'bootstrap/dist/css/bootstrap.css'
import Home from './components/Home.js'
import NavBar from "./components/NavBar";
import AllSubjects from "./components/subject/AllSubjects";
import SingleSubject from "./components/subject/SingleSubject";
import SingleDeck from "./components/deck/SingleDeck";
import NewUser from "./components/user/NewUser";
import AllUsers from "./components/user/AllUsers";


function App() {
  return (
      <div>
        <Router>
            <div>
                <NavBar/>
            </div>
          <div className="wrapper">
            <Switch>
              <Route exact path="/" component={Home} />
              <Route exact path="/browse/subjects" component={AllSubjects}/>
              <Route exact path="/subject/:subjectId" component={SingleSubject}/>
              <Route exact path="/deck/:deckId" component={SingleDeck}/>
              <Route exact path="/user/newUser" component={NewUser}/>
              <Route exact path="/users" component={AllUsers}/>
            </Switch>
          </div>
        </Router>
      </div>
  );
}

export default App;
