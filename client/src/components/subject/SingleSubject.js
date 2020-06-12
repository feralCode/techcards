import React, {Component} from 'react';
import axios from 'axios'
import AllDecksBySubjectId from "../deck/AllDecksBySubjectId";
import Button from "react-bootstrap/Button";

class SingleSubject extends Component {

    state = {
        subject: {
            name: '',
            imageUrl: '',
            deckList: []
        },
        showEditForm: false
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
                            <label className="form-label">Subject Name</label>
                            <input
                                type='text'
                                name='name'
                                className="form-input"
                                onChange={this.handleChange}
                                value={this.state.subject.name}
                            />
                            <label className="form-label">Image URL</label>
                            <input
                                type='text'
                                name='imageUrl'
                                className="form-input"
                                onChange={this.handleChange}
                                value={this.state.subject.imageUrl}
                            />
                            <input type="submit" value="Save"/>
                            <Button variant="outline-dark" className="back-button" onClick={this.toggleEditForm} >
                                Back
                            </Button>
                        </form>
                    </div>
                :
                    <div>
                        <img className="subject-img" src={this.state.subject.imageUrl}/>
                        <div className="title">{this.state.subject.name}</div>
                        {/*<div>{this.state.subject.deckList.map()}</div>*/}

                        <AllDecksBySubjectId
                            subjectId={this.props.match.params.subjectId}
                            userId={this.props.userId}
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

export default SingleSubject;