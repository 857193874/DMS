import React, { Component } from 'react';

import { Layout } from 'antd';
import PCHeader from './pc_header';
import LeftSider from './leftsider';
import PCFooter from './pc_footer';
import PCBody from './pc_body';


class PCIndex extends Component {
  constructor(props) {
    super(props);
    this.state = {
      tabValue: ''
    }

  }
  getTabValue(v) {
    this.setState({
      tabValue: v
    })
  }

  render() {
    return (
      <Layout style={{ minHeight: '100vh' }}>
        <LeftSider getTabValue={this.getTabValue.bind(this)}/>
        <Layout>
          <PCHeader />
          <PCBody tabValue={this.state.tabValue}/>
          <PCFooter/>
        </Layout>
      </Layout>
    );
  }
}

export default PCIndex;
