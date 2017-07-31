import { combineReducers } from 'redux';
import { reducer as reduxFormReducer } from 'redux-form';

import * as loadServiceReducers from '../features/load/LoadServiceReducers';
import * as mainReducers from '../features/main/MainReducers';

export default combineReducers(Object.assign({},
    { form: reduxFormReducer },
    loadServiceReducers,
    mainReducers,
));
