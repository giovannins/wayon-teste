<script setup>
import axios from "axios";
import { ref } from "vue";

var dataStatements = ref()
var dataLoading = ref(true);

const options = {
  method: 'GET',
  url: 'http://localhost:8080/transaction/statements',
}

axios.request(options).then(function (response) {
  dataStatements.value = response.data
  dataLoading.value = !dataLoading.value
}).catch(function (error) {
  console.error(error)
});

function formatarData(dataOriginal) {
  const partesData = dataOriginal.split('-');
  const ano = partesData[0];
  const mes = partesData[1];
  const dia = partesData[2];

  const dataFormatada = `${dia}/${parseInt(mes) + 1}/${ano}`;

  return dataFormatada;
}
</script>

<template>
  <div>
    <h1 class="display-2 mb-3">Extrato</h1>
    <hr>

    <div class="container">

      <table class="table table-light table-striped" v-if="!dataLoading">
        <thead>
          <tr>
            <th scope="col">Id</th>
            <th scope="col">Conta de origem</th>
            <th scope="col">Conta de destino</th>
            <th scope="col">Valor</th>
            <th scope="col">Taxa</th>
            <th scope="col">Total</th>
            <th scope="col">Data da transferencia</th>
            <th scope="col">Data agendada</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="transaction in dataStatements" :key="transaction.id">
            <th scope="row">{{ transaction.id }}</th>
            <td>{{ transaction.originAccount }}</td>
            <td>{{ transaction.destinyAccount }}</td>
            <td>R${{ transaction.value }}</td>
            <td>R${{ transaction.tax }}</td>
            <td>R${{ transaction.value + transaction.tax }}</td>
            <td>{{ formatarData(transaction.transactionDate) }}</td>
            <td>{{ formatarData(transaction.scheduleDate) }}</td>
          </tr>

        </tbody>
      </table>
      <div class="spinner-border" role="status" v-if="dataLoading">
        <span class="visually-hidden">Loading...</span>
      </div>
    </div>
  </div>
</template>