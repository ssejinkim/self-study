<script setup lang="ts">
  import { reactive, ref } from 'vue'

  const counter = reactive({
    count : 0
  })

  console.log('before', counter.count)
  counter.count++
  console.log('after', counter.count)

  const message = ref('hello world')

  console.log('before', message.value)
  message.value = 'hello, ref'
  console.log('after', message.value)

</script>

<template>
  <div>
    <h1>Declarative Rendering</h1>
    <h2>counter is: {{counter.count}}</h2>
    <h2>{{message}}</h2>
    <h2>{{message.split('').reverse().join('')}}</h2>
  </div>
</template>
