<script setup lang="ts">
import { ref } from 'vue';

type Todo = { id: number, text: string }

let id = 0

const newTodo: string = ref('')
const todos: Array<Todo> = ref([
    { id: id++, text: 'Learn HTML' },
    { id: id++, text: 'Learn JavaScript' },
    { id: id++, text: 'Learn Vue' },
])

function addTodo() {

}

function removeTodo(todo: Todo) {

}
</script>

<template>
    <div>
        <from @submit.prevent="addTodo">
            <input v-model="newTodo">
            <button>Add Todo</button>
        </from>
    </div>
    <ul>
        <li v-for="todo in todos" :key="todo.id">
        </li>
    </ul>
</template>