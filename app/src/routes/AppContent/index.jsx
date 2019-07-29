import React, { Component } from 'react';
import { Route, Switch, Redirect } from 'react-router-dom';
import { connect } from 'react-redux';

import { TabBar, NavBar } from 'antd-mobile';
import Apply from '../../components/Apply';
import Power from '../../components/Power';
import Me from '../../components/Me';

import styles from './index.less';
import powerIcon from './power.svg';
import powerActiveIcon from './power-active.svg';
import applyIcon from './apply.svg';
import applyActiveIcon from './apply-active.svg';
import meIcon from './me.svg';
import meActiveIcon from './me-active.svg';

class AppContent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      selectedTab: 'me'
    };
  }

  render() {
    const navConfig = [
      {
        title: '电力使用',
        key: 'power',
        route: 'power',
        component: Power,
        nav: true,
        icon: powerIcon,
        activeIcon: powerActiveIcon
      },
      {
        title: '报修外出',
        key: 'apply',
        route: 'apply',
        component: Apply,
        nav: false,
        icon: applyIcon,
        activeIcon: applyActiveIcon
      },
      {
        title: '我',
        key: 'me',
        route: 'me',
        component: Me,
        nav: true,
        icon: meIcon,
        activeIcon: meActiveIcon
      }
    ];
    const { pathname } = this.props.location;
    const { url: matchUrl } = this.props.match;
    const matchNavObj = navConfig.find(v => pathname === `${matchUrl}/${v.key}`);
    return (
      <div>
        <NavBar mode="dark" style={{ display: matchNavObj && matchNavObj.nav ? '' : 'none' }}>
          {matchNavObj && matchNavObj.title}
        </NavBar>
        <Switch>
          {navConfig.map(v => <Route key={v.key} path={`${this.props.match.url}/${v.route}`} component={v.component} />)}
          <Redirect to={`${this.props.match.url}/me`} />
        </Switch>
        <div className={styles.tabBarContainer}>
          <TabBar unselectedTintColor="#949494" tintColor="#33A3F4" barTintColor="white" hidden={!matchNavObj}>
            {navConfig.map(v => (
              <TabBar.Item
                style={{ transition: '.4s' }}
                title={v.title}
                key={v.key}
                icon={{ uri: v.icon }}
                selectedIcon={{ uri: v.activeIcon }}
                selected={pathname === `${matchUrl}/${v.key}`}
                onPress={() => {
                  this.props.history.replace(`${matchUrl}/${v.key}`);
                }}
              />
            ))}
          </TabBar>
        </div>
      </div>
    );
  }
}
const mapStateToProps = state => ({});
const mapDispatchToProps = {};
export default connect(mapStateToProps, mapDispatchToProps)(AppContent);
