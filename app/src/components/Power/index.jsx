import React, { Component } from 'react';
import { connect } from 'react-redux';
import { List, SearchBar, Result, Icon } from 'antd-mobile';

import { fetch as powerDataFetch } from '../../actions/power';

const Item = List.Item;

class Power extends Component {
  state = {
    searchWd: '',
    init: false
  };
  asyncComponentDidMount = async () => {
    let buildingId = await this.props.user.domitoryBuildingid;
    if (buildingId !== undefined) {
      await this.props.powerDataFetch({ buildingId });
      await this.setState({
        init: true
      });
    }
  };
  handleSearchChange = v => {
    if (/^\d+$/.test(v) || v === '') {
      this.setState({
        searchWd: v
      });
    }
  };
  handleSearchBlur = () => {
    if (this.state.searchWd !== '') {
      this.props.powerDataFetch({ buildingId: this.state.searchWd });
    }
  };
  handleSearchCancel = () => {
    this.setState({
      searchWd: ''
    });
  };
  render() {
    const powerData = this.props.power;
    if (!this.state.init) {
      console.log('init');
      this.asyncComponentDidMount();
    }
    return (
      <div className="power">
        <SearchBar
          value={this.state.searchWd}
          placeholder="按公寓楼号搜索"
          onBlur={this.handleSearchBlur}
          onCancel={this.handleSearchCancel}
          onChange={this.handleSearchChange}
          maxLength={2}
        />
        {Object.keys(powerData).length !== 0 ? (
          <List>
            <Item extra={powerData.powerBuildingId}>公寓楼号</Item>
            <Item extra={powerData.freeconsumption}>总电量</Item>
            <Item extra={powerData.subsidyconsumption}>补助电量</Item>
            <Item extra={powerData.payconsumption}>花费电量</Item>
            <Item extra={powerData.freeconsumption}>免费电量</Item>
            <Item extra={powerData.price}>电力价格</Item>
          </List>
        ) : (
          <Result
            img={
              <Icon
                type="cross-circle-o"
                style={{
                  fill: '#F13642',
                  width: '60px',
                  height: '60px'
                }}
              />
            }
            title="信息获取失败"
            message="你输入的楼号可能不存在"
          />
        )}
      </div>
    );
  }
}

const mapStateToProps = state => ({
  power: state.power,
  user: state.user
});

const mapDispatchToProps = {
  powerDataFetch
};

export default connect(mapStateToProps, mapDispatchToProps)(Power);
