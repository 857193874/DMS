import React, { Component } from 'react';
import { Layout, Breadcrumb} from 'antd';
const {Content } = Layout;
class MobileBody extends Component {
    render() {
      return (
        <Content style={{ margin: '0 16px' }}>
        <Breadcrumb style={{ margin: '16px 0' }}>
          <Breadcrumb.Item>DMS</Breadcrumb.Item>
          <Breadcrumb.Item>ADMIN</Breadcrumb.Item>
        </Breadcrumb>
        <div style={{ padding: 24, background: '#fff', minHeight: 360 }}>
         Mobile style
        </div>
      </Content>
      );
    }
  }
  
  export default MobileBody;