import React, { Component } from 'react';
import { connect } from 'react-redux';
import { WhiteSpace, WingBlank, List, InputItem, Button, Toast, NavBar, Icon } from 'antd-mobile';
import { createForm } from 'rc-form';

import { editUserInfo } from '../../actions/user';

class EditUserInfo extends Component {
  constructor(props) {
    super(props);
    this.handleRegister = this.handleRegister.bind(this);
  }
  goBack = () => {
    this.props.history.goBack();
  };
  handleRegister() {
    this.props.form.validateFields((err, value) => {
      if (!err) {
        let postObj = {
          ...value,
          studentUsername: this.props.user.studentUsername
        };
        delete postObj.confirm;
        console.log(postObj);
        this.props.editUserInfo(postObj, () => {
          this.props.history.replace('/app');
          Toast.success('修改成功', 1);
        });
      } else {
        console.log(err);
      }
    });
  }
  checkPassword = (rule, value, callback) => {
    if (!value) {
      callback('请输入密码');
    } else {
      if (value.length < 6) {
        callback('你设定的密码长度要大于6位');
      } else {
        const { form } = this.props;
        if (value) {
          form.validateFields(['confirm'], { force: true });
        }
        callback();
      }
    }
  };
  checkConfirm = (rule, value, callback) => {
    const { form } = this.props;
    if (value && value !== form.getFieldValue('studentPassword')) {
      callback('两次输入的密码不匹配!');
    } else {
      callback();
    }
  };
  onClickErr = key => {
    const { getFieldError } = this.props.form;
    let errors = getFieldError(key);
    Toast.fail(errors[0], 1);
  };
  render() {
    const { getFieldProps, getFieldError } = this.props.form;
    return (
      <div>
        <NavBar mode="dark" icon={<Icon type="left" />} onLeftClick={this.goBack}>
          修改个人信息
        </NavBar>
        <List renderHeader={() => '基本信息'}>
          <InputItem
            {...getFieldProps('studentPassword', {
              validateTrigger: 'onBlur',
              rules: [
                {
                  validator: this.checkPassword
                }
              ]
            })}
            type="password"
            placeholder="****"
            error={getFieldError('studentPassword')}
            onErrorClick={() => this.onClickErr('studentPassword')}
            clear
          >
            密码
          </InputItem>
          <InputItem
            {...getFieldProps('confirm', {
              rules: [
                {
                  required: true,
                  message: '请确认密码！'
                },
                {
                  validator: this.checkConfirm
                }
              ]
            })}
            type="password"
            placeholder="****"
            error={getFieldError('confirm')}
            onErrorClick={() => this.onClickErr('confirm')}
            clear
          >
            确认密码
          </InputItem>
        </List>
        <WingBlank>
          <WhiteSpace />
          <Button type="primary" onClick={this.handleRegister}>
            提交修改
          </Button>
        </WingBlank>
      </div>
    );
  }
}

const mapStateToProps = state => ({
  user: state.user
});

const mapDispatchToProps = {
  editUserInfo
};
export default connect(mapStateToProps, mapDispatchToProps)(createForm()(EditUserInfo));
