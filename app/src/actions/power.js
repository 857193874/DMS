import axios from 'axios';
import qs from 'qs';
import { baseURL } from "../common/axios-config";

export const FETCH_SUCCESS = 'FETCH_SUCCESS';
export const FETCH_FAILD = 'FETCH_FAILD';

export function fetch({ buildingId }) {
  const success = payload => {
    return {
      type: FETCH_SUCCESS,
      payload
    };
  };
  const faild = err => {
    return {
      type: FETCH_FAILD,
      payload: {
        err
      }
    };
  };
  return async dispatch => {
    let res = await axios.get(`${baseURL}/api/v1/power/query/bybuilding?${qs.stringify({ buildingId })}`);
    if (res.data.status === 200) {
      return dispatch(success(res.data.data.power[0]));
    } else {
      return dispatch(faild(res.msg));
    }
  };
}
