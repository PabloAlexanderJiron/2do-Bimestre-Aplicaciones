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
            <button type="button" class="btn btn-primary" @click="MO = !MO" v-on:click=" TF = false, SA = false, anadir = true"> + Opcion Multiple </button>
            <button type="button" class="btn btn-success" @click="TF = !TF" v-on:click=" MO = false, SA = false, anadir = true"> + Verdadero / Falso </button>
            <button type="button" class="btn btn-warning" @click="SA = !SA" v-on:click=" MO = false, TF = false, anadir = true"> + Respuesta Corta </button>
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
                <input type="text" class="form-control" id="" placeholder="Ingresar Respuesta cor... " v-model="rc">
              </div>
              <div class="form-group">
                <button class="btn btn-primary" v-if="anadir" v-on:click="saveMO">Añadir</button>
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
                <input type="text" class="form-control" placeholder="Ingresar Pregunta... " v-model="p">
              </div>
              <div class="form-group">
                <button type="button" class="btn btn-success">Verdadero</button>
                <button type="button" class="btn btn-danger">Falso</button>
              </div>
              <button v-if="anadir" v-on:click="saveTF">Añadir</button>
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
                <input type="text" class="form-control" id="" placeholder="Ingresar Pregunta... " v-model="p">
              </div>
              <div class="form-group">
                <input type="text" class="form-control" id="" placeholder="Ingresar Respuesta..." v-model="rc">
              </div>
              <button v-if="anadir" v-on:click="saveSA">Añadir</button>
            </form>
          </div>
          <div class="col-md-4">
            <pre>{{$data}}</pre>
          </div>
        </div>
        <div class="row">
            <div class="col-md-8" v-for="(item) in quiz" :key="item.index">
              pregunta Nº {{item.index}}: {{item.pregunta}}. Respuesta correcta {{item.opc}}
            </div>
        </div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      MO: false,
      TF: false,
      SA: false,
      anadir: false,
      quiz: [], // cuestionario
      p: '',
      r1: '',
      r2: '',
      r3: '',
      rc: '',
      index:'' 
    }
  },
  methods: {
    clear: function() {
      this.p = ''
      this.r1 = ''
      this.r2 = ''
      this.r3 = ''
      this.rc = ''
    },
    saveMO: function () {
      this.quiz.push({
        tipo: 1,
        pregunta: this.p,
        op: {
          op1: this.r1,
          op2: this.r2,
          op3: this.r3
        },
        opc: this.rc
      })
      localStorage.setItem('datos', JSON.stringify(this.quiz))
    },
    saveTF: function() {
      this.quiz.push({
        tipo: 2,
        pregunta: this.p,
        opc: this.rc
      });
      app.clear()
      localStorage.setItem('datos', JSON.stringify(this.quiz))
    },
    saveSA: function() {
      this.quiz.push({
        tipo: 3,
        pregunta: this.p,
        opc: this.rc
      });
      app.clear()
      localStorage.setItem('datos', JSON.stringify(this.quiz))
    },
    created: function() {
    this.connect()
    let database = JSON.parse(localStorage.getItem('datos'))
    if (database === null) {
      this.quiz = []
    } else {
      this.quiz = database
    }
  }
  }
}
</script>
