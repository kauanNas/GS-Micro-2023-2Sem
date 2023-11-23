# GS-Micro-2023-2Sem

## Integrantes
- Felipe Eiji - RM: 87399
- Kauan Nascimento - RM: 87318
- Vitor Francisco - RM: 88930

## BACKEND
- Crie um database chamado gs no mysql local
- Rode a aplicação que as tabelas serão criadas automaticamente
- Abra o postman e com o método GET ultilize as urls: http://localhost/objetivos && http://localhost/indicador/{id} para obter os dados dos endpoints, substitua o {id} por um id que você deseja, exemplo: http://localhost/indicador/1
- Temos outros dois endpoints, entretando são focados para exibir os dados no frontend, mas também podem ser testados no postman, urls: http://localhost/indicadores &&  http://localhost/buscaMetricas/{id} , substitua o {id} dessa vez, por um id/codigo de indicador, exemplo: http://localhost/buscaMetricas/3.1.1

## FRONTEND
- Para rodar o frontend, primeiro rode o backend, logo após subir o backend, abra um terminal na pasta do frontend e digite npm i(é necessário ter o node instalado), depois digite npm run serve que irá subir o frontend, aperte no link que será exibido no terminal para visualizar em seu navegador.

## TESTES
- Os testes de integração fiz na pasta do backend ultilizando mock, para acessá-los e rodá-los navegue até a pasta de teste: backend/src/test/java/br/com/fiap/global/backend você encontrará duas pastas controller e service, acessando cada uma delas você terá as classes de testes, basta apenas rodá-las e ver os testes funcionando.
- Os testes de carga esão na pasta test no início do projeto, primeiro suba a aplicação backend e dps abra um terminal nessa pasta de test e primeiro digite "choco install k6 -y --force" depois digite "k6 run scripts.js" que os testes de carga irão roda 
