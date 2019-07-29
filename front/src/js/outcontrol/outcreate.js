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
const { MonthPicker, RangePicker, WeekPicker } = DatePicker;
let studentnames = [1];
const openNotificationWithIcon = type => {
  notification[type]({
    message: "添加成功！",
    description: "该信息已成功添加"
  });
};

const openNotificationWithIconError = type => {
  notification[type]({
    message: "添加失败！",
    description: "请检查数据是否完整,若仍存在问题请联系管理员"
  });
};

function onChange(value) {
  //console.log("changed", value);
}

class OutCreate extends Component {
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
        "http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/student/query/all/StudentUsername",
      method: "get",
      type: "json"
    }).then(data => {
      studentnames = data.data.studentUsername;
      //console.log("selectstudentUsername");
      this.setState({
        visible: true
      });
    });
  };

  addOut = e => {
    e.preventDefault();
    this.props.form.validateFields((err, values) => {
      if (!err) {
        //console.log("数据正确 ", values);
        reqwest({
          url: "http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/out/save",
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
            //console.log(data);
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
    let IdOptions = studentnames.map(outStudentid => (
      <Option key={outStudentid}>{outStudentid}</Option>
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
          onOk={this.addOut}
          onCancel={this.hideModal}
          okText="确认"
          cancelText="取消"
        >
          <Form horizontal form={this.props.form}>
            <FormItem {...formItemLayout} label="学生ID">
              {getFieldDecorator("outStudentid", {
                initialValue: studentnames[0],
                rules: [{ required: true, message: "？？？？没人？" }]
              })(
                <Select style={{ width: 160 }} autoComplete="off">
                  {IdOptions}
                </Select>
              )}
            </FormItem>

            <FormItem {...formItemLayout} label=" 外出时间">
              {getFieldDecorator("outDate", {
                rules: [{ required: true, message: "话总得有个头啊" }]
              })(<DatePicker autoComplete="off" showTime="true" />)}
            </FormItem>

     

            <FormItem {...formItemLayout} label="意见">
              {getFieldDecorator("outRemark", {
                initialValue: "同意",
                rules: [{ required: true, message: "你怎么看？" }]
              })(
                <Select autoComplete="off" style={{ width: 120 }}>
                  <Option value="同意">同意</Option>
                  <Option value="拒绝">拒绝</Option>
                </Select>
              )}
            </FormItem>
          </Form>
        </Modal>
      </div>
    );
  }
}
OutCreate = createForm()(OutCreate);

export default OutCreate;
