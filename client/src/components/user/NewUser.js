import React, {Component} from 'react';
import axios from "axios";

class NewUser extends Component {

    state = {
        user: {
            name: '',
            about: ''
        }
    }


    handleChange = (evt) => {
        const newState = {...this.state}
        newState.user[evt.target.name] = evt.target.value
        this.setState(newState)
    }

    onSubmit = async (evt) => {
        evt.preventDefault()
        try {
            await axios.post('/api/v1/user/newUser', this.state.user)
            console.log("created a new user")
        } catch (e) {
            console.log("failed to create a new user")
            console.error(e)
        }
    }

    render() {
        return (
            <div>
                <form onSubmit={this.onSubmit}>
                    <label>Name</label>
                    <input
                        type='text'
                        name='name'
                        onChange={this.handleChange}
                        value={this.state.user.name}
                    />
                    <label>About</label>
                    <input
                        type='textarea'
                        name='about'
                        onChange={this.handleChange}
                        value={this.state.user.imageUrl}
                    />
                    <input type="submit" value="Create User"/>
                </form>
            </div>
        );
    }
}

export default NewUser;