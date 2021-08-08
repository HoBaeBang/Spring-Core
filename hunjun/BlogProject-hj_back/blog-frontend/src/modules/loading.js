import { createAction, handleActions } from 'redux-actions';

//액션 생성
const START_LOADING = 'loading/START_LOADING';
const FINISH_LOADING = 'loading/FINISH_LOADING';

//액션 함수 정의
export const startLoading = createAction(
  START_LOADING,
  (requestType) => requestType,
);

export const finishLoading = createAction(
  FINISH_LOADING,
  (requestType) => requestType,
);

//초기 상태
const initialState = {};

//로딩 리듀서
const loading = handleActions(
  {
    [START_LOADING]: (state, action) => ({
      ...state,
      [action.payload]: true,
    }),
    [FINISH_LOADING]: (state, action) => ({
      ...state,
      [action.payload]: false,
    }),
  },
  initialState,
);

export default loading;
