import React, { Component } from 'react';
import { Layout, Breadcrumb} from 'antd';
import { notification,Form, Row,Button, Icon ,Modal, InputNumber, Input  ,Col, Select, DatePicker, AutoComplete, Cascader} from 'antd';
import { Table } from 'antd';
import reqwest from 'reqwest';
import NumericInput from'./NumericInput';
import StudentCreateBtn from './studentcreate'
import StudentDel from './studentdel';
import StudentUpdate from './studentupdate';
const InputGroup = Input.Group;
const Option = Select.Option;
const confirm = Modal.confirm;
const {Content } = Layout;
const ButtonGroup = Button.Group;
const createForm = Form.create;
const FormItem = Form.Item;
let maindata;





class StudentCRUD extends Component {
  
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
 
    this.setState({ searchText: e.target.value });
  }
  onSearch = () => {
    const { searchText } = this.state;
    const reg = new RegExp(searchText, 'gi');
   
  
    this.setState({
      filterDropdownVisible: false,
      data: maindata.map((record) => {
        
        const match = record.studentUsername.match(reg);
        if (!match) {
          return null;
        }
        return {
          ...record,
          studentUsername: (
            <span>
              {record.studentUsername.split(reg).map((text, i) => (
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
    const pager = { ...this.state.studentDomitoryid };
    pager.current = pagination.current;
    this.setState({
      pagination: pager,
    });
    this.fetch({
      results: pagination.pageSize,
      pn: pagination.current,
      sortField: sorter.field,
      sortOrder: sorter.order,
      ...filters,
    });
  }
  fetch = (params = {}) => {
  
    this.setState({ loading: true });
    reqwest({
      url: 'http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/student/query/all',//http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/student/query/all
      method: 'get',
      data: {

        ...params,
      },
      type: 'json',
    }).then((data) => {
      const pagination = { ...this.state.studentDomitoryid };
      // Read total count from server
      // pagination.total = data.totalCount;
      pagination.total = data.data.allStudentInfo.pages*10;
      maindata=data.data.allStudentInfo.list;
      this.setState({
        loading: false,
        data: data.data.allStudentInfo.list,
        pagination,
      });
     
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
          dataIndex: 'studentDomitoryid',
        },{
        title: '姓名',
        dataIndex: 'studentName',
      },{
        title: '性别',
        dataIndex: 'studentSex',
        width: '20%',
      },{
        title: '用户名',
        dataIndex: 'studentUsername',
        width: '20%',
        filterDropdown: (
          <div className="custom-filter-dropdown">
            <Input
              placeholder="Search username"
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
        title: '密码',
        dataIndex: 'studentPassword',
      },{
        title: '班级',
        dataIndex: 'studentClass',
      },{
        title: '状态',
        dataIndex: 'studentState',
      },{
        title: '操作',
        key: 'action',
        dataIndex: 'studentUsername',
        render: (text, record) => (
         
          <div>
            
         
            <StudentUpdate studentUsername={text} fetch={this.fetch}/>
            <StudentDel studentUsername={text} fetch={this.fetch}/>
          </div>
        ),
      }];

    
      return (
        <Content style={{ margin: '0 16px' }}>
        <Breadcrumb style={{ margin: '16px 0' }}>
          <Breadcrumb.Item>学生</Breadcrumb.Item>
          <Breadcrumb.Item>信息</Breadcrumb.Item>
        </Breadcrumb>
        <div style={{ padding: 24, background: '#fff', minHeight: 360 }}>
        <StudentCreateBtn fetch={this.fetch} />
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



  export default StudentCRUD;