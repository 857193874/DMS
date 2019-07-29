import React, { Component } from 'react';
import MobileHeader from './mobile_header';
import MobileBody from './mobile_body';
import MobileFooter from './mobile_footer';
import LeftSider from '../leftsider';
import { Layout } from 'antd';
class MobileIndex extends Component {
    render() {
      return (
        <Layout style={{ minHeight: '100vh' }}>
        <LeftSider/>
        <Layout>
         <MobileHeader/>
         <MobileBody/>
         <MobileFooter/>
        </Layout>
      </Layout>
      );
    }
  }
  
  export default MobileIndex;