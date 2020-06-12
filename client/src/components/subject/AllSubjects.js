import React, {Component} from 'react';
import axios from 'axios'
import { Link } from 'react-router-dom'
import NewSubjectForm from "./NewSubjectForm";
import Button from "react-bootstrap/Button";

class AllSubjects extends Component {

    state = {
        allSubjects: [],
        currentSubjectId: '',
        showNewSubjectForm: false,
        currentUserId: ''
    }

    componentDidMount() {
        this.getAllSubjects()
    }

    getAllSubjects = async () => {
        try {
            const res = await axios.get('/api/v1/subject/all')
            const newState = {...this.state}
            newState.currentUserId = this.props.userId
            newState.allSubjects = res.data
            this.setState(newState)
        } catch (e) {
            console.log("failed to get allsubjects")
            console.error(e)
        }
    }

    toggleNewSubjectForm = () => {
        const showNewSubjectForm = !this.state.showNewSubjectForm
        this.setState({ showNewSubjectForm })
    }

    render() {
        return (
            <div className="all-subjects">
                {this.state.showNewSubjectForm
                ?
                    <div>
                        <NewSubjectForm/>
                        <Button variant="outline-dark" onClick={this.toggleNewSubjectForm} >
                            Back to All Subjects
                        </Button>
                    </div>
                :
                    <div>
                        <div className="title">Select a subject to begin studying</div>
                        <div className="subject-list">
                            {this.state.allSubjects.map((subject, index) => {
                                return (
                                    <div key={`t3426gfw7 - ${index}`}>
                                        <div className="subject">
                                            {/*TODO: use subject name instead of id in url... pass id through with props*/}
                                            <Link to={`/subject/${subject.id}`}
                                            //       onClick={() => {
                                            //     const newState = {...this.state}
                                            //     newState.currentSubjectId = subject.id
                                            //     this.setState(newState)
                                            // }}
                                            >
                                                <img className="subject-img" src={subject.imageUrl}/>
                                                <div className="subject-name">{subject.name}</div>
                                                {/*TODO: add deck length to get total decks*/}
                                            </Link>
                                        </div>
                                    </div>
                                    )
                            })}

                            </div>

                        <Button variant="outline-dark" onClick={this.toggleNewSubjectForm} >
                            Add A Subject
                        </Button>
                    </div>
                    }
            </div>
        );
    }
}

export default AllSubjects;