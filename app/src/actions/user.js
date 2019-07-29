import axios from 'axios';
import qs from 'qs';
import { baseURL } from '../common/axios-config';

export const LOGIN_SUCCESS = 'LOGIN_SUCCESS';
export const LOGIN_FAILD = 'LOGIN_FAILD';
export const CHECK_USER_SUCCESS = 'CHECK_USER_SUCCESS';
export const CHECK_USER_FAILD = 'CHECK_USER_FAILD';
export const EDIT_USER_INFO_SUCCESS = 'EDIT_USER_INFO_SUCCESS';
export const EDIT_USER_INFO_FAILD = 'EDIT_USER_INFO_FAILD';
export const LOGOUT_SUCCESS = 'LOGOUT_SUCCESS';
export const LOGOUT_FAILD = 'LOGOUT_FAILD';

export function login({ studentUsername, studentPassword }, callback = () => {}) {
  const success = payload => {
    callback();
    return {
      type: LOGIN_SUCCESS,
      payload
    };
  };
  const faild = err => {
    return {
      type: LOGIN_FAILD,
      payload: {
        err
      }
    };
  };
  return async dispatch => {
    let res = await axios.post(`${baseURL}/api/v1/student/login`, qs.stringify({ studentUsername, studentPassword }), {
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
      }
    });
    if (res.data.status === 200) {
      return dispatch(
        success({
          ...res.data.data.student,
          ...res.data.data.domitory
        })
      );
    } else {
      return dispatch(faild(res.msg));
    }
  };
}

export function logout() {
  const success = payload => {
    return {
      type: LOGOUT_SUCCESS,
      payload
    };
  };
  const faild = err => {
    return {
      type: LOGOUT_FAILD,
      payload: {
        err
      }
    };
  };
  return async dispatch => {
    let res = await axios.get(`${baseURL}/api/v1/student/logout`);
    if (res.data.status === 200) {
      return dispatch(success());
    } else {
      return dispatch(faild(res.msg));
    }
  };
}

export function checkUser(fallback = () => {}) {
  const success = payload => {
    return {
      type: CHECK_USER_SUCCESS,
      payload
    };
  };
  const faild = err => {
    fallback();
    return {
      type: CHECK_USER_FAILD,
      payload: {
        err
      }
    };
  };
  return async dispatch => {
    let res = await axios.get(`${baseURL}/api/v1/student/chacklogin`);
    if (res.data.status === 200) {
      return dispatch(
        success({
          ...res.data.data.student,
          ...res.data.data.domitory
        })
      );
    } else {
     
      return dispatch(faild(res.data.msg));
    }
  };
}

export function editUserInfo({ studentUsername, studentPassword }, callback = () => {}) {
  const success = payload => {
    callback();
    return {
      type: EDIT_USER_INFO_SUCCESS,
      payload
    };
  };
  const faild = err => {
    return {
      type: EDIT_USER_INFO_FAILD,
      payload: {
        err
      }
    };
  };
  return async dispatch => {
    let res = await axios.post(`${baseURL}/api/v1/student/update/${studentUsername}`, qs.stringify({ studentPassword }), {
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
