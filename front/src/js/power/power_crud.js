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
import PowerCreateBtn from "./power_create";
import PowerDelBtn from "./power_del";
import PowerUpdateBtn from "./power_update";

const InputGroup = Input.Group;
const Option = Select.Option;
const confirm = Modal.confirm;
const { Content } = Layout;
const ButtonGroup = Button.Group;
const createForm = Form.create;
const FormItem = Form.Item;
let maindata;

class PowerCRUD extends Component {
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
          
            var newre=record.powerBuildingId.toString();
          const match = newre.match(reg);
          if (!match) {
            return null;
          }
          return {
            ...record,
            powerBuildingId: (
              <span>
                {newre
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
    const pager = { ...this.state.data.powerId };
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
      url: "http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms/api/v1/power/query/all",
      method: "get",
      data: {
        ...params
      },
      type: "json"
    }).then(data => {
      const pagination = {
        ...this.state.powerId
      };
      // Read total count from server
      // pagination.total = data.totalCount;
      pagination.total = 1;
      maindata = data.data.allPower;
      this.setState({
        loading: false,
        data: data.data.allPower.list,
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
        title: "电力ID",
        dataIndex: "powerId",
       
       
      },
      {
        title: "公寓楼ID",
        dataIndex: "powerBuildingId",
        filterDropdown: (
            <div className="custom-filter-dropdown">
              <Input
                placeholder="Search ID"
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
        title: "总电量",
        dataIndex: "totalconsumption",
      
      },
      {
        title: "补助电量",
        dataIndex: "subsidyconsumption",
       
      },
      {
        title: "花费电量",
        dataIndex: "payconsumption",
      
      },
      {
        title: "免费电量",
        dataIndex: "freeconsumption",
      
      },
      {
        title: "价格",
        dataIndex: "price",
      
      },
      {
        title: "操作",
        key: "action",
        dataIndex: "powerId",
        render: (text, record) => (
          <div>
           
            <PowerUpdateBtn powerId={text} fetch={this.fetch} /> 
            <PowerDelBtn powerId={text} fetch={this.fetch} />
          </div>
        )
      }
    ];

    return (
      <Content style={{ margin: "0 16px" }}>
        <Breadcrumb style={{ margin: "16px 0" }}>
          <Breadcrumb.Item>电力</Breadcrumb.Item>
          <Breadcrumb.Item>信息</Breadcrumb.Item>
        </Breadcrumb>
        <div style={{ padding: 24, background: "#fff", minHeight: 360 }}>
        <PowerCreateBtn fetch={this.fetch} />   
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

export default PowerCRUD;
