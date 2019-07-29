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
  
class BuildingCreate extends Component {


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
              url: 'http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/building/save',
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
                  label="公寓名"
                >
                {getFieldDecorator('buildingName', {
                   
                    rules: [{ required: true, message: '想个公寓名都这么墨迹吗？' }],
                  })(
                    <Input  autoComplete="off" style={{ width: 120 }}     />
                  )}
                </FormItem>

                <FormItem
                  {...formItemLayout}
                  label=" 简介"
                >
                {getFieldDecorator('buildingIntroduction', {
                    rules: [{ required: true, message: '说点什么吧' }],
                  })(
                <TextArea placeholder="简介" autosize={{ minRows: 2, maxRows: 2 }}  maxlength="45" />
                )}
                </FormItem>
        
              
            
              </Form>
            </Modal>
            </div>
          );
       
    }
  }
  BuildingCreate=createForm()(BuildingCreate);
  
  export default BuildingCreate;