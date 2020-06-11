import React, {Component} from 'react';
import axios from 'axios'
import { Link } from 'react-router-dom'
import Button from "react-bootstrap/Button";

class AllUsers extends Component {

    state = {
        allUsers: []
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
            console.log("failed to get all users")
            console.error(e)
        }
    }

    render() {
        return (
            <div>
                <div className="title">People that have used TechCards</div>
                {this.state.allUsers.map((user, index) => {
                    return (
                        <div key={`wf5gf43b4wt4 - ${index}`}>
                            <Link to={`/user/${user.id}`}>
                                <div>{user.name}</div>
                            </Link>
                        </div>
                    )
                })}
                <Link to={"/user/newUser"}>
                    <Button variant="outline-dark">
                        Sign Up
                    </Button>
                </Link>
            </div>
        );
    }
}

export default AllUsers;