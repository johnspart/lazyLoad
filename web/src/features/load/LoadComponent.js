import React, {Component} from 'react'
import {reduxForm} from 'redux-form'
import {Field} from 'redux-form'
import {Checkbox, TextField} from 'redux-form-material-ui'
import RaisedButton from 'material-ui/RaisedButton';

import Paper from 'material-ui/Paper';
import {replace} from 'react-router-redux';

import {loadSubmit, validate} from './LoadSubmit'

class LazyLoadForm extends Component {

  constructor(props) {
    super(props);
  }

  render() {
    const {error, handleSubmit, pristine, reset, submitting} = this.props
    return (
      <Paper style={{
        padding: "55px"
      }}>
        {error && <strong>{error}</strong>}
        <form onSubmit={handleSubmit(loadSubmit)}>
          <div>
            <Field name="numeroDocumento" component={TextField} hintText="Número de documento"/>
          </div>
          <div>
            <Field name="file" type="file" component={TextField}/>
          </div>
          <br/>
          <div>
            <RaisedButton disabled={submitting} type="submit" primary={true} label="Cargar"/>
          </div>
        </form>
      </Paper>
    );
  }

  componentDidUpdate() {
    let {submitSucceeded, dispatch} = this.props;
    if (submitSucceeded) {
      dispatch(replace("/"))
    }
  }
}

export default reduxForm({form: 'LazyLoadForm', validate})(LazyLoadForm);
