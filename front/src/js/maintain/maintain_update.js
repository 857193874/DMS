import React, { Component } from 'react';
import { Layout, Breadcrumb} from 'antd';
import moment from 'moment';
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
const dateFormat = 'YYYY-MM-DD';
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
class MaintainUpdate extends Component {
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
            url: 'http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/maintain/query/maintainid/'+this.props.maintainId,//http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/student/query/all
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
                data: data.data.maintain,
                getInfos:true
               
              });
              if(this.state.getidInfo===true&&this.state.getInfos===true){
                this.setState({
                  visible: true,
                });
              }
              //console.log(this.state.data?this.state.data.maintainId:'');
          });
    
      }


       

       
      

      updateMaintain = (e) => {
        
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
           
          if (!err) {
            //console.log('数据正确 ', values);
            //console.log('updateMaintain');
            //console.log(this.props.form.getFieldsValue());
  
            reqwest({
              url: 'http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/maintain/update/'+this.props.maintainId,//http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/student/query/all
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
       
        const IdOptions = domIdData.map(domitoryId => <Option key={domitoryId}>{domitoryId}</Option>);

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
          onOk={this.updateMaintain}
          onCancel={this.hideModal}
          okText="确认"
          cancelText="取消"
        >
        <Form horizontal form={this.props.form}>
            <FormItem
              {...formItemLayout}
              label="宿舍号"
            >
        
              {getFieldDecorator('domitoryId', {
                initialValue:this.state.data ? this.state.data.domitoryId : '',
                rules: [{ required: true, message: '哪里报修？' }],
              })(
                <Select  style={{ width: 90 }}  autoComplete="off">
                {IdOptions}
              </Select>
              )}
            </FormItem>
  
            <FormItem
              {...formItemLayout}
              label="报修时间"
            >
             {
                 getFieldDecorator('maintainTime', {
                initialValue:moment(format(this.state.data ? this.state.data.maintainTime : '', 'yyyy-MM-dd'), dateFormat),
                rules: [{ required: true, message: '什么时候报修的呀？' }],
              })(
                <DatePicker  format={dateFormat}   autoComplete="off"  showTime="true"/>
             
            )}
           </FormItem>

          
            <FormItem
           
                {...formItemLayout}
                label=" 状态"
              >
              {getFieldDecorator('status', {
                initialValue:this.state.data ? this.state.data.status : '',
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
  MaintainUpdate=createForm()(MaintainUpdate);

  export default MaintainUpdate;