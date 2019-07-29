import axios from 'axios';
import qs from 'qs';
import { baseURL } from "../common/axios-config";

export const FETCH_MAINTAIN_LIST_SUCCESS = 'FETCH_MAINTAIN_LIST_SUCCESS';
export const FETCH_MAINTAIN_LIST_FAILD = 'FETCH_MAINTAIN_LIST_FAILD';
export const MAINTAIN_SUCCESS = 'MAINTAIN_SUCCESS';
export const MAINTAIN_FAILD = 'MAINTAIN_FAILD';
export const FETCH_OUT_LIST_SUCCESS = 'FETCH_OUT_LIST_SUCCESS';
export const FETCH_OUT_LIST_FAILD = 'FETCH_OUT_LIST_FAILD';
export const OUT_SUCCESS = 'OUT_SUCCESS';
export const OUT_FAILD = 'OUT_FAILD';

export function fetchMaintainList({ domitoryId }) {
  const success = payload => {
    return {
      type: FETCH_MAINTAIN_LIST_SUCCESS,
      payload
    };
  };
  const faild = err => {
    return {
      type: FETCH_MAINTAIN_LIST_FAILD,
      payload: {
        err
      }
    };
  };
  return async dispatch => {
    let res = await axios.get(`${baseURL}/api/v1/maintain/query/domitoryid/${domitoryId}`);
    if (res.data.status === 200) {
      return dispatch(success(res.data.data.maintain));
    } else {
      return dispatch(faild(res.data.msg));
    }
  };
}
export function fetchOutList({ studentUsername }) {
  const success = payload => {
    return {
      type: FETCH_OUT_LIST_SUCCESS,
      payload
    };
  };
  const faild = err => {
    return {
      type: FETCH_OUT_LIST_FAILD,
      payload: {
        err
      }
    };
  };
  return async dispatch => {
    let res = await axios.get(`${baseURL}/api/v1/out/query/bystudentusername?${qs.stringify({ studentUsername })}`);
    if (res.data.status === 200) {
      return dispatch(success(res.data.data.out));
    } else {
      return dispatch(faild(res.data.msg));
    }
  };
}

export function maintain({ domitoryId }, callback = () => {}) {
  const success = payload => {
    callback();
    return {
      type: MAINTAIN_SUCCESS,
      payload
    };
  };
  const faild = err => {
    return {
      type: MAINTAIN_FAILD,
      payload: {
        err
      }
    };
  };
  return async dispatch => {
    let res = await axios.post(`${baseURL}/api/v1/maintain/save`, qs.stringify({ domitoryId, maintainTime: new Date().toString(), status: '保修' }), {
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
      }
    });
    if (res.data.status === 200) {
      return dispatch(success());
    } else {
      return dispatch(faild(res.data.msg));
    }
  };
}

export function out({ outStudentid, outDate }, callback = () => {}) {
  const success = payload => {
    callback();
    return {
      type: OUT_SUCCESS,
      payload
    };
  };
  const faild = err => {
    return {
      type: OUT_FAILD,
      payload: {
        err
      }
    };
  };
  return async dispatch => {
    let res = await axios.post(`${baseURL}/api/v1/out/save`, qs.stringify({ outStudentid, outDate, outRemark: '未处理' }), {
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
      }
    });
    if (res.data.status === 200) {
      return dispatch(success());
    } else {
      return dispatch(faild(res.data.msg));
    }
  };
}
