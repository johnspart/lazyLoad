import types from '../../core/ActionTypes';
import config from '../../core/Config';

let initial = {
  load: {
    numeroDocumento: '',
    file: null
  }
};

export function load(state = initial, action) {
  switch (action.type) {
    case types.LOAD_FILE_SUCCESS:
      var a = document.createElement("a");
      document.body.appendChild(a);
      a.style = "display: none";
      let blob = new Blob([action.data.file], {type: 'text/plain'}); // pass a useful mime type here
      let url = window.URL.createObjectURL(blob);
      a.href = url;
      a.download = action.data.numeroDocumento + '.txt';
      a.click();
      window.URL.revokeObjectURL(url);

      console.log(action.data);
      return state;
    default:
      return state;
  }
}
