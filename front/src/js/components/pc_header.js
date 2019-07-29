import React, { Component } from 'react';
import {Row,Col,Input} from 'antd';
import mylogo from '../../images/logot.png';

const Search = Input.Search;
class PCHeader extends Component {
    render() {
      return (
        <header style={{ background: '#fff', padding: 0}}>
            <Row gutter={8}>
              <Col span={1}></Col>
              <Col span={4}>
                <a href='/' className="logo">
                  <img src={mylogo} alt="logo"/>
                  <span>Dormitory&nbsp;Management&nbsp;System</span>
                </a>
              </Col>
              
              <Col span={12}></Col>
              <Col span={6}>
      
              </Col>
           
              <Col span={1}></Col>
            </Row>
        </header>
      );
    }
  }
  
  export default PCHeader;