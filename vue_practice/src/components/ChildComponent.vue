<template>
  <div>{{ props.sendProps1 }}</div>
  <div>{{ props.sendProps2 }}</div>
  <div>{{ props.sendProps3.name }}</div>
</template>

<script setup>
const props = defineProps({
  sendProps1: String,
  sendProps2: Number,
  sendProps3: Object
})

console.log(props)
</script>