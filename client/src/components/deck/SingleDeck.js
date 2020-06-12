import React, {Component} from 'react';
import axios from "axios";
import AllFlashcardsByDeckId from "../flashcard/AllFlashcardsByDeckId";
import Button from "react-bootstrap/Button";

class SingleDeck extends Component {

    state = {
        deck: {
            name: '',
            flashcards: []
        },
        showEditForm: false
    }

    componentDidMount() {
        this.getDeckById()
    }

    getDeckById = async () => {
        try {
            const deckId = this.props.match.params.deckId
            const res = await axios.get(`/api/v1/deck/${deckId}`)
            const newState = {...this.state}
            newState.deck = res.data
            this.setState(newState)
        } catch (e) {
            console.log("failed to get single deck")
            console.error(e)
        }
    }

    toggleEditForm = () => {
        const showEditForm = !this.state.showEditForm
        this.setState({ showEditForm })
    }
    
    render() {
        return (
            <div>
                {this.state.showEditForm
                ?
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
                            <input type="submit" value="Save"/>
                        </form>
                        <Button variant="outline-dark" className="back-button" onClick={this.toggleEditForm} >
                            Back
                        </Button>
                    </div>
                :
                    <div>
                        <div className="title">{this.state.deck.name}</div>
                        <AllFlashcardsByDeckId
                            deckId={this.props.match.params.deckId}
                        />
                        <Button variant="outline-dark" onClick={this.toggleEditForm} >
                            Edit
                        </Button>
                    </div>
                }
            </div>
        );
    }
}

export default SingleDeck;