<script setup lang="ts">
import { ref } from 'vue';
import type { Ref } from 'vue';

type Todo = { id: number, text: string }

let id = 0

const newTodo: Ref<string> = ref('')
const todos: Ref<Array<Todo>> = ref([
    { id: id++, text: 'Learn HTML' },
    { id: id++, text: 'Learn JavaScript' },
    { id: id++, text: 'Learn Vue' },
])

function addTodo() {
    console.log('addTodo')
    todos.value.push({ id: id++, text: newTodo.value })
    newTodo.value =''
}

function removeTodo(todo: Todo) {
  todos.value = todos.value.filter((t) => t !== todo)
}

</script>

<template>
    <div>
        <form @submit.prevent="addTodo">
            <input v-model="newTodo">
            <button>Add Todo</button>
        </form>
    </div>
    <ul>
        <li v-for="todo in todos" :key="todo.id">
            {{ todo.text }}
            <button @click="removeTodo(todo)">X</button>
        </li>
    </ul>
</template>