<script setup lang="ts">
import { onMounted, ref, type Ref } from 'vue'
const p: Ref<HTMLElement | null> = ref(null)

onMounted(() => {
    if (p.value)
        p.value.textContent = 'mounted!'
})
</script>

<template>
    <p ref="p">hello</p>
</template>