import GetIndicador from "./cenarios/Get.Indicador.js";
import { group, sleep } from "k6";

export default () => {
    group('Endpoint Get indicador - Controller Indicador - backend.Api', () => {
        GetIndicador();
    });

    sleep(1);
}