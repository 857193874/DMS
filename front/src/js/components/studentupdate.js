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
      message: '修改成功！',
      description: '该信息已成功修改',
    });
  };

  const openNotificationWithIconError = (type) => {
    notification[type]({
      message: '修改失败！',
      description: '请检查数据是否完整',
    });
  };


  function onChange(value) {

  }
class StudentUpdate extends Component {
    constructor(props) {
        super(props);
        this.state = { value: '' };
        
      }
      onChange = (value) => {
        this.setState({ value });
      }
      state = {
        domid:[],
        data:[],
        loading: false,
        visible: false,
        getidInfo:false,
        getInfos:false
      };
      
      
      showModal = () => {
        reqwest({
          url: 'http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/domitory/query/domitoryId',//http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/student/query/all
           method: 'get'
          ,type: 'json'
         
        }).then((data) => {
          this.setState({
            domid: data.data.domitoryids,
            getidInfo:true,
          });
          domIdData= data.data.domitoryids;
       
          //console.log(this.state.domid);
          if(this.state.getidInfo===true&&this.state.getInfos===true){
            this.setState({
              visible: true,
            });
          }
        });
        reqwest({
            url: 'http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/student/query/'+this.props.studentUsername,//http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/student/query/all
            method: 'get',
            data: {
           
            },
            type: 'json'
            ,error: function (err) {
              
             }
            , success: function (data) {
            
              }
          }).then((data) => {
             this.setState({
                data: data.data.studentInfo,
                getInfos:true
               
              });
              if(this.state.getidInfo===true&&this.state.getInfos===true){
                this.setState({
                  visible: true,
                });
              }
              //console.log(this.state.data?this.state.data.studentUsername:'');
          });
    
      }


       

       
      

      updateStudent = (e) => {
        
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
           
          if (!err) {
            //console.log('数据正确 ', values);
            //console.log('updateStudent');
            //console.log(this.props.form.getFieldsValue());

            reqwest({
              url: 'http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/student/update/'+this.props.studentUsername,//http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/student/query/all
               method: 'post'
              ,type: 'json'
              ,data: this.props.form.getFieldsValue()
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
    
    render() {
       
        const IdOptions = domIdData.map(studentDomitoryid => <Option key={studentDomitoryid}>{studentDomitoryid}</Option>);

        const { getFieldDecorator } = this.props.form;

        const formItemLayout = {
          labelCol: { span: 4 },
          wrapperCol: { span: 20 },
        };
        
      return (
          
        <div style={{display: 'inline-block'}}>
             <Button type="primary" icon="edit" onClick={this.showModal}/>

         <Modal
          title="修改"
          visible={this.state.visible}
          onOk={this.updateStudent}
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
                initialValue:this.state.data ? this.state.data.studentDomitoryid : '',
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
             {
                 getFieldDecorator('studentName', {
                 initialValue:this.state.data ? this.state.data.studentName : '',
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
                initialValue:this.state.data ? this.state.data.studentSex : '',
                rules: [{ required: true, message: '是男是女。' }],
              })(
              <Select  autoComplete="off"  style={{ width: 50 }}>
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
                initialValue:this.state.data ? this.state.data.studentUsername : '',
                rules: [{ required: true, message: '用户名不可为空!' }],
              })(
            <Input  autoComplete="off" style={{ width: 120 }} value={this.state.value} onChange={this.onChange}  disabled  />
             )}
            </FormItem>
    
            <FormItem
              {...formItemLayout}
              label=" 密码"
            >
              {getFieldDecorator('studentPassword', {
                initialValue:this.state.data ? this.state.data.studentPassword : '',
                rules: [{ required: true, message: '你确定不输入密码么？' }],
              })(
               <Input autoComplete="off" placeholder="密码" type='password' />
              )}
            </FormItem>
       
            <FormItem
                  {...formItemLayout}
                  label=" 班级"
                >   
              {getFieldDecorator('studentClass', {
                initialValue:this.state.data ? this.state.data.studentClass : '',
                rules: [{ required: true, message: '都是出来上课的，总得有个班吧' }],
              })(
                <Input   autoComplete="off" placeholder="班级" />   
              )}
            </FormItem>
         
            <FormItem
           
                {...formItemLayout}
                label=" 状态"
              >
              {getFieldDecorator('studentState', {
                initialValue:this.state.data ? this.state.data.studentState : '',
                rules: [{ required: true, message: '现在是什么状态？' }],
              })(
            <Input  autoComplete="off" placeholder="状态" />
              )}
            </FormItem>
          </Form>
        </Modal>
        </div>
      );
    }
  }
  StudentUpdate=createForm()(StudentUpdate);

  export default StudentUpdate;