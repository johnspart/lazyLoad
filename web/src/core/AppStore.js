import {createStore, applyMiddleware} from 'redux';
import {routerMiddleware} from 'react-router-redux';
import {composeWithDevTools} from 'redux-devtools-extension/developmentOnly';
import {hashHistory} from 'react-router';
import thunk from 'redux-thunk';

import reducers from './CombineReducers';

const routers = routerMiddleware(hashHistory);

export default createStore(reducers, composeWithDevTools(applyMiddleware(thunk, routers)));
