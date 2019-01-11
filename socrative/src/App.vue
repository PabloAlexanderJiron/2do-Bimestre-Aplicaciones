<template>
  <v-app>
    <h1>SocrativeApp</h1>
    <h2>Profesor</h2>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active" v-for="item in menuItems" :key="item.title">
            <a class="nav-link" v-build:href="item.link"><router-link :to="item.link">{{item.title}}</router-link> <span class="sr-only">(current)</span></a>
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
        {title:'Lanzar', link:'/lanzar'},
        {title:'Crear Cuestionario', link:'/crear'},
        {title:'Visualizar Cuestionarios', link:'/cuestionarios'},
        {title:'Reportes', link:'/reportes'}
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
