<script setup lang="ts">
import { ref } from 'vue'
import SlotComp from '@/components/SlotComp.vue'

const msg = ref('from parent')
</script>

<template>
  <SlotComp>Message: {{ msg }}</SlotComp>
</template>