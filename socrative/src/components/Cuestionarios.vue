<template>
  <div id="app">
    <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h1 class="text-left">Cuestionarios</h1>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12">
            <table class="table table-hover">
              <thead class="text-left">
                  <tr>
                    <th>Nombre</th>
                    <th>Borrar</th>
                  </tr>
              </thead>
                <tbody>
                    <tr class="text-left" v-for="item in cuestionarios" :key="item.title">
                      <td> {{item.title}} </td>
                      <td><a href="#" class='btn btn-danger btn-xs'>Eliminar</a></td>
                    </tr>
                </tbody>
            </table>
          </div>
        </div>
    </div>
  </div>
</template>
<script>
export default {
  name: 'App',
  data(){
    return{
      cuestionarios:[
        {title:'Operaciones Matematicas'},
        {title:'Calculo'},
        {title:'Fechas civicas'},
        {title:'Computación paralela'}
      ]
    }
  },
  methods:{
    storiesBy: function (writer) {
      return this.stories.filter(function (story) {
        return story.writer === writer
      })
    }
  }
}
</script>