<template>
  <div id="main">
    <h1 v-for="item in datos" :key="item.index">Reportes</h1>
    {{item.a}}
  </div>
</template>
