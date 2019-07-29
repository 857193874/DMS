import { FETCH_SUCCESS, FETCH_FAILD } from '../actions/power';

const initState = {};

export default function(state = initState, action) {
  switch (action.type) {
    case FETCH_SUCCESS:
      return {
        ...state,
        ...action.payload
      };
    case FETCH_FAILD:
      console.log(action.payload);
      return initState;
    default:
      return state;
  }
}
