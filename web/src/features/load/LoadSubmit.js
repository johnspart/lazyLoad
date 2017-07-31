import {SubmissionError} from 'redux-form'
import types from '../../core/ActionTypes';
import api from './LoadServiceAPI';

export function loadSubmit(values, dispatch) {
  let sendValues = {
    numeroDocumento: values.numeroDocumento,
    file: null
  };
  if (values.file) {
    sendValues.file = readTextFile(URL.createObjectURL(values.file[0]));
  }
  return api.load(sendValues).then((resp) => {
    dispatch({type: types.LOAD_FILE_SUCCESS, data: resp});
  }).catch((error) => {
    console.error(error);
    throw new SubmissionError({numeroDocumento: 'No se puede cargar', _error: '¡Fallo en el servidor!'})
  });
}

export function readTextFile(file) {
  var rawFile = new XMLHttpRequest();
  var allText = "";
  rawFile.open("GET", file, false);
  rawFile.onreadystatechange = function() {
    if (rawFile.readyState === 4) {
      if (rawFile.status === 200 || rawFile.status == 0) {
        allText = rawFile.responseText;
      }
    }
  }
  rawFile.send(null);
  return allText;
}

export function validate(values) {
  const errors = {}
  if (!values.numeroDocumento) {
    errors.numeroDocumento = 'Requerido'
  } else if (values.numeroDocumento.length < 5) {
    errors.numeroDocumento = 'Debe tener 5 caracteres o mas'
  }

  if (!values.file) {
    errors.file = 'Requerido'
  }

  return errors
}
