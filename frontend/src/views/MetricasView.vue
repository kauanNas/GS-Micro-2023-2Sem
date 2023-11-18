<template>
  <div>
    <h1>Métricas para o Id: {{this.$route.params.id}}</h1>
    <v-client-table :data="rows" :columns="columns">
    </v-client-table>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      columns: ['Ano', 'Consumo', 'Descrição', 'Região'],
      rows: [],
    };
  },

  mounted() {
    this.fetchData();
  },

  methods: {
    fetchData() {
      const id = this.$route.params.id;
      const apiUrl = 'http://localhost:8080/buscaMetricas/' + id;

      axios
          .get(apiUrl)
          .then((response) => {
            this.rows = response.data.map((metricas) => ({
              Ano: metricas.ano,
              Consumo: metricas.consumo,
              Descrição: metricas.descricao,
              Região: metricas.regiao
            }));
          })
          .catch((error) => {
            console.error('Erro ao buscar dados:', error);
          });
    },
  }
};

</script>