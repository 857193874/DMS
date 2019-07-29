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
const Option = Select.Option;
const confirm = Modal.confirm;
const { Content } = Layout;
const ButtonGroup = Button.Group;
const createForm = Form.create;
const FormItem = Form.Item;
let domIdData = [1];
const openNotificationWithIcon = type => {
  notification[type]({
    message: "添加成功！",
    description: "该信息已成功添加"
  });
};

const openNotificationWithIconError = type => {
  notification[type]({
    message: "添加失败！",
    description: "请检查数据是否完整,若问题未解决请联系后台管理员"
  });
};

function onChange(value) {
  //console.log('changed', value);
}

class MaintainCreate extends Component {
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
      url:
        "http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/domitory/query/domitoryId", //http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/student/query/all
      method: "get",
      type: "json"
    }).then(data => {
      domIdData = data.data.domitoryids;
      //console.log("selectdomitoryId");

      this.setState({
        visible: true
      });
    });
  };

  addMaintain = e => {
    e.preventDefault();
    this.props.form.validateFields((err, values) => {
      if (!err) {
        //console.log('数据正确 ', values);
        //console.log('addStudnet');
        //console.log(this.props.form.getFieldsValue().studentSex==undefined);
        reqwest({
          url: "http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/maintain/save", //http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/student/query/all
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
            //console.log(data)
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
  getdomid = () => {
    //console.log("asdfasdf");
  };

  componentWillMount(nextProps) {}

  render() {
    //console.log("getdomid");

    let IdOptions = domIdData.map(domitoryId => (
      <Option key={domitoryId}>{domitoryId}</Option>
    ));

    const { getFieldDecorator } = this.props.form;

    const formItemLayout = {
      labelCol: { span: 4 },
      wrapperCol: { span: 20 }
    };

    return (
      <div style={{ display: "inline-block" }}>
        <Button
          type="primary"
          icon="plus"
          onClick={this.showModal}
          value="large"
        >
          新增
        </Button>

        <Modal
          title="新增"
          visible={this.state.visible}
          onOk={this.addMaintain}
          onCancel={this.hideModal}
          okText="确认"
          cancelText="取消"
        >
          <Form horizontal form={this.props.form}>
            <FormItem {...formItemLayout} label="宿舍号">
              {getFieldDecorator("domitoryId", {
                initialValue: 1,
                rules: [{ required: true, message: "哪个宿舍要修理？" }]
              })(
                <Select style={{ width: 90 }} autoComplete="off">
                  {IdOptions}
                </Select>
              )}
            </FormItem>

            <FormItem {...formItemLayout} label="报修时间">
              {getFieldDecorator("maintainTime", {
                rules: [{ required: true, message: "神码时候？" }]
              })(<DatePicker autoComplete="off" showTime="true" />)}
            </FormItem>

     

            <FormItem {...formItemLayout} label="状态">
              {getFieldDecorator("status", {
                initialValue: "保修",
                rules: [{ required: true, message: "现在是什么状态？" }]
              })(
                <Select autoComplete="off" style={{ width: 120 }}>
                  <Option value="保修">保修</Option>
                  <Option value="维修中">维修中</Option>
                  <Option value="已解决">已解决</Option>
                </Select>
              )}
            </FormItem>
          </Form>
        </Modal>
      </div>
    );
  }
}
MaintainCreate = createForm()(MaintainCreate);

export default MaintainCreate;
