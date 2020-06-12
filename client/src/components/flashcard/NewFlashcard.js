import React, {Component} from 'react';
import axios from "axios";

class NewFlashcard extends Component {

    state = {
        flashcard: {
            clue: '',
            answer: '',
            deckId: ''
        }
    }

    handleChange = (evt) => {
        const newState = {...this.state}
        newState.flashcard[evt.target.name] = evt.target.value
        this.setState(newState)
    }

    onSubmit = async (evt) => {
        evt.preventDefault()
        try {
            await axios.post('/api/v1/flashcards/newFlashcard', this.state.deck)
            console.log("created a new flashcard")
        } catch (e) {
            console.log("failed to create a new flashcard")
            console.error(e)
        }
    }

    render() {
        return (
            <div>
                <form onSubmit={this.onSubmit}>
                    <label>Clue</label>
                    <textarea
                        type='text'
                        name='clue'
                        onChange={this.handleChange}
                        value={this.state.flashcard.clue}
                    />
                    <label>Answer</label>
                    <textarea
                        type='text'
                        name='answer'
                        onChange={this.handleChange}
                        value={this.state.flashcard.answer}
                    />
                    <label>Deck ID</label>
                    <input
                        type='text'
                        name='deckId'
                        onChange={this.handleChange}
                        value={this.props.deckId}
                    />
                    <input type="submit" value="Add"/>
                </form>
            </div>
        );
    }
}

export default NewFlashcard;