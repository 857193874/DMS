import { FETCH_MAINTAIN_LIST_SUCCESS, FETCH_OUT_LIST_SUCCESS } from '../actions/apply';

const initState = {
  maintainList: [],
  outList: []
};

export default function(state = initState, action) {
  switch (action.type) {
    case FETCH_MAINTAIN_LIST_SUCCESS:
      return {
        ...state,
        maintainList: [
          ...action.payload
        ]
      };
    case FETCH_OUT_LIST_SUCCESS:
      return {
        ...state,
        outList: [
          ...action.payload
        ]
      };
    default:
      return state;
  }
}
