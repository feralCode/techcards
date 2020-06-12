import React, {Component} from 'react';
import axios from 'axios'
import Button from "react-bootstrap/Button";

class SingleUser extends Component {
    state = {
        user: {
            name: '',
            about: ''
        },
        showEditForm: false
    }

    componentDidMount() {
        this.getUserById()
    }

    getUserById = async () => {
        try {
            const userId = this.props.match.params.userId
            const res = await axios.get(`/api/v1/user/${userId}`)
            const newState = {...this.state}
            newState.user = res.data
            this.setState(newState)
        } catch (e) {
            console.log("failed to get single user")
            console.error(e)
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
            await axios.put('/api/v1/user/editUser', this.state.user)
            console.log("edited user")
        } catch (e) {
            console.log("failed to edit user")
            console.error(e)
        }
    }

    toggleEditForm = () => {
        const showEditForm = !this.state.showEditForm
        this.setState({ showEditForm })
    }

    render() {
        return (
            //TODO: get user's created decks and liked decks
            <div>
                {this.state.showEditForm
                ?
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
                                type='text'
                                name='about'
                                onChange={this.handleChange}
                                value={this.state.user.about}
                            />
                            <input type="submit" value="Save"/>
                        </form>
                        <Button variant="outline-dark" onClick={this.toggleEditForm} >
                            Back
                        </Button>
                    </div>
                :
                    <div>
                        <div className="title">{this.state.user.name}</div>
                        <div className="about">{this.state.user.about}</div>
                        <Button variant="outline-dark" onClick={this.toggleEditForm} >
                            Edit
                        </Button>
                    </div>
                }
            </div>
        );
    }
}

export default SingleUser;