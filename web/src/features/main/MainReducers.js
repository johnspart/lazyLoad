import types from '../../core/ActionTypes';

let initial = {};

export function rMain(state = initial, action) {
  switch (action.type) {
    case types.MAIN_LOAD:
      console.log("MAIN INICIO");
      console.log(state);
      
      console.log("MAIN FIN");
      return state;
    default:
      return state;
  }
}
