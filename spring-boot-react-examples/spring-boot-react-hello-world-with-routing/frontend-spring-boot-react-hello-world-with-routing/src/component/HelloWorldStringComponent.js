import React, { Component } from 'react';
import withNavigation from './WithNavigation.jsx'
import HelloWorldService from '../service/HelloWorldService';

class HelloWorldStringComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            welcomeMessage: ''
        }
    }

    componentDidMount() {
        HelloWorldService.executeHelloWorldService()
            .then(response => this.setState({ welcomeMessage: response.data }))
            .catch(this.setState({ welcomeMessage: 'Error Processing Request' }))
    }

    render() {
        return (<>
            <h1>Hello World String Component</h1>
            <div className="container">
                {this.state.welcomeMessage}
            </div>
            <div className="row">
                <button className="btn btn-success" onClick={this.gotoBeanComponent}>Go</button>
            </div>
        </>
        )
    }

    gotoBeanComponent = () => {
        this.props.navigate(`/hello-world-bean`)
    }
}

export default withNavigation(HelloWorldStringComponent)