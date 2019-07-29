import React, { Component } from 'react';
import { connect } from 'react-redux';
import { WhiteSpace, WingBlank, List, InputItem, Button, Toast } from 'antd-mobile';
import { createForm } from 'rc-form';

import Logo from '../../components/Logo';
import { login } from '../../actions/user';

class Login extends Component {
  componentDidMount() {
  }
  handleSubmit = () => {
    this.props.form.validateFields((err, value) => {
      if (!err) {
        console.log(value);
        this.props.login(value, () => {
          this.props.history.replace('/app');
        });
      } else {
        console.log(err);
      }
    });
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
        <Logo />
        <List>
          <InputItem
            {...getFieldProps('studentUsername', {
              rules: [
                {
                  required: true,
                  message: '请输入你的学号！'
                }
              ]
            })}
            placeholder="你的学号"
            error={getFieldError('studentUsername')}
            onErrorClick={() => this.onClickErr('studentUsername')}
            clear
          >
            学号
          </InputItem>
          <InputItem
            {...getFieldProps('studentPassword', {
              rules: [
                {
                  required: true,
                  message: '请输入你的密码！'
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
        </List>
        <WingBlank>
          <WhiteSpace />
          <Button type="primary" onClick={this.handleSubmit}>
            登录
          </Button>
        </WingBlank>
      </div>
    );
  }
}

const mapStateToProps = state => ({});
const mapDispatchToProps = {
  login
};

export default connect(mapStateToProps, mapDispatchToProps)(createForm()(Login));
