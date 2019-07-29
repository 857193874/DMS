import React, { Component } from 'react';

import { Accordion, List } from 'antd-mobile';
import styles from './index.less'

class MaintainList extends Component {
  render() {
    return (
      <div className={styles.maintainList}>
        <Accordion accordion defaultActiveKey="0" onChange={this.onChange}>
          {this.props.data.map(v => (
            <Accordion.Panel key={v.maintainId} header={`报修记录-${v.maintainId}`}>
              <List className="my-list">
                <List.Item extra={v.maintainId}>报修ID</List.Item>
                <List.Item extra={new Date(Date.parse(v.maintainTime)).toLocaleString()}>报修时间</List.Item>
                <List.Item extra={v.status}>状态</List.Item>
              </List>
            </Accordion.Panel>
          ))}
        </Accordion>
      </div>
    );
  }
}

export default MaintainList;
