import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
    vus: 100,
    duration: '300s',
};

export default function(){
    http.get('http://localhost:8080/indicador/1');
    sleep(1);
    http.get('http://localhost:8080/indicadores');
    sleep(1);
    http.get('http://localhost:8080/buscaMetricas/3.1.1');
    sleep(1);
    http.get('http://localhost:8080/objetivos');
    sleep(1);
}