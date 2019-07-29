import React, { Component } from 'react';
import { Layout, Breadcrumb} from 'antd';
import { notification,Form, Row,Button, Icon ,Modal, InputNumber, Input  ,Col, Select, DatePicker, AutoComplete, Cascader} from 'antd';
import { Table } from 'antd';
import reqwest from 'reqwest';
const InputGroup = Input.Group;
const Option = Select.Option;
const confirm = Modal.confirm;
const {Content } = Layout;
const ButtonGroup = Button.Group;
const createForm = Form.create;
const FormItem = Form.Item;
let  buildIds=[1];
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
    //console.log('changed', value);
  }
  
class DomitoryCreate extends Component {


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
        reqwest({
          url: 'http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/building/query/buildingId',
           method: 'get'
          ,type: 'json'
         
        }).then((data) => {
          buildIds= data.data.buildingids;
          //console.log("selectdomitoryId");
          this.setState({
            visible: true,
          });
         
        });
    
      }

  

      addDomitory = (e) => {

  
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
          if (!err) {
            //console.log('数据正确 ', values);
            //console.log('addDomitory');
           
            reqwest({
              url: 'http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/domitory/save',
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
                //console.log(data)
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
          //console.log("asdfasdf");
      }

      componentWillMount(nextProps){

    }
    
    render() {
            
            let IdOptions = buildIds.map(domitoryBuildingid => <Option key={domitoryBuildingid}>{domitoryBuildingid}</Option>);
          
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
              onOk={this.addDomitory}
              onCancel={this.hideModal}
              okText="确认"
              cancelText="取消"
            >
            <Form horizontal form={this.props.form}>
                <FormItem
                  {...formItemLayout}
                  label="宿舍楼号"
                >
                  {getFieldDecorator('domitoryBuildingid', {
                    initialValue:1,
                    rules: [{ required: true, message: '给个地方住吧' }],
                  })(
                    <Select  style={{ width: 90 }}  autoComplete="off">
                      {IdOptions}
                    </Select>
                  )}
                </FormItem>
      
                  
               

                <FormItem
                  {...formItemLayout}
                  label="宿舍名"
                >
                {getFieldDecorator('domitoryName', {
                   
                    rules: [{ required: true, message: '想个宿舍名都这么墨迹吗？' }],
                  })(
                    <Input  autoComplete="off" style={{ width: 90 }}     />
                  )}
                </FormItem>

                <FormItem
                  {...formItemLayout}
                  label=" 宿舍类型"
                >
                {getFieldDecorator('domitoryType', {
                    rules: [{ required: true, message: '敢不敢把这个空填了' }],
                  })(
                <Input  autoComplete="off" style={{ width: 90 }}      />
                )}
                </FormItem>
        
                <FormItem
                  {...formItemLayout}
                  label=" 宿舍号"
                >
                  {getFieldDecorator('domitoryNumber', {
                    rules: [{ required: true, message: '宿舍号是多少？？' }],
                  })(
                  <Input   autoComplete="off" placeholder="宿舍号"  />
                  )}
                </FormItem>
          
                <FormItem
                      {...formItemLayout}
                      label=" 宿舍电话"
                    >   
                  {getFieldDecorator('domitoryTel', {
                    rules: [{ required: true, message: '留个宿舍电话吧，常联系～' }],
                  })(
                    <Input   autoComplete="off" placeholder="宿舍电话" />   
                  )}
                </FormItem>
            
              </Form>
            </Modal>
            </div>
          );
       
    }
  }
  DomitoryCreate=createForm()(DomitoryCreate);
  
  export default DomitoryCreate;