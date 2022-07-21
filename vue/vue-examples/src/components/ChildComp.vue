<script setup lang="ts">
const emit = defineEmits(['response'])
const emitToParent = () => emit('response', 'hello from child')
</script>

<template>
    <h2>A Child Component!</h2>
    <button @click="emitToParent">emit</button>
</template>