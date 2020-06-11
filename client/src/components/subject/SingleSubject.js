import React, {Component} from 'react';
import axios from 'axios'
import AllDecksBySubjectId from "../deck/AllDecksBySubjectId";

class SingleSubject extends Component {

    state = {
        subject: {
            name: '',
            imageUrl: '',
            deckList: []
        },
        currentUserId: ''
    }

    componentDidMount() {
        this.getSubjectById()
    }

    getSubjectById = async () => {
        try {
            const subjectId = this.props.match.params.subjectId
            const res = await axios.get(`/api/v1/subject/${subjectId}`)
            const newState = {...this.state}
            newState.currentUserId = this.props.location.state.userId
            newState.subject = res.data
            this.setState(newState)
        } catch (e) {
            console.log("failed to get single subject")
            console.error(e)
        }
    }

    handleChange = (evt) => {
        const newState = {...this.state}
        newState.subject[evt.target.name] = evt.target.value
        this.setState(newState)
    }

    onSubmit = async (evt) => {
        evt.preventDefault()
        try {
            await axios.put('/api/v1/subject/editSubject', this.state.subject)
            console.log("edited subject")
        } catch (e) {
            console.log("failed to edit subject")
            console.error(e)
        }
    }

    render() {
        return (
            <div>
                <img className="subject-img" src={this.state.subject.imageUrl}/>
                <div className="title">{this.state.subject.name}</div>
                {/*<div>{this.state.subject.deckList.map()}</div>*/}

                <div>
                    <form onSubmit={this.onSubmit}>
                        <label>Subject Name</label>
                        <input
                            type='text'
                            name='name'
                            onChange={this.handleChange}
                            value={this.state.subject.name}
                        />
                        <label>Image URL</label>
                        <input
                            type='text'
                            name='imageUrl'
                            onChange={this.handleChange}
                            value={this.state.subject.imageUrl}
                        />
                        <input type="submit" value="Save"/>
                    </form>
                </div>
                <AllDecksBySubjectId
                    subjectId={this.props.match.params.subjectId}
                    userId={this.state.currentUserId}
                />
            </div>
        );
    }
}

export default SingleSubject;