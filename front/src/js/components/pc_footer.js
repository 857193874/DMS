import React, { Component } from 'react';
import { Layout } from 'antd';
const {Footer} = Layout;
class PCFooter extends Component {
    render() {
      return (
        <Footer style={{ textAlign: 'center' }}>
        Dormitory Management System @2018 Created by MoYu.
        </Footer>
      );
    }
  }
  
  export default PCFooter;