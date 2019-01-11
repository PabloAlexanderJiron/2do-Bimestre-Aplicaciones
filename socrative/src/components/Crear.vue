  <template>
  <div id="app">
    <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h1>Crear Cuestionario</h1>
          </div>
        </div>
        <div class="row">
          <div class="col-md-4">
            <form>
              <div class="form-group">
                <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Nombre del Cuestionario">
              </div>
            </form>
          </div>
          <div class="col-md-8 text-right">
            <button type="button" class="btn btn-primary text-right"> Guardar Cuestionario </button>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12">
            <label for="exampleInputEmail1">Preguntas</label>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12">
            <button type="button" class="btn btn-primary" v-on:click="mostrarFormulario('contenedor');/*sing*/"> + Multiple Choice </button>
            <button type="button" class="btn btn-success"> + True / False </button>
            <button type="button" class="btn btn-warning"> + Short Answer </button>
          </div>
        </div>
        <div class="row" id="contenedor" style="display:none">
          <h2>hola</h2>
        </div>
    </div>
  </div>
</template>
<script>
  export default {
    el:'#App',
    data:{
      name:"",
      gender:"n"
    },
    methods:{
      /*sing: function(){
        alert('sing up..');
      }*/
      mostrarFormulario: function(id){
        	var contenedor=document.getElementById(id);
	        contenedor.style.display="block";
      }
    }
  }
</script>