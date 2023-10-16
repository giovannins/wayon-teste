<script setup>
import axios from "axios";
import { ref } from 'vue';

const date = new Date();

let originAccount = ref("João")
let destinyAccount = ref("Maria")
let value = ref(987.65)
let transactionDate = ref("2023-10-20")
let scheduleDate = ref(`${date.getFullYear()}-${date.getMonth() + 1}-${date.getDate()}`)
let transferenciaInvalida = ref(false)

function validateInputs() {
  if (
    originAccount.value == '' ||
    destinyAccount.value == '' ||
    value.value <= 0 ||
    transactionDate.value == '' ||
    scheduleDate.value == ''
  ) {
    return false
  } else {
    return true
  }
}

function saveTransaction() {

  if (validateInputs()) {
    const options = {
      method: 'POST',
      url: 'http://localhost:8080/transaction/create',
      headers: { 'Content-Type': 'application/json' },
      data: {
        "originAccount": originAccount.value,
        "destinyAccount": destinyAccount.value,
        "value": value.value,
        "transactionDate": transactionDate.value,
        "scheduleDate": scheduleDate.value
      }
    };

    axios.request(options).then(function (response) {
      console.log(response.data);
      alert("Cadastrado com sucesso!")
    }).catch(function (error) {
      console.error(error.response.data);
      alert(error.response.data.message);
      transferenciaInvalida.value = !transferenciaInvalida.value
    });
  } else {
    alert("Por favor, preencher todos os campos!")
  }
}

</script>

<template>
  <main>
    <h1 class="display-2 mb-3">Fazer transferencia</h1>
    <hr>

    <div class="bg-light p-3 w-50 mx-auto border">
      <div class="mb-3">
        <label class="form-label" for="originAccount">Conta de origem:</label>
        <input class="form-control" type="text" id="originAccount" name="originAccount" v-model="originAccount" required>
        <span v-if="originAccount == ''" class="text-danger">Campo obrigátorio para transferencia</span>
      </div>

      <div class="mb-3">
        <label class="form-label" for="destinyAccount">Conta de destino:</label>
        <input class="form-control" type="text" id="destinyAccount" name="destinyAccount" v-model="destinyAccount"
          required>
        <span v-if="destinyAccount == ''" class="text-danger">Campo obrigátorio para transferencia</span>
      </div>

      <div class="mb-3">
        <label class="form-label" for="value">Valor:</label>
        <input class="form-control" type="number" step="0.01" id="value" name="value" v-model.number="value" required>
        <span v-if="value <= '0'" class="text-danger">Campo obrigátorio para transferencia</span>
      </div>

      <div class="mb-3">
        <label class="form-label" for="transactionDate">Data da transferência:</label>
        <input class="form-control" type="date" id="transactionDate" name="transactionDate" v-model="transactionDate"
          required>
        <span v-if="transactionDate == ''" class="text-danger">Campo obrigátorio para transferencia</span>

      </div>

      <div class="mb-3">
        <label class="form-label" for="scheduleDate">Data de agendamento:</label>
        <input class="form-control" type="date" id="scheduleDate" name="scheduleDate" v-model="scheduleDate" required>
        <span v-if="scheduleDate == ''" class="text-danger">Campo obrigátorio para transferencia</span>
        <span v-if="transferenciaInvalida" class="text-danger">A <strong>Data de transferência</strong> deve ser maior que
          a <strong>Data de agendamento</strong> em até no maximo <strong>50 dias</strong></span>
      </div>

      <button class="btn btn-primary btn-lg" type="button" @click="saveTransaction">Enviar</button>

    </div>
  </main>
</template>
