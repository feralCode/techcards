import React, {Component} from 'react';
import axios from "axios";

class NewDeck extends Component {
    state = {
        deck: {
            name: '',
            creatorId: '',
            subjectId: ''
        }
    }

    handleChange = (evt) => {
        const newState = {...this.state}
        newState.deck[evt.target.name] = evt.target.value
        this.setState(newState)
    }

    onSubmit = async (evt) => {
        evt.preventDefault()
        try {
            await axios.post('/api/v1/deck/newDeck', this.state.deck)
            console.log("created a new deck")
        } catch (e) {
            console.log("failed to create a new deck")
            console.error(e)
        }
    }

    render() {
        return (
            <div>
                <form onSubmit={this.onSubmit} className="form">
                    <label className="form-label">Deck Name</label>
                    <input
                        type='text'
                        name='name'
                        className="form-input"
                        onChange={this.handleChange}
                        value={this.state.deck.name}
                    />
                    <label className="form-label">Creator ID</label>
                    <input
                        type='text'
                        name='creatorId'
                        className="form-input"
                        onChange={this.handleChange}
                        value={this.props.userId}
                    />
                    <label className="form-label">Subject ID</label>
                    <input
                        type='text'
                        name='subjectId'
                        className="form-input"
                        onChange={this.handleChange}
                        value={this.props.subjectId}
                    />
                    <input type="submit" value="Add Deck"/>
                </form>
            </div>
        );
    }
}

export default NewDeck;