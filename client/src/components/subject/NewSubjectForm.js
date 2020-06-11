import React, {Component} from 'react';
import axios from 'axios'
import Button from "react-bootstrap/Button";

class NewSubjectForm extends Component {

    state = {
        subject: {
            name: '',
            imageUrl: ''
        }
    }

    handleChange = (evt) => {
        const newState = {...this.state}
        newState.subject[evt.target.name] = evt.target.value
        this.setState(newState)
    }

    onSubmit = async (evt) => {
        evt.preventDefault()
        try {
            await axios.post('/api/v1/subject/newSubject', this.state.subject)
            console.log("created a new subject")
        } catch (e) {
            console.log("failed to create a new subject")
            console.error(e)
        }
    }

    render() {
        return (
            <div>
                <form onSubmit={this.onSubmit}>
                    <label>Subject Name</label>
                    <input
                        type='text'
                        name='name'
                        onChange={this.handleChange}
                        value={this.state.subject.name}
                    />
                    <label>Image URL</label>
                    <input
                        type='text'
                        name='imageUrl'
                        onChange={this.handleChange}
                        value={this.state.subject.imageUrl}
                    />
                    <input type="submit" value="Add Subject"/>
                </form>
            </div>
        );
    }
}

export default NewSubjectForm;