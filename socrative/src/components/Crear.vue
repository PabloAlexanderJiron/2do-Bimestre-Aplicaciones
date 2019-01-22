/* eslint-disable eol-last */
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
            <h3 for="exampleInputEmail1">Preguntas</h3>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12">
            <button type="button" class="btn btn-primary" @click="MO = !MO" v-on:click="anadir = true, an = true"> + Opcion Multiple </button>
            <button type="button" class="btn btn-success" @click="TF = !TF" v-on:click="anadir = true, an = true"> + Verdadero / Falso </button>
            <button type="button" class="btn btn-warning" @click="SA = !SA" v-on:click="anadir = true, an = true"> + Respuesta Corta </button>
          </div>
        </div>
        <div class="row" id="multiple" v-if="MO">
          <div class="col-md-8">
            <form>
              <div class="form-group">
                <h3>Multiple Opción</h3>
              </div>
              <div class="form-group">
                <input type="text" class="form-control" id="" placeholder=" Ingresar Pregunta... " v-model="p">
              </div>
              <br>
              <div class="form-group">
                <input type="text" class="form-control" id="" placeholder="Ingresar Respuesta... " v-model="r1">
              </div>
              <div class="form-group">
                <input type="text" class="form-control" id="" placeholder="Ingresar Respuesta... " v-model="r2">
              </div>
              <div class="form-group">
                <input type="text" class="form-control" id="" placeholder="Ingresar Respuesta... " v-model="r3">
              </div>
              <div class="form-group">
                <input type="text" class="form-control" id="" placeholder="Ingresar Respuesta... " v-model="rc">
              </div>
              <div class="form-group">
                <button class="btn btn-primary">Añadir</button>
              </div>
            </form>
          </div>
          <div class="col-md-4">
            <pre>{{$data}}</pre>
          </div>
        </div>
        <div class="row" id="truefalse" v-if="TF" >
          <div class="col-md-8">
            <form>
              <div class="form-group">
                <h3>Verdadero / Falso</h3>
              </div>
              <div class="form-group">
                <input type="text" v-model="newTodoText" class="form-control" id="new-todo" placeholder="Ingresar Pregunta... ">
              </div>
              <div class="form-group">
                <button type="button" class="btn btn-success">Verdadero</button>
                <button type="button" class="btn btn-danger">Falso</button>
              </div>
              <button>Añadir</button>
            </form>
          </div>
          <div class="col-md-4">
            <pre>{{$data}}</pre>
          </div>
        </div>
        <div class="row" id="ShortAnswer" v-if="SA" >
          <div class="col-md-8">
            <form v-on:submit.prevent="addNewTodo">
              <div class="form-group">
                <h3>Respuesta Corta</h3>
              </div>
              <div class="form-group">
                <input type="text" class="form-control" id="" placeholder="Ingresar Pregunta... ">
              </div>
              <div class="form-group">
                <input type="text" class="form-control" id="" placeholder="Ingresar Respuesta...">
              </div>
              <button>Añadir</button>
            </form>
          </div>
          <div class="col-md-4">
            <pre>{{$data}}</pre>
          </div>
        </div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return{
      MO: false,
      TF: false,
      SA: false,
        cuest: [], // cuestionario
        p: '',
        r1: '',
        r2: '',
        r3: '',
        rc: '' 
    }
  },
  /*methods: {
    OM: function () {
      this.cuest.push({
        tipo: 1,
        pregunta: this.p,
        op: {
          op1: this.r1,
          op2: this.r2,
          op3: this.r3
        },
        opc: this.rc
      })
      localStorage.setItem('datos', JSON.stringify(this.cuest))
    },
  }*/
}
</script>
