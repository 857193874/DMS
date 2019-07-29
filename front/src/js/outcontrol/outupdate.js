import React, { Component } from 'react';
import moment from 'moment';
import { Layout, Breadcrumb} from 'antd';
import { notification,Form, Row,Button, Icon ,Modal, InputNumber, Input  ,Col, Select, DatePicker, AutoComplete, Cascader} from 'antd';
import { Table } from 'antd';
import reqwest from 'reqwest';
const { MonthPicker, RangePicker, WeekPicker } = DatePicker;
const InputGroup = Input.Group;
const Option = Select.Option;
const confirm = Modal.confirm;
const {Content } = Layout;
const ButtonGroup = Button.Group;
const createForm = Form.create;
const FormItem = Form.Item;
const dateFormat = 'YYYY-MM-DD';

let  studentnames=[1];
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

  var format = function(time, format)
{
  var t = new Date(time);
  var tf = function(i){return (i < 10 ? '0' :'') + i};
  return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function(a){
  switch(a){
  case 'yyyy':
  return tf(t.getFullYear());
  break;
  case 'MM':
  return tf(t.getMonth() + 1);
  break;
  case 'mm':
  return tf(t.getMinutes());
  break;
  case 'dd':
  return tf(t.getDate());
  break;
  case 'HH':
  return tf(t.getHours());
  break;
  case 'ss':
  return tf(t.getSeconds());
  break;
  }
  })
}
class OutUpdate extends Component {
    constructor(props) {
        super(props);
        this.state = { value: '' };
        
      }
      onChange = (value) => {
        this.setState({ value });
      }
      state = {
        studentUsername:[],
        data:[],
        loading: false,
        visible: false,
        getidInfo:false,
        getInfos:false
      };
      
      
      showModal = () => {
        reqwest({
            url: 'http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/student/query/all/StudentUsername',
           method: 'get'
          ,type: 'json'
         
        }).then((data) => {
          this.setState({
            buildingid: data.data.studentUsername,
            getidInfo:true,
          });
          studentnames= data.data.studentUsername;
          if(this.state.getidInfo===true&&this.state.getInfos===true){
            this.setState({
              visible: true,
            });
          }
        });
        reqwest({
            url: 'http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/out/query/'+this.props.outId,
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
                data: data.data.myout,
                getInfos:true
              });
              if(this.state.getidInfo===true&&this.state.getInfos===true){
                this.setState({
                  visible: true,
                });
              }
          });
    
      }


       

       
      

      updateOut = (e) => {
        
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
         
       
        
          if (!err) {
          
            reqwest({
              url: 'http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/out/update/'+this.props.outId,
               method: 'post'
              ,type: 'json'
              ,data: this.props.form.getFieldsValue()
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
      componentWillMount(nextProps){
      
      }
    render() {
       
        const IdOptions = studentnames.map(outStudentid => <Option key={outStudentid}>{outStudentid}</Option>);

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
          onOk={this.updateOut}
          onCancel={this.hideModal}
          okText="确认"
          cancelText="取消"
        >
        <Form horizontal form={this.props.form}>
            <FormItem
              {...formItemLayout}
              label="学生ID"
            >
        
              {getFieldDecorator('outStudentid', {
                initialValue:this.state.data ? this.state.data.outStudentid : '',
                rules: [{ required: true, message: '君の名前は' }],
              })(
                <Select  style={{ width: 160 }}  autoComplete="off">
                {IdOptions}
                 </Select>
              )}
            </FormItem>

            <FormItem
              {...formItemLayout}
              label=" 外出ID"
            >
             {getFieldDecorator('outId', {
                initialValue:this.state.data ? this.state.data.outId : '',
                rules: [{ required: true, message: 'ID不可为空!' }],
              })(
            <Input  autoComplete="off" style={{ width: 90 }}  disabled  />
             )}
            </FormItem>
  
            <FormItem
              {...formItemLayout}
              label="外出时间"
            >
             {
                 getFieldDecorator('outDate', {
                  initialValue:moment(format(this.state.data ? this.state.data.outDate : '', 'yyyy-MM-dd'), dateFormat),
                rules: [{ required: true, message: '时间宝贵' }],
              })(
               
                <DatePicker  format={dateFormat}   autoComplete="off"  showTime="true"/>
             
            )}
           </FormItem>

            <FormItem
              {...formItemLayout}
              label="意见"
            >
            {getFieldDecorator('outRemark', {
                initialValue:this.state.data ? this.state.data.outRemark : '',
                rules: [{ required: true, message: '敢不敢把这个空填了' }],
              })(
                <Input  autoComplete="off" style={{ width: 160 }}     />
              )}
            </FormItem>

        
          </Form>
        </Modal>
        </div>
      );
    }
  }
  OutUpdate=createForm()(OutUpdate);

  export default OutUpdate;