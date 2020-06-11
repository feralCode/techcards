import React, {Component} from 'react';
import axios from 'axios'
import { Link } from 'react-router-dom'

class Home extends Component {
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
            console.log("Failed to get all users")
            console.error(e)
        }
    }

    render() {
        return (
            <div className="home-page">
                <h1>Home</h1>
            </div>
        );
    }
}

export default Home;