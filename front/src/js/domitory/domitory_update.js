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
    //console.log('changed', value);
  }
class DomitoryUpdate extends Component {
    constructor(props) {
        super(props);
        this.state = { value: '' };
        
      }
      onChange = (value) => {
        this.setState({ value });
      }
      state = {
        buildingid:[],
        data:[],
        loading: false,
        visible: false,
        getidInfo:false,
        getInfos:false
      };
      
      
      showModal = () => {
        reqwest({
          url: 'http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/building/query/buildingId',
           method: 'get'
          ,type: 'json'
         
        }).then((data) => {
          this.setState({
            buildingid: data.data.buildingids,
            getidInfo:true,
          });
          buildIds= data.data.buildingids;
          
          if(this.state.getidInfo===true&&this.state.getInfos===true){
            this.setState({
              visible: true,
            });
          }
        });
        reqwest({
            url: 'http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/domitory/query/'+this.props.domitoryId,
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
                data: data.data.domitory,
                getInfos:true
              
              });


              if(this.state.getidInfo===true&&this.state.getInfos===true){
                this.setState({
                  visible: true,
                });
              }

              //console.log(this.state.data?this.state.data.domitoryId:'');
          });
     
      }


       

       
      

      updateDomitory = (e) => {
        
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
           
          if (!err) {
            //console.log('数据正确 ', values);
            //console.log('updateDomitory');
            //console.log(this.props.form.getFieldsValue());

            reqwest({
              url: 'http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/domitory/update/'+this.props.domitoryId,
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
       
        const IdOptions = buildIds.map(domitoryBuildingid => <Option key={domitoryBuildingid}>{domitoryBuildingid}</Option>);

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
          onOk={this.updateDomitory}
          onCancel={this.hideModal}
          okText="确认"
          cancelText="取消"
        >
        <Form horizontal form={this.props.form}>
            <FormItem
              {...formItemLayout}
              label="宿舍所属楼ID"
            >
        
              {getFieldDecorator('domitoryBuildingid', {
                initialValue:this.state.data ? this.state.data.domitoryBuildingid : '',
                rules: [{ required: true, message: '给个地方住吧' }],
              })(
                <Select  style={{ width: 90 }}  autoComplete="off">
                {IdOptions}
                 </Select>
              )}
            </FormItem>

            <FormItem
              {...formItemLayout}
              label=" 宿舍ID"
            >
             {getFieldDecorator('domitoryId', {
                initialValue:this.state.data ? this.state.data.domitoryId : '',
                rules: [{ required: true, message: '用户名不可为空!' }],
              })(
            <Input  autoComplete="off" style={{ width: 90 }} value={this.state.value} onChange={this.onChange}  disabled  />
             )}
            </FormItem>
  
            <FormItem
              {...formItemLayout}
              label="宿舍名"
            >
             {
                 getFieldDecorator('domitoryName', {
                 initialValue:this.state.data ? this.state.data.domitoryName : '',
                rules: [{ required: true, message: '想个宿舍名都这么墨迹吗？' }],
              })(
             <Input   autoComplete="off" placeholder="宿舍名" style={{ width: 90 }}  />
             
            )}
           </FormItem>

            <FormItem
              {...formItemLayout}
              label="宿舍类型"
            >
            {getFieldDecorator('domitoryType', {
                initialValue:this.state.data ? this.state.data.domitoryType : '',
                rules: [{ required: true, message: '敢不敢把这个空填了' }],
              })(
                <Input  autoComplete="off" style={{ width: 90 }}     />
              )}
            </FormItem>

            <FormItem
              {...formItemLayout}
              label=" 宿舍号"
            >
             {getFieldDecorator('domitoryNumber', {
                initialValue:this.state.data ? this.state.data.domitoryNumber : '',
                rules: [{ required: true, message: '宿舍号是多少？？!' }],
              })(
                <Input   autoComplete="off" placeholder="宿舍号"  />
             )}
            </FormItem>
    
            <FormItem
              {...formItemLayout}
              label=" 宿舍电话"
            >
              {getFieldDecorator('domitoryTel', {
                initialValue:this.state.data ? this.state.data.domitoryTel : '',
                rules: [{ required: true, message: '留个宿舍电话吧，常联系～' }],
              })(
               <Input autoComplete="off" placeholder="宿舍电话" />
              )}
            </FormItem>
       
          </Form>
        </Modal>
        </div>
      );
    }
  }
  DomitoryUpdate=createForm()(DomitoryUpdate);

  export default DomitoryUpdate;