import React, {Component} from 'react';
import {connect} from 'react-redux';
import {push} from 'react-router-redux';
import {Router, Route, hashHistory, Link} from 'react-router';

// components by features
import LazyLoadContainer from '../load/LoadContainer';
import LazyLoadForm from '../load/LoadComponent';

import {AppContent} from './MainComponent';

// actions
import actions from './MainUiActions';

const mapStateToProps = state => ({});

const MainContainer = props => <Router history={hashHistory}>
    <Route component={AppContent}>
        <Route component={LazyLoadContainer}>
            <Route component={LazyLoadForm} path="/"/>
        </Route>
    </Route>
</Router>;

export default connect(mapStateToProps, actions)(MainContainer);
