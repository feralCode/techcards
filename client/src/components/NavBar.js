import React, {Component} from 'react';
import axios from "axios";
import DropdownButton from "react-bootstrap/DropdownButton";
import Dropdown from "react-bootstrap/Dropdown";
import { Link } from 'react-router-dom'

class NavBar extends Component {

    state = {
        allUsers: [],
        currentUserId: ''
    }

    componentDidMount() {
        this.getAllUsers()
    }

    getAllUsers = async () => {
        try {
            const res = await axios.get('/api/v1/user/all')
            const newState = {...this.state}
            newState.allUsers = res.data
            this.setState(newState)
        } catch (e) {
            console.log("Failed to get all users")
            console.error(e)
        }
    }


    render() {
        return (
            <div>
                <nav className="nav-bar">

                    {/*TODO: pass current id to links with state*/}
                    <Link to={"/browse/subjects"}>
                        <div className="nav-link">Browse</div>
                    </Link>
                    <div className="nav-link">Create</div>

                    <Link to={"/"}>
                        <div className="logo">TECHCARDS</div>
                    </Link>

                    <div className="nav-link">Users</div>
                    <DropdownButton id="dropdown-basic-button" title="Select User">
                        {this.state.allUsers.map((user, index) => {
                            return (
                                <div key={`fw755wf34 - ${index}`}>
                                    <Dropdown.Item onClick={() => {
                                        const newState = {...this.state}
                                        newState.currentUserId = user.id
                                        this.setState(newState)
                                    }}>{user.name}</Dropdown.Item>
                                </div>
                            )
                        })}
                    </DropdownButton>
                </nav>
            </div>
        );
    }
}

export default NavBar;