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
                <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Nombre del Cuestionario" v-model="Q">
              </div>
            </form>
          </div>
          <div class="col-md-8 text-right">
            <button type="button" class="btn btn-primary text-right" @click="sendMessage"> Guardar Cuestionario </button>
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
        <div class="row">
          <div class="col-md-12 text-center">
            <h1>cuestionario</h1>
          </div>
          <div class="col-md-8" v-for="(item, index) in quiz" :key="item.index">
            <p>
              <span>
                pregunta Nº {{index}}: {{item.pregunta}}. Respuesta correcta {{item.opc}}
              </span>
              <button @click="remove(index)">Remove</button>
            </p>
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
                <button class="btn btn-primary" v-if="anadir" v-on:click="addMO">Añadir</button>
              </div>
            </form>
          </div>
          <!--<div class="col-md-4">
            <pre>{{$data}}</pre>
          </div>-->
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
                <label>
                  <input type="radio" name="True" v-model="rc" value="Verdadero"> VERDADERO
                </label>
                <label>
                  <input type="radio" name="False" v-model="rc" value="Falso"> FALSO
                </label>
              </div>
              <button class="btn btn-primary" v-if="anadir" v-on:click="addTF">Añadir</button>
            </form>
          </div>
          <!--<div class="col-md-4">
            <pre>{{$data}}</pre>
          </div>-->
        </div>
        <div class="row" id="ShortAnswer" v-if="SA" >
          <div class="col-md-8">
            <form>
              <div class="form-group">
                <h3>Respuesta Corta</h3>
              </div>
              <div class="form-group">
                <input type="text" class="form-control" id="" placeholder="Ingresar Pregunta... " v-model="p">
              </div>
              <div class="form-group">
                <input type="text" class="form-control" id="" placeholder="Ingresar Respuesta..." v-model="rc">
              </div>
              <button class="btn btn-primary" v-if="anadir" v-on:click="addSA">Añadir</button>
            </form>
          </div>
          <!--<div class="col-md-4">
            <pre>{{$data}}</pre>
          </div>-->
        </div>
    </div>
  </div>
</template>
<script>
var socket = new WebSocket('ws://localhost:4567/profesor')
export default {
  data () {
    return {
      MO: false,
      TF: false,
      SA: false,
      anadir: false,
      quiz: [], // cuestionario
      Q: '',
      p: '',
      r1: '',
      r2: '',
      r3: '',
      rc: ''
    }
  },
  methods: {
    clear: function () {
      this.p = null
      this.r1 = null
      this.r2 = null
      this.r3 = null
      this.rc = null
    },
    addMO: function () {
      this.quiz.push({
        idP: this.Q,
        tipo: 'MO',
        pregunta: this.p,
        op: { // opciones
          op1: this.r1,
          op2: this.r2,
          op3: this.r3
        },
        opc: this.rc
      })
      this.clear()
      const parse = JSON.stringify(this.quiz)
      localStorage.setItem('quiz', parse)
    },
    addTF: function () {
      this.quiz.push({
        idP: this.Q,
        tipo: 'TF',
        pregunta: this.p,
        opc: this.rc
      })
      this.clear()
      const parse = JSON.stringify(this.quiz)
      localStorage.setItem('quiz', parse)
    },
    addSA: function () {
      this.quiz.push({
        idP: this.Q,
        tipo: 'RC',
        pregunta: this.p,
        opc: this.rc
      })
      this.clear()
      const parse = JSON.stringify(this.quiz)
      localStorage.setItem('quiz', parse)
    },
    remove (x) {
      this.quiz.splice(x, 1)
      const parsed = JSON.stringify(this.quiz)
      localStorage.setItem('quiz', parsed)
    },
    mounted () {
      if (localStorage.getItem('quiz')) {
        try {
          this.quiz = JSON.parse(localStorage.getItem('quiz'))
        } catch (e) {
          localStorage.removeItem('quiz')
        }
      }
    },
    // conecion websocket
    connect () {
      socket.onopen = this.openWs()
      socket.onerror = this.errorWs()
    },
    openWs () {
      // console.log(sw.estado + " " + ws.nombre);
      // alert('Usuario conectado')
      // this.sendMessage(this.quiz)
    },
    errorWs () {
      console.log(event.quiz)
    },
    messageWs (event) {
      this.json = JSON.parse(event.quiz)
      console.log(event.quiz)
    },
    sendMessage () {
      var json = JSON.stringify(this.quiz)
      socket.send(json)
    },
    created: function () {
      this.connect()
    }
  }
}
</script>
