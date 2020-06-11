import React, {Component} from 'react';
import axios from "axios";

class SingleDeck extends Component {

    state = {
        deck: {
            name: '',
            flashcards: []
        }
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
    
    render() {
        return (
            <div>
                <div className="title">{this.state.deck.name}</div>
            </div>
        );
    }
}

export default SingleDeck;