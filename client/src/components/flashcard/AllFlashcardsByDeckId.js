import React, {Component} from 'react';
import axios from 'axios'
import { Link } from 'react-router-dom'
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import NewFlashcard from "./NewFlashcard";

class AllFlashcardsByDeckId extends Component {

    state = {
        flashcards: [],
        showAnswer: false,
        showNewCardForm: false
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

    toggleNewCardForm = () => {
        const showNewCardForm = !this.state.showNewCardForm
        this.setState({showNewCardForm})
    }

    render() {

        return (
            <div>
                <div>
                    {this.state.flashcards.map((card, index) => {
                        return (
                            <div>
                                {this.state.showAnswer
                                    ?
                                    <div>
                                        <Card style={{width: '26rem'}}>
                                            <Card.Body>
                                                <Card.Text>
                                                    {card.answer}
                                                </Card.Text>
                                                <Button variant="primary" onClick={this.toggleAnswer}>Show the
                                                    Clue</Button>
                                            </Card.Body>
                                        </Card>
                                    </div>
                                    :
                                    <div>
                                        <Card style={{width: '26rem'}}>
                                            <Card.Body>
                                                <Card.Text>
                                                    {card.clue}
                                                </Card.Text>
                                                <Button variant="primary" onClick={this.toggleAnswer}>Show the
                                                    Answer</Button>
                                            </Card.Body>
                                        </Card>
                                    </div>
                                }
                            </div>
                        )
                    })}
                </div>
                {this.state.showNewCardForm
                ?
                    <div>
                        <NewFlashcard deckId={this.props.deckId}/>
                        <Button variant="outline-dark" onClick={this.toggleNewCardForm}>Hide Form</Button>
                    </div>
                    :
                    <Button variant="outline-dark" onClick={this.toggleNewCardForm}>Add a Flashcard</Button>
                }
            </div>
        );
    }
}

export default AllFlashcardsByDeckId;