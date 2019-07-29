import { combineReducers } from 'redux';

import user from './user';
import power from './power';
import apply from './apply';
import other from './other';

const reducer = combineReducers({
  user,
  power,
  apply,
  other
});
export default reducer;
