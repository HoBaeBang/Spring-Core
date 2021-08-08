import { combineReducers } from 'redux';
import auth, { authSaga } from './auth';
import loading from './loading';
import { all } from 'redux-saga/effects';
import user, { userSaga } from './user';

const rootReducer = combineReducers({
  auth,
  loading,
  user,
});

//루트 사가 생성
export function* rootSaga() {
  yield all([authSaga(), userSaga()]);
}

export default rootReducer;
