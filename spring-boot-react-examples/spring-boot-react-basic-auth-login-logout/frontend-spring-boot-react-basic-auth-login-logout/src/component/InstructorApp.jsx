import React, { Component } from 'react';
import ListCoursesComponent from './ListCoursesComponent';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'
import LoginComponent from './LoginComponent';
import LogoutComponent from './LogoutComponent';
import MenuComponent from './MenuComponent';
import AuthenticatedRoute from './AuthenticatedRoute';
import withNavigation from './WithNavigation.jsx'

class InstructorApp extends Component {
    render() {
        const ListCoursesComponentWithNavigation = withNavigation(ListCoursesComponent);
        const LogOutComponentWithNavigation = withNavigation(LogoutComponent);

        return (
            <>
                <Router>
                    <>
                        <MenuComponent />
                        <Routes>
                            <Route path="/" element={<LoginComponent />} />
                            <Route path="/login" element={<LoginComponent />} />
                            <Route path="/logout" element={
                                <AuthenticatedRoute>
                                    <LogOutComponentWithNavigation />
                                </AuthenticatedRoute>
                            } />

                            <Route path="/courses" element={
                                <AuthenticatedRoute>
                                    <ListCoursesComponentWithNavigation />
                                </AuthenticatedRoute>
                            } />

                        </Routes>
                    </>
                </Router>
            </>
        )
    }
}

export default InstructorApp