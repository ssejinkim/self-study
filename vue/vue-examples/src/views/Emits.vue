<script setup lang="ts">
import { ref } from 'vue'
import ChildComp from '@/components/ChildComp.vue'

const childMsg = ref('No child msg yet')
</script>

<template>
  <ChildComp @response="(msg: string) => childMsg = msg" />
  <p>{{ childMsg }}</p>
</template>