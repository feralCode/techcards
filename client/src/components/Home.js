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
                    <div className="ace">Ready to get started?</div>
                    {/*TODO: add links*/}
                    <div className="sign-up-greeting">Sign up or browse as a guest</div>

                    <div className="home-button-group">
                        <div className="home-button">
                            <Link to={"/user/newUser"}>
                                <Button variant="dark">Sign Up</Button>
                            </Link>
                        </div>

                        <div className="home-button">
                            <Link to={"/browse/subjects"}>
                                <Button variant="outline-dark">Browse</Button>
                            </Link>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Home;