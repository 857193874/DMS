import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Switch, Route, Redirect, withRouter } from 'react-router-dom';

import Login from './routes/Login';
import AppContent from './routes/AppContent';
import AuthRoute from './components/AuthRoute';
import EditUserInfo from './routes/EditUserInfo';

import { add as addVisitNum } from './actions/other';

import styles from './App.less';

class App extends Component {
  componentDidMount() {
    console.log('did mount');
    this.props.addVisitNum();
    this.props.history.replace('/app');
  }
  render() {
    console.log(this.props.location.key);
    return (
      <div className={styles.app}>
        <Switch location={this.props.location}>
          <Route path="/login" component={Login} />
          <AuthRoute path="/app" component={AppContent} />
          <AuthRoute path="/editUserInfo" component={EditUserInfo} />
          <Redirect to="/login" />
        </Switch>
      </div>
    );
  }
}

const mapStateToProps = state => ({});

const mapDispatchToProps = {
  addVisitNum
};

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(App));
