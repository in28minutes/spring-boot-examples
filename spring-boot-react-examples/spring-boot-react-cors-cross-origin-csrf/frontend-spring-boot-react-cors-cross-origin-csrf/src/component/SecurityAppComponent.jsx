import React, { Component } from 'react';
import ListCoursesComponent from './ListCoursesComponent';

class SecurityApp extends Component {

    render() {
        return (
            <>
                <h1>CORS (CROSS ORIGIN) - PRE FLIGHT Requests</h1>
                <div className="container">
                    <ListCoursesComponent />
                </div>
            </>
        );
    }
}

export default SecurityApp