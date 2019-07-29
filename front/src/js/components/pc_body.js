import React, { Component } from "react";
import StudentCRUD from "./studentcrud";
import DomitoryCRUD from "../domitory/domitory_crud";
import OutCRUD from "../outcontrol/outcrud";
import BuildingCRUD from "../building/buildingcrud";
import AdminCRUD from '../admin/admin_crud';
import PowerCRUD from '../power/power_crud';
import MaintainCRUD from '../maintain/maintain_crud';
class PCBody extends Component {
  render() {
    const tabValue = this.props.tabValue;

    switch (tabValue) {
      case "domitory":
        return (
          <div>
            <DomitoryCRUD />
          </div>
        );
        break;
      case "student":
        return (
          <div>
            <StudentCRUD />
          </div>
        );
        break;
      case "out":
        return (
          <div>
            <OutCRUD />
          </div>
        );
        break;
      case "building":
        return (
          <div>
            <BuildingCRUD />
          </div>
        );
        break;
      case "admin":
        return (
          <div>
            <AdminCRUD />
          </div>
        );
        break;
        case "power":
        return (
          <div>
            <PowerCRUD />
          </div>
        );
        break;
        case "maintain":
        return (
          <div>
            <MaintainCRUD />
          </div>
        );
        break;
      default:
        return (
          <div>
            <AdminCRUD />
          </div>
        );
        break;
    }
  }
}

export default PCBody;
