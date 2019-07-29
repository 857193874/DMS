import React, { Component } from 'react';
import { Layout, Breadcrumb} from 'antd';
import { notification,Form, Row,Button, Icon ,Modal, InputNumber, Input  ,Col, Select, DatePicker, AutoComplete, Cascader} from 'antd';
import { Table } from 'antd';
import reqwest from 'reqwest';
import OutCreate from './outcreate';
import OutDel from './outdel';
import OutUpdate from './outupdate';
const InputGroup = Input.Group;
const Option = Select.Option;
const confirm = Modal.confirm;
const {Content } = Layout;
const ButtonGroup = Button.Group;
const createForm = Form.create;
const FormItem = Form.Item;
let maindata;



var format = function(time, format)
{
  var t = new Date(time['text']);
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

class OutCRUD extends Component {
  
  constructor(props) {
    super(props);
    this.state = { value: '' };
  }

  state = {
    data: [],
    pagination: {},
    filterDropdownVisible: false,
    searchText: '',
    loading: false,
    visible: false
  };
  //搜索逻辑
  onInputChange = (e) => {
    //console.log(e);
    this.setState({ searchText: e.target.value });
  }
  onSearch = () => {
    const { searchText } = this.state;
    const reg = new RegExp(searchText, 'gi');
   
    //console.log(maindata);
    this.setState({
      filterDropdownVisible: false,
      data: maindata.map((record) => {
        
        const match = record.outStudentid.match(reg);
        if (!match) {
          return null;
        }
        return {
          ...record,
          outStudentid: (
            <span>
              {record.outStudentid.split(reg).map((text, i) => (
                i > 0 ? [<span className="highlight">{match[0]}</span>, text] : text
              ))}
            </span>
          ),
        };
      }).filter(record => !!record),
    });
  }

  //查询逻辑
  handleTableChange = (pagination, filters, sorter) => {
    const pager = { ...this.state.data.outId };
    pager.current = pagination.current;
    this.setState({
      pagination: pager,
    });
    this.fetch({
      results: pagination.pageSize,
      page: pagination.current,
      sortField: sorter.field,
      sortOrder: sorter.order,
      ...filters,
    });
  }
  fetch = (params = {}) => {
    //console.log('params:', params);
    this.setState({ loading: true });
    reqwest({
      url: 'http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/out/query/all',
      method: 'get',
      data: {

        ...params,
      },
      type: 'json',
    }).then((data) => {
      const pagination = { ...this.state.outId
     };
      // Read total count from server
      // pagination.total = data.totalCount;
      pagination.total = 1;
      maindata=data.data.allOut;
      this.setState({
        loading: false,
        data: data.data.allOut.list,
        pagination,
      });
      //console.log(this.state)
      //console.log(data)
    });
  }
  componentDidMount() {
    this.fetch();
  }

  getInitialState() {
    return { visible: false };
  }
    render() {


      const columns = [
        {
          title: '外出ID',
          dataIndex: 'outId',
       
        },{
        title: '外出学生ID',
        dataIndex: 'outStudentid',
        width: '20%',
        filterDropdown: (
            <div className="custom-filter-dropdown">
              <Input
                placeholder="Search 学生ID"
                value={this.state.searchText}
                onChange={this.onInputChange}
                onPressEnter={this.onSearch}
              />
              <Button type="primary" onClick={this.onSearch}>Search</Button>
            </div>
          ),
          filterDropdownVisible: this.state.filterDropdownVisible,
          onFilterDropdownVisibleChange: visible => this.setState({ filterDropdownVisible: visible }),
      },{
        title: '外出日期/记录时间',
        dataIndex: 'outDate',
        width: '20%',
        render: (text, record) => (
         
          <div>
            {format({text}, 'yyyy-MM-dd HH:mm:ss')}
          </div>
        ),
       
      },{
        title: '意见，评论',
        dataIndex: 'outRemark',
      },{
        title: '操作',
        key: 'action',
        dataIndex: 'outId',
        render: (text, record) => (
         
          <div>
           
              <OutUpdate outId={text}  fetch={this.fetch} />
              <OutDel outId={text}  fetch={this.fetch} />
          </div>
        ),
      }];

    
      return (
        <Content style={{ margin: '0 16px' }}>
        <Breadcrumb style={{ margin: '16px 0' }}>
          <Breadcrumb.Item>外出</Breadcrumb.Item>
          <Breadcrumb.Item>信息</Breadcrumb.Item>
        </Breadcrumb>
        <div style={{ padding: 24, background: '#fff', minHeight: 360 }}>
        <OutCreate  fetch={this.fetch} />
            <Table columns={columns}
              rowKey={record => record.registered}
              dataSource={this.state.data}
              pagination={this.state.pagination}
              loading={this.state.loading}
              onChange={this.handleTableChange}
            />
           
        </div>

       
      </Content>
      );
      
    }
    
  }



  export default OutCRUD;