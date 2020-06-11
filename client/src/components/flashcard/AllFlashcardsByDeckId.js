import React, {Component} from 'react';
import axios from 'axios'
import { Link } from 'react-router-dom'
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";

class AllFlashcardsByDeckId extends Component {

    state = {
        flashcards: [],
        showAnswer: false
    }

    componentDidMount() {
        this.getFlashcardsByDeckId()
    }

    getFlashcardsByDeckId = async () => {
        try {
            const deckId = this.props.deckId
            const res = await axios.get(`/api/v1/flashcards/deck/${deckId}`)
            const newState = {...this.state}
            newState.flashcards = res.data
            this.setState(newState)
        } catch (e) {
            console.log("failed to get flashcards by deck id")
            console.error(e)
        }
    }

    toggleAnswer = () => {
        const showAnswer = !this.state.showAnswer
        this.setState({showAnswer})
    }

    render() {
        return (
            <div>
                {this.state.showAnswer
                ?
                    <div>
                        <Card style={{ width: '26rem' }}>
                            <Card.Body>
                                <Card.Text>
                                    Clue = Some quick example text to build on the card title and make up the bulk of
                                    the card's content.
                                </Card.Text>
                                <Button variant="primary" onClick={this.toggleAnswer}>Show the Answer</Button>
                            </Card.Body>
                        </Card>
                    </div>
                    :
                    <div>
                        <Card style={{ width: '26rem' }}>
                            <Card.Body>
                                <Card.Text>
                                    Some example text to act as an asnwer
                                </Card.Text>
                                <Button variant="primary" onClick={this.toggleAnswer}>Show the Clue</Button>
                            </Card.Body>
                        </Card>
                    </div>
                }
            </div>
        );
    }
}

export default AllFlashcardsByDeckId;