import React from 'react';
import {render} from 'react-dom';
import {Provider} from 'react-redux';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import appStore from './core/AppStore';
import types from './core/ActionTypes';
import MainContainer from './features/main/MainContainer';


render(
  <Provider store={appStore}>
  <MuiThemeProvider >
    <MainContainer/>
  </MuiThemeProvider>
</Provider>, document.getElementById('root'));
