import React, { Component } from 'react';
import ListCoursesComponent from './ListCoursesComponent';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'
import CourseComponent from './CourseComponent';
import withParams from './WithParams.jsx'

class InstructorApp extends Component {
    render() {
        const CourseComponentWithParams = withParams(CourseComponent);
        return (
            <Router>
                <>
                    <h1>Instructor Application</h1>
                    <Routes>
                        <Route path="/" element={<ListCoursesComponent />} />
                        <Route path="/courses" element={<ListCoursesComponent />} />
                        <Route path="/courses/:id" element={<CourseComponentWithParams />} />
                    </Routes>
                </>
            </Router>
        )
    }
}

export default InstructorApp