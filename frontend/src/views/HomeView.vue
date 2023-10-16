<script setup>

let originAccount = "João"
let destinyAccount = "Maria"
let value = 1000.00
let transactionDate = ""
let scheduleDate = ""

function showData() {
  console.log({
    "originAccount": originAccount,
		"destinyAccount": destinyAccount,
		"value": value,
		"transactionDate": transactionDate,
		"scheduleDate": scheduleDate
  })
}

</script>

<template>
  <main>
    <h1 class="display-2 mb-3">Fazer transferencia</h1>

    <div class="bg-light p-3 w-50 mx-auto border">

        <div class="mb-3">          
          <label class="form-label" for="originAccount">Conta de Origem:</label>
          <input class="form-control" type="text" id="originAccount" name="originAccount" v-model="originAccount" required>
        </div>

        <div class="mb-3">
          <label class="form-label" for="destinyAccount">Conta de Destino:</label>
          <input class="form-control" type="text" id="destinyAccount" name="destinyAccount" v-model="destinyAccount" required>
        </div>

        <div class="mb-3">
          <label class="form-label" for="value">Valor:</label>
          <input class="form-control" type="number" step="0.01" id="value" name="value" v-model="value" required>
        </div>

        <div class="mb-3">
          <label class="form-label" for="transactionDate">Data da Transferência:</label>
          <input class="form-control" type="date" id="transactionDate" name="transactionDate" v-model="transactionDate" required>
        </div>

        <div class="mb-3">
          <label class="form-label" for="scheduleDate">Data de Agendamento:</label>
          <input class="form-control" type="date" id="scheduleDate" name="scheduleDate" v-model="scheduleDate" required>
        </div>

        <button class="btn btn-primary btn-lg" type="button" @click="showData">Enviar</button>
    </div>
  </main>
</template>
