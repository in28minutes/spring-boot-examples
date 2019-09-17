import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import MenuComponent from './MenuComponent'
import HelloWorldBeanComponent from './HelloWorldBeanComponent';
import HelloWorldStringComponent from './HelloWorldStringComponent';

class HelloWorldApp extends Component {
    render() {
        return (
            <>
                <Router>
                    <>
                        <MenuComponent />
                        <div className="container">
                            <Switch>
                                <Route path="/" exact component={HelloWorldStringComponent} />
                                <Route path="/hello-world-string" component={HelloWorldStringComponent} />
                                <Route path="/hello-world-bean" component={HelloWorldBeanComponent} />
                            </Switch>
                        </div>
                    </>
                </Router>
            </>
        )
    }
}

export default HelloWorldApp;