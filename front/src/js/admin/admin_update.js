import React, { Component } from "react";
import { Layout, Breadcrumb } from "antd";
import {
  notification,
  Form,
  Row,
  Button,
  Icon,
  Modal,
  InputNumber,
  Input,
  Col,
  Select,
  DatePicker,
  AutoComplete,
  Cascader
} from "antd";
import { Table } from "antd";
import reqwest from "reqwest";
const InputGroup = Input.Group;
const { TextArea } = Input;
const Option = Select.Option;
const confirm = Modal.confirm;
const { Content } = Layout;
const ButtonGroup = Button.Group;
const createForm = Form.create;
const FormItem = Form.Item;

const openNotificationWithIcon = type => {
  notification[type]({
    message: "修改成功！",
    description: "该信息已成功修改"
  });
};

const openNotificationWithIconError = type => {
  notification[type]({
    message: "修改失败！",
    description: "请检查数据是否完整"
  });
};

function onChange(value) {}

class AdminUpdate extends Component {
  constructor(props) {
    super(props);

    this.state = { value: "" };
  }
  onChange = value => {
    this.setState({ value });
  };
  state = {
    loading: false,
    visible: false
  };
  showModal = () => {
    reqwest({
      url: "http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/admin/query/" + this.props.adminId,
      method: "get",
      data: {},
      type: "json",
      error: function(err) {},
      success: function(data) {}
    }).then(data => {
      this.setState({
        data: data.data.admin,
        visible: true
      });
    
    });
  };

  updateAdmin = e => {
    e.preventDefault();
    this.props.form.validateFields((err, values) => {
      if (!err) {
        reqwest({
          url: "http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/admin/update/"+ this.props.adminId,
          method: "post",
          data: {
            ...this.props.form.getFieldsValue()
          },
          type: "json",
          error: function(err) {
            openNotificationWithIconError("error");
          },
          success: function(data) {
            openNotificationWithIcon("success");
          }
        }).then(data => {
          this.props.fetch();
        });
        this.hideModal();
      }
    });
  };

  hideModal = () => {
    this.setState({
      visible: false
    });
  };
  getInitialState() {
    return { visible: false };
  }
  getdomid = () => {};

  componentWillMount(nextProps) {}

  render() {
    const { getFieldDecorator } = this.props.form;

    const formItemLayout = {
      labelCol: { span: 4 },
      wrapperCol: { span: 20 }
    };

    return (
      <div style={{ display: "inline-block" }}>
           <Button type="primary" icon="edit" onClick={this.showModal}/>

        <Modal
          title="修改"
          visible={this.state.visible}
          onOk={this.updateAdmin}
          onCancel={this.hideModal}
          okText="确认"
          cancelText="取消"
        >
          <Form horizontal form={this.props.form}>
            <FormItem {...formItemLayout} label=" 管理员ID">
              {getFieldDecorator("adminId", {
                initialValue: this.state.data ? this.state.data.adminId : "",
                rules: [{ required: true, message: "用户名不可为空!" }]
              })(
                <Input
                  autoComplete="off"
                  style={{ width: 90 }}
                  value={this.state.value}
                  onChange={this.onChange}
                  disabled
                />
              )}
            </FormItem>
            <FormItem {...formItemLayout} label="用户名">
              {getFieldDecorator("adminUsername", {
                initialValue: this.state.data
                  ? this.state.data.adminUsername
                  : "",
                rules: [{ required: true, message: "别忘了你的账户" }]
              })(<Input autoComplete="off" style={{ width: 120 }} />)}
            </FormItem>

            <FormItem {...formItemLayout} label=" 密码">
              {getFieldDecorator("adminPassword", {
                initialValue: this.state.data
                  ? this.state.data.adminPassword
                  : "",
                rules: [{ required: true, message: "没有凭证怎么行？" }]
              })(
                <Input autoComplete="off" style={{ width: 120 }} />
              )}
            </FormItem>
            <FormItem {...formItemLayout} label=" 姓名">
              {getFieldDecorator("adminName", {
                initialValue: this.state.data
                  ? this.state.data.adminName
                  : "",
                rules: [{ required: true, message: "到此一游留个名吧" }]
              })(
                <Input autoComplete="off" style={{ width: 120 }} />
              )}
            </FormItem>
            <FormItem {...formItemLayout} label=" 性别">
              {getFieldDecorator("adminSex", {
                initialValue: this.state.data
                  ? this.state.data.adminSex
                  : "",
                rules: [{ required: true, message: "是男是女" }]
              })(
                <Select   autoComplete="off" style={{ width: 60 }}>
                  <Option value="男">男</Option>
                  <Option value="女">女</Option>
                </Select>
              )}
            </FormItem>
            <FormItem {...formItemLayout} label=" 联系方式">
              {getFieldDecorator("adminTel", {
                initialValue: this.state.data
                  ? this.state.data.adminTel
                  : "",
                rules: [{ required: true, message: "留下电话再走！" }]
              })(
                <Input autoComplete="off" style={{ width: 120 }} />
              )}
            </FormItem>
          </Form>
        </Modal>
      </div>
    );
  }
}
AdminUpdate = createForm()(AdminUpdate);

export default AdminUpdate;
