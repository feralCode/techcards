import React, {Component} from 'react';
import axios from "axios";

class EditFlashcard extends Component {
    state = {
        flashcard: {
            id: '',
            clue: '',
            answer: '',
            deckId: ''
        }
    }

    componentDidMount() {
        this.getFlashcardById()
    }

    getFlashcardById = async () => {
        try {
            const flashcardId = this.props.flashcardId
            const res = await axios.get(`/api/v1/flashcards/${flashcardId}`)
            const newState = {...this.state}
            newState.flashcard = res.data
            this.setState(newState)
        } catch (e) {
            console.log("failed to get single card")
            console.error(e)
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
                await axios.put('/api/v1/flashcards/editFlashcard', this.state.flashcard)
                console.log("edited flashcard")
            } catch (e) {
                console.log("failed to edit flashcard")
                console.error(e)
            }
    }


    render() {
        return (
            <div>
                <div>
                    <form onSubmit={this.onSubmit}>
                        <label>Flashcard ID</label>
                        <input
                            type="text"
                            name="id"
                            value={this.props.flashcardId}
                            onChange={this.handleChange}
                        />
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
                            type="text"
                            name="deckId"
                            value={this.props.deckId}
                            onChange={this.handleChange}
                        />
                        <input type="submit" value="Save"/>
                    </form>
                </div>
            </div>
        );
    }
}

export default EditFlashcard;