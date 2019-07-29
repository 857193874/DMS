import axios from 'axios';
import { baseURL } from '../common/axios-config';

export const FETCH_VISITNUM_SUCCESS = 'FETCH_VISITNUM_SUCCESS';
export const FETCH_VISITNUM_FAILD = 'FETCH_VISITNUM_FAILD';
export const ADD_VISITNUM_SUCCESS = 'ADD_VISITNUM_SUCCESS';
export const ADD_VISITNUM_FAILD = 'ADD_VISITNUM_FAILD ';

export function fetch(callback = () => {}) {
  const success = payload => {
    callback();
    return {
      type: FETCH_VISITNUM_SUCCESS,
      payload
    };
  };
  const faild = err => {
    return {
      type: FETCH_VISITNUM_FAILD,
      payload: {
        err
      }
    };
  };
  return async dispatch => {
    let res = await axios.get(`${baseURL}/api/v1/visit/query/logger`);
    if (res.data.status === 200) {
      return dispatch(success(res.data.data.logger));
    } else {
      return dispatch(faild(res.msg));
    }
  };
}
export function add(callback = () => {}) {
  const success = payload => {
    callback();
    return {
      type: ADD_VISITNUM_SUCCESS,
      payload
    };
  };
  const faild = err => {
    return {
      type: ADD_VISITNUM_FAILD,
      payload: {
        err
      }
    };
  };
  return async dispatch => {
    let res = await axios.post(`${baseURL}/api/v1/visit/add`);
    if (res.data.status === 200) {
      return dispatch(success());
    } else {
      return dispatch(faild(res.msg));
    }
  };
}
