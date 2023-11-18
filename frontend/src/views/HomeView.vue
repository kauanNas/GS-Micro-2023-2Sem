<template>
  <div class="home">
    <h1>Indicadores ODS3</h1>
    <v-client-table :data="rows" :columns="columns" :options="options">
      <template slot="child_row" slot-scope="props">
        <div>
          <p>Descrição: {{ props.row.descricao }}</p>
          <p>Ano: {{ props.row.ano }}</p>
          <p>consumo: {{ props.row.consumo }}</p>
        </div>
      </template>
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
      openChildRowId: null, // ID da child row atualmente aberta
      options: {
        childRow: true,
      },
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
            descricao: indicador.descricao, 
            ano: indicador.ano,
            consumo: indicador.consumo,
            id: indicador.id
          }));
        })
        .catch((error) => {
          console.error('Erro ao buscar dados:', error);
        });
    },

    // Método para abrir ou fechar a child row
    toggleChildRow(row) {
      if (this.openChildRowId === row.id) {
        // Se a child row estiver aberta, feche
        this.openChildRowId = null;
      } else {
        // Se a child row estiver fechada, abra
        this.openChildRowId = row.id;
      }
    },

    // Método para verificar se uma child row está aberta
    isChildRowOpen(row) {
      return this.openChildRowId === row.id;
    },
  },
};
</script>

<style scoped>

body{
  background-color: #d4ecff;
  display: flex;
  align-items: center;
  justify-content: center;
}

::v-deep(.VueTables__child-row-toggler) {
  width: 16px;
  height: 16px;
  line-height: 16px;
  display: block;
  margin: auto;
  text-align: left;
}

::v-deep(.VueTables__child-row-toggler--closed::before) {
  content: "+";
}

::v-deep(.VueTables__child-row-toggler--open::before) {
  content: "-";
}

</style>
