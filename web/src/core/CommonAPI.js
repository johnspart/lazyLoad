import 'whatwg-fetch';
import types from './ActionTypes';
import config from './Config';

const success = resp => resp.status >= 200 && resp.status < 300;
const serverError = resp => resp.status == 500;

const cleanState = () => {
    window.location.reload();
};

export default {
    status : resp => success(resp)
        ? Promise.resolve(resp)
        : serverError(resp)
            ? cleanState()
            : Promise.reject(resp),
    json : response => response.json()
};
