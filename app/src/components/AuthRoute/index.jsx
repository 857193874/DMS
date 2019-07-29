import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Route, withRouter } from 'react-router-dom';

import { checkUser } from '../../actions/user';

class AuthRoute extends Component {
  componentWillMount() {
    this.props.checkUser(() => {
     // alert("1");
      this.props.history.replace('/login');
    //  alert("2");
    });
  }
  render() {
    const { component: Component, ...rest } = this.props;
    return <Route {...rest} render={props => <Component {...props} />} />;
  }
}

const mapStateToProps = state => ({
  user: state.user
});

const mapDispatchToProps = {
  checkUser
};

export default connect(mapStateToProps, mapDispatchToProps)(withRouter(AuthRoute));
