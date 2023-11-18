<template>
  <div class="home">
    <h1>Indicadores ODS3</h1>
    <v-client-table :data="rows" :columns="columns">
      <div slot="Indicadores" slot-scope="scope">
        <router-link :to="'/metricas/' + scope.row.Indicadores">
          {{ scope.row.Indicadores }}
        </router-link>
      </div>
    </v-client-table>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      columns: ['Indicadores'],
      rows: [],
    };
  },

  mounted() {
    this.fetchData();
  },

  methods: {
    fetchData() {
      const apiUrl = 'http://localhost:8080/indicadores';

      axios
        .get(apiUrl)
        .then((response) => {
          this.rows = response.data.map((indicador) => ({
            Indicadores: indicador.codigo,
            id: indicador.id
          }));
        })
        .catch((error) => {
          console.error('Erro ao buscar dados:', error);
        });
    },
  },
};
</script>

