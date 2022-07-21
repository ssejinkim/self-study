<script setup lang="ts">
import { ref } from 'vue';
import Message from '@/components/Message.vue' 

const greeting = ref('Hello from parent')
</script>

<template>
    <Message :msg="greeting" />
</template>