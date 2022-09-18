import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'
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
                            <Routes>
                                <Route path="/" exact element={<HelloWorldStringComponent />} />
                                <Route path="/hello-world-string" element={<HelloWorldStringComponent />} />
                                <Route path="/hello-world-bean" element={<HelloWorldBeanComponent />} />
                            </Routes>
                        </div>
                    </>
                </Router>
            </>
        )
    }
}

export default HelloWorldApp;