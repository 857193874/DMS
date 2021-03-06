import React, { Component } from 'react';
import { Layout, Breadcrumb} from 'antd';
import { notification,Form, Row,Button, Icon ,Modal, InputNumber, Input  ,Col, Select, DatePicker, AutoComplete, Cascader} from 'antd';
import { Table } from 'antd';
import reqwest from 'reqwest';
import DomitoryCreateBtn from './domitory_create';
import DomitoryDelBtn from './domitory_del';
import DomitoryUpdateBtn from './domitory_update';

const InputGroup = Input.Group;
const Option = Select.Option;
const confirm = Modal.confirm;
const {Content } = Layout;
const ButtonGroup = Button.Group;
const createForm = Form.create;
const FormItem = Form.Item;
let maindata;





class DomitoryCRUD extends Component {
  
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
        
        const match = record.domitoryName.match(reg);
        if (!match) {
          return null;
        }
        return {
          ...record,
          domitoryName: (
            <span>
              {record.domitoryName.split(reg).map((text, i) => (
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
    const pager = { ...this.state.data.domitoryId };
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
      url: 'http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/domitory/query/all',
      method: 'get',
      data: {

        ...params,
      },
      type: 'json',
    }).then((data) => {
      const pagination = { ...this.state.domitoryId
     };
      // Read total count from server
      // pagination.total = data.totalCount;
      pagination.total = 1;
      maindata=data.data.allDomitory;
      this.setState({
        loading: false,
        data: data.data.allDomitory,
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
          title: '宿舍ID',
          dataIndex: 'domitoryId',
       
        },{
        title: '宿舍所属楼ID',
        dataIndex: 'domitoryBuildingid',
      },{
        title: '宿舍名',
        dataIndex: 'domitoryName',
        width: '20%',
        filterDropdown: (
            <div className="custom-filter-dropdown">
              <Input
                placeholder="Search 宿舍名"
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
        title: '宿舍类型',
        dataIndex: 'domitoryType',
        width: '20%',
       
      },{
        title: '宿舍号',
        dataIndex: 'domitoryNumber',
      },{
        title: '宿舍电话',
        dataIndex: 'domitoryTel',
      },{
        title: '操作',
        key: 'action',
        dataIndex: 'domitoryId',
        render: (text, record) => (
         
          <div>
         
            <DomitoryUpdateBtn domitoryId={text} fetch={this.fetch}/>
            <DomitoryDelBtn domitoryId={text} fetch={this.fetch}/>
          </div>
        ),
      }];

    
      return (
        <Content style={{ margin: '0 16px' }}>
        <Breadcrumb style={{ margin: '16px 0' }}>
          <Breadcrumb.Item>宿舍</Breadcrumb.Item>
          <Breadcrumb.Item>信息</Breadcrumb.Item>
        </Breadcrumb>
        <div style={{ padding: 24, background: '#fff', minHeight: 360 }}>
        <DomitoryCreateBtn fetch={this.fetch} />
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



  export default DomitoryCRUD;