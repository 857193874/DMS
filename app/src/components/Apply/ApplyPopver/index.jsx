import React, { PureComponent } from 'react';

import { Popover, Icon } from 'antd-mobile';

const Item = Popover.Item;

class ApplyPopver extends PureComponent {
  render() {
    return (
      <div>
        <Popover
          mask
          visible={this.props.visible}
          overlay={[
            <Item key="1" value="报修" icon={<img src={require('../screwdriver.svg')} className="am-icon am-icon-sm" alt="" />}>
              报修
            </Item>,
            <Item key="2" value="申请外出" icon={<img src={require('../run.svg')} className="am-icon am-icon-sm" alt="" />}>
              申请外出
            </Item>
          ]}
          align={{
            overflow: { adjustY: 0, adjustX: 0 },
            offset: [-10, 0]
          }}
          onSelect={this.props.onSelect}
        >
          <div
            style={{
              height: '100%',
              padding: '0 15px',
              marginRight: '-15px',
              display: 'flex',
              alignItems: 'center'
            }}
          >
            <Icon type="ellipsis" />
          </div>
        </Popover>
      </div>
    );
  }
}

export default ApplyPopver;
