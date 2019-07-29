import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Modal, List, Toast } from 'antd-mobile';
import browerCookies from 'browser-cookies';

import { logout } from '../../actions/user';
import { fetch as fetchVisitNum } from '../../actions/other';
import styles from './index.less';

import maleIcon from './gender-male.svg';
import femaleIcon from './gender-female.svg';
import penIcon from './pen.svg';
import logoutIcon from './logout.svg';
import userIcon from './account-box.svg';
import visitNumIcon from './trending-up.svg';

const Item = List.Item;
const alert = Modal.alert;

class Me extends Component {
  componentDidMount() {
    this.props.fetchVisitNum();
  }
  logout = () => {
    alert('退出登录', '你确定要退出登录吗？', [
      { text: '取消', onPress: () => console.log('取消退出登录') },
      {
        text: '确定',
        onPress: () => {
          this.props.logout();
          browerCookies.erase('studentUsername');
          this.props.history.replace('/');
        }
      }
    ]);
  };
  editUserInfo = () => {
    this.props.history.push('/editUserInfo');
  };
  showVisitNum = async () => {
    this.props.fetchVisitNum(() => {
      Toast.info(`访问量为 ${this.props.other.visitnum}`, 2, null, false);
    });
  };
  render() {
    const userData = this.props.user;
    return (
      <div className="me">
        <div className={styles.userInfoBorad}>
          <img className={styles.avatar} src={userIcon} alt="" />
          <div className={styles.info}>
            <div className={styles.name}>{userData.studentName}</div>
            <div className={styles.sex}>
              {userData.studentSex === '男' ? <img className="icon" src={maleIcon} alt="male" /> : <img className="icon" src={femaleIcon} alt="female" />}
            </div>
            <div className={styles.sNo}>{userData.studentUsername}</div>
          </div>
        </div>
        <List>
          <Item extra={userData.studentState}>状态</Item>
          <Item extra={userData.studentClass}>班级</Item>
          <Item extra={userData.studentDomitoryid}>宿舍号</Item>
        </List>
        <List renderHeader={() => '操作'}>
          <Item thumb={penIcon} onClick={this.editUserInfo}>
            修改个人信息
          </Item>
          <Item thumb={visitNumIcon} onClick={this.showVisitNum}>
            查看访问量
          </Item>
          <Item thumb={logoutIcon} onClick={this.logout}>
            注销
          </Item>
        </List>
      </div>
    );
  }
}

const mapStateToProps = state => ({
  user: state.user,
  other: state.other
});

const mapDispatchToProps = {
  logout,
  fetchVisitNum
};

export default connect(mapStateToProps, mapDispatchToProps)(Me);
