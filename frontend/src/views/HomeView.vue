<script setup>

const originAccount = "João"

function showData() {
  console.log({
    originAccount: originAccount
  })
}

</script>

<template>
  <main>
    <h1 class="display-2 mb-3">Fazer transferencia</h1>

    <div class="bg-light p-3 w-50 mx-auto border">

        <div class="mb-3">          
          <label class="form-label" for="originAccount">Conta de Origem:</label>
          <input class="form-control" type="text" v-model="originAccount" required>
        </div>

        <div class="mb-3">
          <label class="form-label" for="destinyAccount">Conta de Destino:</label>
          <input class="form-control" type="text" id="destinyAccount" name="destinyAccount" value="Maria" required>
        </div>

        <div class="mb-3">
          <label class="form-label" for="value">Valor:</label>
          <input class="form-control" type="number" step="0.01" id="value" name="value" value="1000.00" required>
        </div>

        <div class="mb-3">
          <label class="form-label" for="transactionDate">Data da Transferência:</label>
          <input class="form-control" type="date" id="transactionDate" name="transactionDate" value="2023-10-27" required>
        </div>

        <div class="mb-3">
          <label class="form-label" for="scheduleDate">Data de Agendamento:</label>
          <input class="form-control" type="date" id="scheduleDate" name="scheduleDate" value="2023-10-01" required>
        </div>

        <button class="btn btn-primary btn-lg" type="button" @click="showData">Enviar</button>
    </div>
  </main>
</template>
