import http from 'k6/http';
import {sleep} from 'k6';
import {Trend, Rate, Counter} from "k6/metrics";
import {check, fail} from "k6";


export let GetIndicadorDuration = new Trend('get_indicador_duration');
export let GetIndicadorFailRate = new Rate('get_indicador_fail_rate');
export let GetIndicadorSuccessRate = new Rate('get_indicador_success_rate');
export let GetIndicadorReqs = new Rate('get_customer_reqs');

export default function(){
    let res = http.get('http://localhost:8080/indicador/1')

    GetIndicadorDuration.add(res.timings.duration);
    GetIndicadorReqs.add(1);
    GetIndicadorFailRate.add(res.status == 0 || res.status > 399);
    GetIndicadorSuccessRate.add(res.status < 399);

    let durationMsg = 'Max Duration ${4000/1000}s'
    if(!check(res, {
        'max duration': (r) => r.timings.duration < 4000, 
    })){
        fail(durationMsg);
    }

    sleep(1);
}