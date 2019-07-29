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
import BuildingCreateBtn from "./bulidingcreate";
import BuildingDelBtn from "./bulidingdel";
import BuildingUpdateBtn from "./buildingupdate";

const InputGroup = Input.Group;
const Option = Select.Option;
const confirm = Modal.confirm;
const { Content } = Layout;
const ButtonGroup = Button.Group;
const createForm = Form.create;
const FormItem = Form.Item;
let maindata;

class BuildingCRUD extends Component {
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
          const match = record.buildingName.match(reg);
          if (!match) {
            return null;
          }
          return {
            ...record,
            buildingName: (
              <span>
                {record.buildingName
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
    const pager = { ...this.state.data.buildingId };
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
      url: "http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/building/query/all",
      method: "get",
      data: {
        ...params
      },
      type: "json"
    }).then(data => {
      const pagination = {
        ...this.state.buildingId
      };
      // Read total count from server
      // pagination.total = data.totalCount;
      pagination.total = 1;
      maindata = data.data.allBuilding;
      this.setState({
        loading: false,
        data: data.data.allBuilding,
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
        title: "公寓楼ID",
        width: "25%",
        dataIndex: "buildingId"
      },
      {
        title: "公寓楼名称",
        dataIndex: "buildingName",
        width: "25%",
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
        title: "介绍",
        dataIndex: "buildingIntroduction",
        width: "25%"
      },
      {
        title: "操作",
        width: "25%",
        key: "action",
        dataIndex: "buildingId",
        render: (text, record) => (
          <div>
         
            <BuildingUpdateBtn buildingId={text} fetch={this.fetch} />
            <BuildingDelBtn buildingId={text} fetch={this.fetch} />
          </div>
        )
      }
    ];

    return (
      <Content style={{ margin: "0 16px" }}>
        <Breadcrumb style={{ margin: "16px 0" }}>
          <Breadcrumb.Item>公寓楼</Breadcrumb.Item>
          <Breadcrumb.Item>信息</Breadcrumb.Item>
        </Breadcrumb>
        <div style={{ padding: 24, background: "#fff", minHeight: 360 }}>
        <BuildingCreateBtn fetch={this.fetch} />
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

export default BuildingCRUD;
