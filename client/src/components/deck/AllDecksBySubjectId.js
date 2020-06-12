import React, {Component} from 'react';
import axios from 'axios'
import { Link } from 'react-router-dom'
import NewDeck from "./NewDeck";
import Button from "react-bootstrap/Button";

class AllDecksBySubjectId extends Component {

    state = {
        deckList: [],
        showNewDeckForm: false
    }

    componentDidMount() {
        this.getDecksBySubjectId()
    }

    getDecksBySubjectId = async () => {
        try {
            const subjectId = this.props.subjectId
            const res = await axios.get(`/api/v1/deck/subject/${subjectId}`)
            const newState = {...this.state}
            newState.deckList = res.data
            this.setState(newState)
        } catch (e) {
            console.log("failed to get decks by subject id")
            console.error(e)
        }
    }

    toggleNewDeckForm = () => {
        const showNewDeckForm = !this.state.showNewDeckForm
        this.setState({ showNewDeckForm })
    }

    render() {
        return (
            <div>
                <div>
                    {this.state.showNewDeckForm
                    ?
                        <div>
                            <NewDeck
                                userId={this.props.userId}
                                subjectId={this.props.subjectId}
                            />
                            <Button variant="outline-dark" className="back-button" onClick={this.toggleNewDeckForm} >
                                Back
                            </Button>
                        </div>
                    :
                        <div>
                            {this.state.deckList.map((deck, index) => {
                                return (
                                    <div key={`f432fw44f - ${index}`}>
                                        <Link to={`/deck/${deck.id}`}>
                                            <div>{deck.name}</div>
                                        </Link>
                                        {/*<div>Flashcards: {deck.flashcards.length}</div>*/}
                                        {/*<div>Likes: {deck.likes.length}</div>*/}
                                        {/*TODO: pass this.prop.userId through create deck comp*/}
                                    </div>
                                )
                            })}
                            <Button variant="outline-dark" onClick={this.toggleNewDeckForm} >
                                Add A Deck
                            </Button>
                        </div>
                    }
                </div>
            </div>
        );
    }
}

export default AllDecksBySubjectId;