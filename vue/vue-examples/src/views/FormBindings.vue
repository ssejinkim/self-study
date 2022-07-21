<script setup lang="ts">
import { ref } from "vue"

const text = ref("")
const onInput = (e: Event) => text.value = (<HTMLInputElement>e.target).value

const text2 = ref("")
</script>

<template>
    <div>
        <input :value="text" @input="onInput" placeholder="Type here">
        <p>{{ text }}</p>
        <input v-model="text2">
        <p>{{ text2 }}</p>
    </div>
</template>