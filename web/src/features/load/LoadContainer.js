import React from 'react';
import {reduxForm} from 'redux-form'
import {connect} from 'react-redux';
import {push} from 'react-router-redux';
import {Link} from 'react-router';
import {Tabs, Tab} from 'material-ui/Tabs';
import Paper from 'material-ui/Paper';

const mapStateToProps = state => ({});
const mapDispatchToProps = dispatch => ({});

const LazyLoadContainer = props => {
    return (
        <Paper style={{
            padding: "25px",
            height: "89vh"
        }}>
            <center>
                <h3>Lazy Load</h3>
            </center>
            <div className="contenForm" style={{
                width: "520px",
                marginLeft: "auto",
                marginRight: "auto"
            }}>
                <Tabs>
                    <Tab label="Cargar"/>
                </Tabs>
                <div>
                    {React.cloneElement(props.children, props)}
                </div>
            </div>
        </Paper>
    )
}

export default connect(mapStateToProps, mapDispatchToProps)(LazyLoadContainer);
