import React, { Component } from 'react';
import { Layout } from 'antd';
const {Footer} = Layout;
class MobileFooter extends Component {
    render() {
      return (
        <Footer style={{ textAlign: 'center' }}>
        D M S @2018 Created by MoYu.
        </Footer>
      );
    }
  }
  
  export default MobileFooter;