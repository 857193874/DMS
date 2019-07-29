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
class PowerUpdate extends Component {
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
            url: 'http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/power/query/'+this.props.powerId,
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
                data: data.data.power,
                getInfos:true
              
              });


              if(this.state.getidInfo===true&&this.state.getInfos===true){
                this.setState({
                  visible: true,
                });
              }

              //console.log(this.state.data?this.state.data.powerId:'');
          });
     
      }


       

       
      

      updatePower = (e) => {
        
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
           
          if (!err) {
            //console.log('数据正确 ', values);
            //console.log('updatePower');
            //console.log(this.props.form.getFieldsValue());

            reqwest({
              url: 'http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/power/update/'+this.props.powerId,
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
       
        const IdOptions = buildIds.map(powerBuildingId => <Option key={powerBuildingId}>{powerBuildingId}</Option>);

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
          onOk={this.updatePower}
          onCancel={this.hideModal}
          okText="确认"
          cancelText="取消"
        >
        <Form horizontal form={this.props.form}>
            <FormItem
              {...formItemLayout}
              label="电力所属楼ID"
            >
        
              {getFieldDecorator('powerBuildingId', {
                initialValue:this.state.data ? this.state.data.powerBuildingId : '',
                rules: [{ required: true, message: '给个地方住吧' }],
              })(
                <Select  style={{ width: 90 }}  autoComplete="off">
                {IdOptions}
                 </Select>
              )}
            </FormItem>

            <FormItem
              {...formItemLayout}
              label=" 电力ID"
            >
             {getFieldDecorator('powerId', {
                initialValue:this.state.data ? this.state.data.powerId : '',
                rules: [{ required: true, message: '用户名不可为空!' }],
              })(
            <Input  autoComplete="off" style={{ width: 90 }} value={this.state.value} onChange={this.onChange}  disabled  />
             )}
            </FormItem>
  
            <FormItem
              {...formItemLayout}
              label="总用电量"
            >
             {
                 getFieldDecorator('totalconsumption', {
                 initialValue:this.state.data ? this.state.data.totalconsumption : '',
                rules: [{ required: true, message: '填写总用电量' }],
              })(
                <InputNumber min={0} max={10000}  onChange={onChange} />
             
            )}
           </FormItem>

            <FormItem
              {...formItemLayout}
              label="补助电量"
            >
            {getFieldDecorator('subsidyconsumption', {
                initialValue:this.state.data ? this.state.data.subsidyconsumption : '',
                rules: [{ required: true, message: '有补助嘛' }],
              })(
                <InputNumber min={0} max={10000}  onChange={onChange} />
              )}
            </FormItem>

            <FormItem
              {...formItemLayout}
              label=" 花费电量"
            >
             {getFieldDecorator('payconsumption', {
                initialValue:this.state.data ? this.state.data.payconsumption : '',
                rules: [{ required: true, message: '花费了多少？？' }],
              })(
                <InputNumber min={0} max={10000}  onChange={onChange} />
             )}
            </FormItem>
    
            <FormItem
              {...formItemLayout}
              label=" 免费电量"
            >
              {getFieldDecorator('freeconsumption', {
                initialValue:this.state.data ? this.state.data.freeconsumption : '',
                rules: [{ required: true, message: 'Free Free！！' }],
              })(
                <InputNumber min={0} max={10000}  onChange={onChange} />
              )}
            </FormItem>

                     <FormItem
              {...formItemLayout}
              label=" 价格"
            >
              {getFieldDecorator('price', {
                initialValue:this.state.data ? this.state.data.price : '',
                rules: [{ required: true, message: '钱都不要了？？' }],
              })(
                <InputNumber min={0} max={10000}  onChange={onChange} />
              )}
            </FormItem>
       
          </Form>
        </Modal>
        </div>
      );
    }
  }
  PowerUpdate=createForm()(PowerUpdate);

  export default PowerUpdate;