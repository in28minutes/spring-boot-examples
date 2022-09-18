import React, { Component } from 'react';
import withNavigation from './WithNavigation.jsx'
import HelloWorldService from '../service/HelloWorldService';

class HelloWorldBeanComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            welcomeMessage: ''
        }
    }

    componentDidMount() {
        HelloWorldService.executeHelloWorldBeanService()
            .then(response => this.setState({ welcomeMessage: response.data.message }))
            .catch(this.setState({ welcomeMessage: 'Error Processing Request' }))
    }

    render() {
        return (<>
            <h1>Hello World String Component</h1>
            <div className="container">
                {this.state.welcomeMessage}
            </div>
            <div className="row">
                <button className="btn btn-success" onClick={this.gotoStringComponent}>Go Back</button>
            </div>
        </>
        )
    }

    gotoStringComponent = () => {
        this.props.navigate(`/hello-world-string`)
    }
}

export default withNavigation(HelloWorldBeanComponent)