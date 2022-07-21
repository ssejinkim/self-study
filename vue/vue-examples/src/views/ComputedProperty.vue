<script setup lang="ts">
import { computed, ref, type ComputedRef } from 'vue';
import type { Ref } from 'vue';

type Todo = { id: number, text: string, done: boolean }

let id = 0

const newTodo: Ref<string> = ref('')
const hideCompleted: Ref<boolean> = ref(false)
const todos: Ref<Array<Todo>> = ref([
    { id: id++, text: 'Learn HTML', done: true },
    { id: id++, text: 'Learn JavaScript', done: true },
    { id: id++, text: 'Learn Vue', done: false },
])

const filteredTodos: ComputedRef = computed(() => {
    return hideCompleted.value
        ? todos.value.filter((t) => !t.done)
        : todos.value
})

function addTodo() {
    todos.value.push({ id: id++, text: newTodo.value, done: false })
    newTodo.value = ''
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
        <li v-for="todo in filteredTodos" :key="todo.id">
            <input type="checkbox" v-model="todo.done">
            <span :class="{ done: todo.done }">{{ todo.text }}</span>
            <button @click="removeTodo(todo)">X</button>
        </li>
    </ul>
    <button @click="hideCompleted = !hideCompleted">{{ hideCompleted? 'Show all' : 'Hide completed' }}</button>
</template>

<style>
.done {
    text-decoration: line-through;
}
</style>