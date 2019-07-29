import { LOGIN_SUCCESS, CHECK_USER_SUCCESS, LOGIN_FAILD, CHECK_USER_FAILD } from '../actions/user';

import { Toast } from 'antd-mobile';
const initState = {};

export default function(state = initState, action) {
  switch (action.type) {
    case LOGIN_SUCCESS:
    case CHECK_USER_SUCCESS:
      return {
        ...state,
        ...action.payload
      };
    case LOGIN_FAILD:
      Toast.fail('用户名或密码错误', 1);
      return state;
    case CHECK_USER_FAILD:
      console.log(action.payload);
      return state;
    default:
      return state;
  }
}
