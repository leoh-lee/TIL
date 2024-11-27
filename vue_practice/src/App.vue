<template>
  <div>
    <ChildComponent :sendProps1="title" :sendProps2="createAt" :sendProps3="obj"></ChildComponent>
  </div>
</template>

<script setup>
import ChildComponent from './components/ChildComponent.vue';
import { ref, reactive } from 'vue'

const title = ref('제목')
const createAt = ref(2024)
const obj = reactive({
  id: 2024,
  name: 'john'
})
</script>