import React, {Component} from 'react';

class SingleSubject extends Component {

    state = {
        subject: {
            name: '',
            imageUrl: '',
            deckList: []
        }
    }

    componentDidMount() {
        this.getSubjectById()
    }

    getSubjectById = async () => {
        const subjectId = this.props.match.params.subjectId
        const res = await axios.get(`/api/v1/subject/${subjectId}`)
        const newState = {...this.state}
        newState.subject = res.data
        this.setState(newState)
    }

    render() {
        return (
            <div>
                <img className="subject-img" src={this.state.subject.imageUrl}/>
                <div className="title">{this.state.subject.name}</div>
                {/*<div>*/}
                {/*    {this.state.subject.deckList.map((deck, index) => {*/}
                {/*        return (*/}
                {/*            <div key={`5wg5vrg - ${index}`}>*/}
                {/*                /!*TODO: use creator id to get the user that created each deck*!/*/}
                {/*                <div>{deck.name}</div>*/}
                {/*                <div>Flashcards: {deck.flashcards.length}</div>*/}
                {/*                <div>Likes: {deck.likes.length}</div>*/}
                {/*            </div>*/}
                {/*        )*/}
                {/*    })}*/}
                {/*</div>*/}

            {/* all decks by subject id component*/}
            </div>
        );
    }
}

export default SingleSubject;