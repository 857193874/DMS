import React, { Component } from "react";
import { Layout, Menu, Icon } from "antd";
const { Sider } = Layout;
const SubMenu = Menu.SubMenu;
class LeftSider extends Component {
  state = {
    collapsed: false,
    selectedKeys: ["admin"]
  };
  onCollapse = collapsed => {

    this.setState({ collapsed });
  };
  addselectkey = e => {
  
  };

  render() {
    return (
      <Sider
        collapsible
        collapsed={this.state.collapsed}
        onCollapse={this.onCollapse}
      >
        <div className="logo" />
        <Menu
          theme="dark"
          defaultSelectedKeys={["student"]}
          mode="inline"
          selectedKeys={this.state.selectedKeys}
          onClick={({ item, key, keyPath }) => {
            this.setState({
              selectedKeys: keyPath
            });
            this.props.getTabValue(keyPath[0])
          }}
        >
          <Menu.Item key="admin">
            <Icon type="pie-chart" />
            <span>管理员</span>
          </Menu.Item>
          <Menu.Item key="building">
            <Icon type="tag" />
            <span>宿舍楼</span>
          </Menu.Item>
          <Menu.Item key="student">
            <Icon type="user" />
            <span>学生</span>
          </Menu.Item>
          <Menu.Item key="domitory">
            <Icon type="shop" />
            <span>宿舍</span>
          </Menu.Item>
          <Menu.Item key="out">
            <Icon type="profile" />
            <span>外出信息</span>
          </Menu.Item>
          <Menu.Item key="power">
            <Icon type="line-chart" />
            <span>电力</span>
          </Menu.Item>
          <Menu.Item key="maintain">
            <Icon type="tool" />
            <span>报修</span>
          </Menu.Item>
        </Menu>
      </Sider>
    );
  }
}

export default LeftSider;
