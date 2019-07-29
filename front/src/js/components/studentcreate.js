import React, { Component } from 'react';
import { Layout, Breadcrumb} from 'antd';
import { notification,Form, Row,Button, Icon ,Modal, InputNumber, Input  ,Col, Select, DatePicker, AutoComplete, Cascader} from 'antd';
import { Table } from 'antd';
import reqwest from 'reqwest';
import NumericInput from'./NumericInput';
const InputGroup = Input.Group;
const Option = Select.Option;
const confirm = Modal.confirm;
const {Content } = Layout;
const ButtonGroup = Button.Group;
const createForm = Form.create;
const FormItem = Form.Item;
let  domIdData=[1];
const openNotificationWithIcon = (type) => {
    notification[type]({
      message: '添加成功！',
      description: '该信息已成功添加',
    });
  };

  const openNotificationWithIconError = (type) => {
    notification[type]({
      message: '添加失败！',
      description: '请检查数据是否完整,用户名是否重名,若问题未解决请联系后台管理员',
    });
  };

  function onChange(value) {
    //console.log('changed', value);
  }
  
class StudentCreate extends Component {


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
          url: 'http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/domitory/query/domitoryId',//http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/student/query/all
           method: 'get'
          ,type: 'json'
         
        }).then((data) => {
          domIdData= data.data.domitoryids;
          //console.log("selectdomitoryId");
          
          this.setState({
            visible: true,
          });
        });
  
      }

  

      addStudent = (e) => {

  
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
          if (!err) {
            //console.log('数据正确 ', values);
            //console.log('addStudnet');
            //console.log(this.props.form.getFieldsValue().studentSex==undefined);
            reqwest({
              url: 'http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/student/save',//http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/student/query/all
              method: 'post',
              data: {
              ...this.props.form.getFieldsValue()
              },
              type: 'json'
              ,error: function (err) {
                openNotificationWithIconError('error');
               }
              , success: function (data) {
              
                if(data.status===100){
                  openNotificationWithIconError('error');
                }else
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
        reqwest({
          url: 'http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/domitory/query/domitoryId',//http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/student/query/all
           method: 'get'
          ,type: 'json'
         
        }).then((data) => {
          domIdData= data.data.domitoryids;
          //console.log("selectdomitoryId");
          
         
        });
      //console.log("componentWillMount");
    }
    
    render() {
      //console.log("getdomid");
        
       

            
            let IdOptions = domIdData.map(studentDomitoryid => <Option key={studentDomitoryid}>{studentDomitoryid}</Option>);
          
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
              onOk={this.addStudent}
              onCancel={this.hideModal}
              okText="确认"
              cancelText="取消"
            >
            <Form horizontal form={this.props.form}>
                <FormItem
                  {...formItemLayout}
                  label="宿舍号"
                >
                  {getFieldDecorator('studentDomitoryid', {
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
                  label="姓名"
                >
                {getFieldDecorator('studentName', {
                    rules: [{ required: true, message: '长这么大家里不给起个名吗？' }],
                  })(
                <Input   autoComplete="off" placeholder="姓名" />
                )}
              </FormItem>

                <FormItem
                  {...formItemLayout}
                  label="性别"
                >
                {getFieldDecorator('studentSex', {
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
                  label=" 用户名"
                >
                {getFieldDecorator('studentUsername', {
                    rules: [{ required: true, message: '用户名不可为空!' }],
                  })(
                <Input  autoComplete="off" style={{ width: 120 }} value={this.state.value} onChange={this.onChange}    />
                )}
                </FormItem>
        
                <FormItem
                  {...formItemLayout}
                  label=" 密码"
                >
                  {getFieldDecorator('studentPassword', {
                    rules: [{ required: true, message: '你确定不输入密码么？' }],
                  })(
                  <Input   autoComplete="off" placeholder="密码" type='password' />
                  )}
                </FormItem>
          
                <FormItem
                      {...formItemLayout}
                      label=" 班级"
                    >   
                  {getFieldDecorator('studentClass', {
                    rules: [{ required: true, message: '都是出来上课的，总得有个班吧' }],
                  })(
                    <Input   autoComplete="off" placeholder="班级" />   
                  )}
                </FormItem>

                <FormItem
                  {...formItemLayout}
                  label="状态"
                >
                {getFieldDecorator('studentState', {
                    initialValue:'在校',
                    rules: [{ required: true, message: '现在是什么状态？' }],
                  })(
                  <Select   autoComplete="off" style={{ width: 120 }}>
                  <Option value="在校">在校</Option>
                  <Option value="离校">离校</Option>
                </Select>
                  )}
                </FormItem>
              </Form>
            </Modal>
            </div>
          );
       
    }
  }
  StudentCreate=createForm()(StudentCreate);
  
  export default StudentCreate;