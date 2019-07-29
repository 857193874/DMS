import React, { Component } from 'react';
import { connect } from 'react-redux';

import { SegmentedControl, WhiteSpace, WingBlank, NavBar, Modal, DatePicker, List } from 'antd-mobile';
import MaintainList from '../MaintainList';
import OutList from '../OutList';
import ApplyPopver from './ApplyPopver';

import { fetchMaintainList, fetchOutList, maintain, out } from '../../actions/apply';
import styles from './index.less';

const alert = Modal.alert;

function closest(el, selector) {
  const matchesSelector = el.matches || el.webkitMatchesSelector || el.mozMatchesSelector || el.msMatchesSelector;
  while (el) {
    if (matchesSelector.call(el, selector)) {
      return el;
    }
    el = el.parentElement;
  }
  return null;
}

class Apply extends Component {
  state = {
    selectedIndex: 0,
    init: false,
    visible: false,
    date: new Date(),
    popVisiable: false
  };
  asyncComponentDidMount = async () => {
    if (this.props.user.domitoryId !== undefined && this.props.user.studentUsername !== undefined) {
      await this.setState({
        init: true
      });
      await this.props.fetchMaintainList({ domitoryId: this.props.user.domitoryId });
      await this.props.fetchOutList({ studentUsername: this.props.user.studentUsername });
    }
  };
  handleRouteChange = e => {
    this.setState({
      selectedIndex: e.nativeEvent.selectedSegmentIndex,
      modalVisible: false
    });
  };
  handleSelect = v => {
    switch (v.props.value) {
      case '报修':
        alert('报修', '你确定要进行报修么?', [
          { text: '取消', onPress: () => console.log('cancel') },
          {
            text: '确定',
            onPress: () => {
              this.props.maintain({ domitoryId: this.props.user.domitoryId }, async () => {
                await this.asyncComponentDidMount();
                await this.setState({
                  selectedIndex: 0
                });
              });
            }
          }
        ]);
        break;
      case '申请外出':
        this.setState({
          outModal: true
        });
        break;
      default:
        console.log('err');
    }
    console.log(v.props.value);
    this.setState({
      visible: false
    });
  };
  onClose = key => () => {
    this.setState({
      [key]: false
    });
  };
  onWrapTouchStart = e => {
    // fix touch to scroll background page on iOS
    if (!/iPhone|iPod|iPad/i.test(navigator.userAgent)) {
      return;
    }
    const pNode = closest(e.target, '.am-modal-content');
    if (!pNode) {
      e.preventDefault();
    }
  };
  render() {
    if (!this.state.init) {
      console.log('init');
      this.asyncComponentDidMount();
    }
    return (
      <div className="apply">
        <Modal
          visible={this.state.outModal}
          transparent
          maskClosable={false}
          onClose={this.onClose('outModal')}
          title="申请外出"
          footer={[
            {
              text: '取消',
              onPress: () => {
                this.onClose('outModal')();
              }
            },
            {
              text: '确定',
              onPress: () => {
                this.props.out({ outStudentid: this.props.user.studentUsername, outDate: this.state.date }, async () => {
                  await this.asyncComponentDidMount();
                  await this.setState({
                    selectedIndex: 1
                  });
                });
                this.onClose('outModal')();
              }
            }
          ]}
          wrapProps={{ onTouchStart: this.onWrapTouchStart }}
          className={styles.outModal}
        >
          <div className={styles.datePickers}>
            <h4>请填写你要外出的日期和时间</h4>
            <DatePicker mode="datetime" title="选择日期" extra="请选择" value={this.state.date} onChange={date => this.setState({ date })} minDate={new Date()}>
              <List.Item arrow="horizontal">日期</List.Item>
            </DatePicker>
          </div>
        </Modal>

        <NavBar mode="dark" rightContent={<ApplyPopver onSelect={this.handleSelect} visible={this.state.popVisiable} />}>
          报修外出
        </NavBar>
        <WhiteSpace />
        <WingBlank>
          <SegmentedControl values={['报修', '外出']} selectedIndex={this.state.selectedIndex} onChange={this.handleRouteChange} style={{ height: '30px' }} />
          <WhiteSpace />
          {this.state.selectedIndex === 0 ? <MaintainList data={this.props.apply.maintainList} /> : <OutList data={this.props.apply.outList} />}
        </WingBlank>
      </div>
    );
  }
}

const mapStateToProps = state => ({
  user: state.user,
  apply: state.apply
});

const mapDispatchToProps = {
  fetchMaintainList,
  fetchOutList,
  maintain,
  out
};

export default connect(mapStateToProps, mapDispatchToProps)(Apply);
