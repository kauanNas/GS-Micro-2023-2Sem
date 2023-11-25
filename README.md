# GS-Micro-2023-2Sem

## Integrantes
- Felipe Eiji - RM: 87399
- Kauan Nascimento - RM: 87318
- Vitor Francisco - RM: 88930

## DIAGRAMAS DER E MER
![image](https://github.com/kauanNas/GS-Micro-2023-2Sem/assets/101115741/32210a11-e8da-45aa-87d3-7226fb848d00)
![image](https://github.com/kauanNas/GS-Micro-2023-2Sem/assets/101115741/243f9cee-8440-4b1c-93ef-798588f8f76c)
![image](https://github.com/kauanNas/GS-Micro-2023-2Sem/assets/101115741/50c294c1-35d5-450e-a7c8-b1b22a4b3b1e)
![image](https://github.com/kauanNas/GS-Micro-2023-2Sem/assets/101115741/bcd50e85-751f-485f-a32d-0eb2df56301f)


## BACKEND
- Crie um database chamado gs no mysql local
- Rode a aplicação que as tabelas e os dados serão criados automaticamente
- Abra o postman e com o método GET ultilize as urls: http://localhost:8080/objetivos && http://localhost:8080/indicador/{id} para obter os dados dos endpoints, substitua o {id} por um id que você deseja, exemplo: http://localhost:8080/indicador/1
- Temos outros dois endpoints, entretando são focados para exibir os dados no frontend, mas também podem ser testados no postman, urls: http://localhost:8080/indicadores &&  http://localhost:8080/buscaMetricas/{id} , substitua o {id} dessa vez, por um id/codigo de indicador, exemplo: http://localhost:8080/buscaMetricas/3.1.1

- Prints tirados com o banco com dados de teste:

![image](https://github.com/kauanNas/GS-Micro-2023-2Sem/assets/101115741/1c7e0ac5-1aaa-4d49-aec8-4614414d42e4)
![image](https://github.com/kauanNas/GS-Micro-2023-2Sem/assets/101115741/696b051c-d39c-439f-bc7b-f0e37b5ad6a4) 
![image](https://github.com/kauanNas/GS-Micro-2023-2Sem/assets/101115741/28d3d0a4-fd6e-4410-83b0-fba272b5ebb8)
![image](https://github.com/kauanNas/GS-Micro-2023-2Sem/assets/101115741/7c04a1bf-0f4f-4beb-b17a-1c6f7abafc61)

- DOCKER: abra o terminal na pasta de backend e rode o comando: docker build . -t backend 

## FRONTEND
- Para rodar o frontend, primeiro rode o backend, logo após subir o backend, abra um terminal na pasta do frontend e digite npm i(é necessário ter o node instalado), depois digite npm run serve que irá subir o frontend, aperte no link que será exibido no terminal para visualizar em seu navegador.

- Wireframe:
![image](https://github.com/kauanNas/GS-Micro-2023-2Sem/assets/101115741/8a9ccd2b-22e5-41cd-b334-83e119a9dd26)
![image](https://github.com/kauanNas/GS-Micro-2023-2Sem/assets/101115741/eb84a788-a6a4-4683-b2bb-4f23001ae218)

- Frontend funcionando:
  
![image](https://github.com/kauanNas/GS-Micro-2023-2Sem/assets/101115741/54789aaf-8d12-48f9-ac09-8ee88e6b84f8)

![image](https://github.com/kauanNas/GS-Micro-2023-2Sem/assets/101115741/eb999557-070c-49c4-94f2-0184e31dd344)


- DOCKER: abra o terminal na pasta de frontend e rode o comando: docker build . -t frontend 


## TESTES
- Os testes de integração fiz na pasta do backend ultilizando mock, para acessá-los e rodá-los navegue até a pasta de teste: backend/src/test/java/br/com/fiap/global/backend você encontrará duas pastas controller e service, acessando cada uma delas você terá as classes de testes, basta apenas rodá-las e ver os testes funcionando.
- Os testes de carga esão na pasta test no início do projeto, primeiro suba a aplicação backend e dps abra um terminal nessa pasta de test e primeiro digite "choco install k6 -y --force" depois digite "k6 run scripts.js" que os testes de carga irão rodar 

![image](https://github.com/kauanNas/GS-Micro-2023-2Sem/assets/101115741/42979f68-f208-4562-83c4-6760d6d2ad66)
![image](https://github.com/kauanNas/GS-Micro-2023-2Sem/assets/101115741/353290f8-d838-43fa-bb8c-2a1210cf6643)
![image](https://github.com/kauanNas/GS-Micro-2023-2Sem/assets/101115741/750b144c-07c2-4510-9c7a-faaef6f0b13a)
![image](https://github.com/kauanNas/GS-Micro-2023-2Sem/assets/101115741/a9cfa1b9-9e1a-4731-8fcf-8cbed4f1439c)
![image](https://github.com/kauanNas/GS-Micro-2023-2Sem/assets/101115741/0ee04693-4b48-4222-aa6c-7ccd31a1519f)

