import React, { Component } from 'react';
import { notification,Form, Row,Button, Icon ,Modal, InputNumber, Input  ,Col, Select, DatePicker, AutoComplete, Cascader} from 'antd';
import reqwest from 'reqwest';


const confirm = Modal.confirm;
const openNotificationWithIcon = (type) => {
    notification[type]({
      message: '删除成功',
      description: '该信息已删除',
    });
  };

  const openNotificationWithIconError = (type) => {
    notification[type]({
      message: '删除失败',
      description: '还有同学在这里住呢（若问题未解决请联系管理员）',
    });
  };

  function onChange(value) {
    //console.log('changed', value);
  }

  function showDeleteConfirm(data) {
    var that=this;
    confirm({
      title: '确定要删除吗?',
      content: '此操作存在风险，请谨慎考虑',
      okText: '删除',
      okType: 'danger',
      cancelText: '取消',
      onOk() {
        //console.log(data)
        //console.log('data');
        reqwest({
            url: 'http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/domitory/del/'+data,
            method: 'delete',
            data: {
            },
            type: 'json'
            ,error: function (err) {
              openNotificationWithIconError('error');
             }
            , success: function (data) {
              if(data.status == 200){
                openNotificationWithIcon('success');
              }else{
                openNotificationWithIconError('error');
              }
              
              //console.log(data)
              }
          }).then((data) => {
            that.props.fetch();
          });
        //console.log('OK');
      },
      onCancel() {
        //console.log('Cancel');
      },
    });
  }
class DomitoryDel extends Component {
  
    render() {
     
      return (
          
        <div style={{display: 'inline-block'}}>
             <Button type="danger" icon="delete" onClick={showDeleteConfirm.bind(this,this.props.domitoryId)} />
        
        </div>

      );
    }
  }
  
  export default DomitoryDel;