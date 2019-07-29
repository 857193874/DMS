import React, { Component } from 'react';

import { Accordion, List } from 'antd-mobile';
import styles from './index.less'
class OutList extends Component {
  render() {
    return (
      <div className={styles.outList}>
        <Accordion accordion defaultActiveKey="0" onChange={this.onChange}>
          {this.props.data.map(v => (
            <Accordion.Panel key={v.outId} header={`外出申请记录-${v.outId}`}>
              <List className="my-list">
                <List.Item extra={v.outId}>外出ID</List.Item>
                <List.Item extra={new Date(Date.parse(v.outDate)).toLocaleString()}>外出时间</List.Item>
                <List.Item extra={v.outRemark}>状态</List.Item>
              </List>
            </Accordion.Panel>
          ))}
        </Accordion>
      </div>
    );
  }
}

export default OutList;
