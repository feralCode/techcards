import React, {Component} from 'react';
import axios from 'axios'
import AllDecksBySubjectId from "../deck/AllDecksBySubjectId";

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
        try {
            const subjectId = this.props.match.params.subjectId
            const res = await axios.get(`/api/v1/subject/${subjectId}`)
            const newState = {...this.state}
            newState.subject = res.data
            this.setState(newState)
        } catch (e) {
            console.log("failed to get single subject")
            console.error(e)
        }
    }

    render() {
        return (
            <div>
                <img className="subject-img" src={this.state.subject.imageUrl}/>
                <div className="title">{this.state.subject.name}</div>
                {/*<div>{this.state.subject.deckList.map()}</div>*/}

                <AllDecksBySubjectId subjectId={this.props.match.params.subjectId}/>
            </div>
        );
    }
}

export default SingleSubject;