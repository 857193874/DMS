import React, { Component } from 'react';
import {Row,Col} from 'antd';
import mylogo from '../../../images/logot.png';
class MobileHeader extends Component {
    render() {
      return (
        <header style={{ background: '#fff', padding: 0 }}>
        <Row>
          <Col span={1}></Col>
          <Col span={4}>
            <a href='/' className="logo">
              <img src={mylogo} alt="logo"/>
              <span>D&nbsp;M&nbsp;S</span>
            </a>
          </Col>
          <Col span={2}></Col>
        </Row>
    </header>
      );
    }
  }
  
  export default MobileHeader;