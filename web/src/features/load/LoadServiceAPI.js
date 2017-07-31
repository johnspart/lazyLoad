import common from '../../core/CommonAPI';
import config from '../../core/Config';
import fetchJsonp from 'fetch-jsonp';

export default {
    load : data => fetch(config.endpoint.load, {
        method: 'POST',
        mode: 'cors',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(common.status).then(r => r.json())
}
