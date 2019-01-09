<template>
  <v-app>
    <h1>SocrativeApp</h1>
    <h2>Profesor</h2>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active" v-for="item in menuItems" :key="item.title" router :to="item.link">
            <a class="nav-link" href="#" router :to="item.link"> {{item.title}} <span class="sr-only">(current)</span></a>
          </li>
        </ul>
      </div>
    </nav>
    <router-view></router-view>
  </v-app>
</template>

<script>
export default {
  name: 'App',
  data(){
    return{
      sideNav: false,
      menuItems:[
        {title:'Crear', link:'/crear'},
        {title:'Lanzar', link:'/lanzar'},
        {title:'Cuestionarios', link:'/quiz'},
        {title:'Reportes', link:'/rep'}
      ]
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
