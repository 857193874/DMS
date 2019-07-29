import React, { Component } from "react";
import { Layout, Breadcrumb } from "antd";
import {
  notification,
  Form,
  Row,
  Button,
  Icon,
  Modal,
  InputNumber,
  Input,
  Col,
  Select,
  DatePicker,
  AutoComplete,
  Cascader
} from "antd";
import { Table } from "antd";
import reqwest from "reqwest";
import AdminCreateBtn from "./admin_create";
import AdminDelBtn from "./admin_del";
import AdminUpdateBtn from "./admin_update";

const InputGroup = Input.Group;
const Option = Select.Option;
const confirm = Modal.confirm;
const { Content } = Layout;
const ButtonGroup = Button.Group;
const createForm = Form.create;
const FormItem = Form.Item;
let maindata;

class AdminCRUD extends Component {
  constructor(props) {
    super(props);
    this.state = { value: "" };
  }

  state = {
    data: [],
    pagination: {},
    filterDropdownVisible: false,
    searchText: "",
    loading: false,
    visible: false
  };
  //搜索逻辑
  onInputChange = e => {
    this.setState({ searchText: e.target.value });
  };
  onSearch = () => {
    const { searchText } = this.state;
    const reg = new RegExp(searchText, "gi");

    this.setState({
      filterDropdownVisible: false,
      data: maindata
        .map(record => {
          const match = record.adminUsername.match(reg);
          if (!match) {
            return null;
          }
          return {
            ...record,
            adminUsername: (
              <span>
                {record.adminUsername
                  .split(reg)
                  .map(
                    (text, i) =>
                      i > 0
                        ? [<span className="highlight">{match[0]}</span>, text]
                        : text
                  )}
              </span>
            )
          };
        })
        .filter(record => !!record)
    });
  };

  //查询逻辑
  handleTableChange = (pagination, filters, sorter) => {
    const pager = { ...this.state.data.adminId };
    pager.current = pagination.current;
    this.setState({
      pagination: pager
    });
    this.fetch({
      results: pagination.pageSize,
      page: pagination.current,
      sortField: sorter.field,
      sortOrder: sorter.order,
      ...filters
    });
  };
  fetch = (params = {}) => {
    this.setState({ loading: true });
    reqwest({
      url: "http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/admin/query/all",
      method: "get",
      data: {
        ...params
      },
      type: "json"
    }).then(data => {
      const pagination = {
        ...this.state.adminId
      };
      // Read total count from server
      // pagination.total = data.totalCount;
      pagination.total = 1;
      maindata = data.data.alladmins;
      this.setState({
        loading: false,
        data: data.data.alladmins,
        pagination
      });
    });
  };
  componentDidMount() {
    this.fetch();
  }

  getInitialState() {
    return { visible: false };
  }
  render() {
    const columns = [
      {
        title: "管理员ID",
        dataIndex: "adminId"
      },
      {
        title: "管理员用户名",
        dataIndex: "adminUsername",

        filterDropdown: (
          <div className="custom-filter-dropdown">
            <Input
              placeholder="Search 名称"
              value={this.state.searchText}
              onChange={this.onInputChange}
              onPressEnter={this.onSearch}
            />
            <Button type="primary" onClick={this.onSearch}>
              Search
            </Button>
          </div>
        ),
        filterDropdownVisible: this.state.filterDropdownVisible,
        onFilterDropdownVisibleChange: visible =>
          this.setState({ filterDropdownVisible: visible })
      },
      {
        title: "管理员密码",
        dataIndex: "adminPassword"
      },
      {
        title: "管理员姓名",
        dataIndex: "adminName"
      },
      {
        title: "性别",
        dataIndex: "adminSex"
      },
      {
        title: "电话",
        dataIndex: "adminTel"
      },
      {
        title: "操作",
        key: "action",
        dataIndex: "adminId",
        render: (text, record) => (
          <div>
        
            <AdminUpdateBtn adminId={text} fetch={this.fetch} />
            <AdminDelBtn adminId={text} fetch={this.fetch} />
          </div>
        )
      }
    ];

    return (
      <Content style={{ margin: "0 16px" }}>
        <Breadcrumb style={{ margin: "16px 0" }}>
          <Breadcrumb.Item>管理员</Breadcrumb.Item>
          <Breadcrumb.Item>信息</Breadcrumb.Item>
         
        </Breadcrumb>
        <div style={{ padding: 24, background: "#fff", minHeight: 360 }}>
        <AdminCreateBtn fetch={this.fetch} />
          <Table
            columns={columns}
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

export default AdminCRUD;
