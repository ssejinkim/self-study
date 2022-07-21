<script setup lang="ts">

import { ref } from 'vue'

const titleClass = ref('title')

</script>

<template>
    <div>
        <h1 v-bind:class="titleClass">Make me red</h1>
        <h1 :class="titleClass">Make me red</h1>
    </div>
</template>

<style>
.title {
    color: red;
}
</style>
