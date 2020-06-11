import React, {Component} from 'react';
import { Link } from 'react-router-dom'
import Button from "react-bootstrap/Button";

class Home extends Component {

    render() {
        return (
            <div className="home-page">
                <div className="description">
                    <div className="ace">
                        Ace your technical interview with TechCards
                    </div>
                    <div>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                    </div>
                    <ul>
                        <li>Feature 1</li>
                        <li>Feature 2</li>
                        <li>Feature 3</li>
                    </ul>
                </div>
                <div className="get-started">
                    <div>Ready to get started?</div>
                    {/*TODO: add links*/}
                    <div>Sign up or browse as a guest</div>
                    <Button variant="dark">Sign Up</Button>
                    <Link to={"/browse/subjects"}>
                        <Button variant="outline-dark">Browse</Button>
                    </Link>
                </div>
            </div>
        );
    }
}

export default Home;