import { FETCH_VISITNUM_SUCCESS, FETCH_VISITNUM_FAILD } from '../actions/other';

import { Toast } from 'antd-mobile';
const initState = {};

export default function(state = initState, action) {
  switch (action.type) {
    case FETCH_VISITNUM_SUCCESS:
      return {
        ...state,
        ...action.payload
      };
    case FETCH_VISITNUM_FAILD:
      console.log(action.payload);
      return state;
    default:
      return state;
  }
}
