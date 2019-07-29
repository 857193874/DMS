import React, { Component } from 'react';
import { Layout, Breadcrumb} from 'antd';
import { notification,Form, Row,Button, Icon ,Modal, InputNumber, Input  ,Col, Select, DatePicker, AutoComplete, Cascader} from 'antd';
import { Table } from 'antd';
import reqwest from 'reqwest';
const InputGroup = Input.Group;
const { TextArea } = Input;
const Option = Select.Option;
const confirm = Modal.confirm;
const {Content } = Layout;
const ButtonGroup = Button.Group;
const createForm = Form.create;
const FormItem = Form.Item;

const openNotificationWithIcon = (type) => {
    notification[type]({
      message: '添加成功！',
      description: '该信息已成功添加',
    });
  };

  const openNotificationWithIconError = (type) => {
    notification[type]({
      message: '添加失败！',
      description: '请检查数据是否完整',
    });
  };

  function onChange(value) {
    
  }
  
class AdminCreate extends Component {


    constructor(props) {
        super(props);
       
        this.state = { value: '' };
      }
      onChange = (value) => {
        this.setState({ value });
      }
      state = {
        loading: false,
        visible: false
      };
      showModal = () => {
      
        this.setState({
          visible: true,
        });
      }

  

      addBuilding = (e) => {

  
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
          if (!err) {
          
           
            reqwest({
              url: 'http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/admin/save',
              method: 'post',
              data: {
              ...this.props.form.getFieldsValue()
              },
              type: 'json'
              ,error: function (err) {
                openNotificationWithIconError('error');
               }
              , success: function (data) {
                openNotificationWithIcon('success');
              
                }
            }).then((data) => {
              this.props.fetch();
            });
            this.hideModal();
          }
        });

       
      }
    
      hideModal = () => {
        this.setState({
          visible: false,
        });
      }
      getInitialState() {
        return { visible: false };
      }
      getdomid=()=>{
       
      }

      componentWillMount(nextProps){
       
    }
    
    render() {
            
         
          
            const { getFieldDecorator } = this.props.form;
            
            const formItemLayout = {
              labelCol: { span: 4 },
              wrapperCol: { span: 20 },
            };
          
          return (
          
            <div style={{display: 'inline-block'}}>
                <Button type="primary" icon="plus" onClick={this.showModal} value="large">新增</Button>

            <Modal
              title="新增"
              visible={this.state.visible}
              onOk={this.addBuilding}
              onCancel={this.hideModal}
              okText="确认"
              cancelText="取消"
            >
            <Form horizontal form={this.props.form}>
       
      
                  
               

                <FormItem
                  {...formItemLayout}
                  label="用户名"
                >
                {getFieldDecorator('adminUsername', {
                   
                    rules: [{ required: true, message: '请填写用户名' }],
                  })(
                    <Input  autoComplete="off" style={{ width: 120 }}     />
                  )}
                </FormItem>

                <FormItem
                  {...formItemLayout}
                  label=" 密码"
                >
                {getFieldDecorator('adminPassword', {
                    rules: [{ required: true, message: '请设置密码' }],
                  })(
                    <Input   autoComplete="off" placeholder="密码" type='password' />
                )}
                </FormItem>
        
                <FormItem
                  {...formItemLayout}
                  label="姓名"
                >
                {getFieldDecorator('adminName', {
                   
                    rules: [{ required: true, message: '名字总有吧？' }],
                  })(
                    <Input  autoComplete="off" style={{ width: 120 }}     />
                  )}
                </FormItem>
                <FormItem
                  {...formItemLayout}
                  label="性别"
                >
                {getFieldDecorator('adminSex', {
                    initialValue:'男',
                    rules: [{ required: true, message: '何方妖孽？' }],
                  })(
                  <Select   autoComplete="off" style={{ width: 60 }}>
                  <Option value="男">男</Option>
                  <Option value="女">女</Option>
                </Select>
                  )}
                </FormItem>
                <FormItem
                  {...formItemLayout}
                  label="联系电话"
                >
                {getFieldDecorator('adminTel', {
                   
                    rules: [{ required: true, message: '留个电话常联系～～' }],
                  })(
                    <Input  autoComplete="off" style={{ width: 120 }}     />
                  )}
                </FormItem>
              
            
              </Form>
            </Modal>
            </div>
          );
       
    }
  }
  AdminCreate=createForm()(AdminCreate);
  
  export default AdminCreate;