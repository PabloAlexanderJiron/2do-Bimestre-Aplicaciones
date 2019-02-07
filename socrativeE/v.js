var main = new Vue({
    el: '#main',
    data: {
        quiz:"",
        pregunta: "",
        respuestacorrecta:"",
        datos:[],
        JSONObj: {}
    },
    methods: {
        cargar: function () {
            this.sendMessage("");
            console.log(this.JSONObj);
            for(var leer in this.JSONObj){
            console.log(this.JSONObj[leer].pregunta);
            }
        },        
        //metodos de conexion a WebSocket
        connect() {
              socket = new WebSocket("ws://localhost:4567/estudiante");
              socket.onopen = this.openWs;
              socket.onerror = this.errorWs;
              socket.onmessage = this.messageWs;
        },
		openWs() {
             // alert("Usuario conectado");              
		},
        errorWs(evt) {
            alert("Usuario fallido");
        },
        messageWs(evt) {
            var jvs=JSON.stringify(eval("("+ evt.data + ")"));
            this.JSONObj=JSON.parse(jvs);
        },
        sendMessage(msg) {
              json = JSON.stringify(msg);
              socket.send(json);
        }
        
    }, 
    created: function () {
        this.connect()
    }
});
Vue.component('q-option1', {
  props: ['opcion', 'groupid'],
  template: `
        <div class="form-check">
            <label class="form-check-label">
                <input class="form-check-input" type="radio" :name="groupid" :value="opcion.id"> {{opcion.opc}}
            </label        
        </div>
        <br>
        <br>
    `
});
Vue.component('q-option2', {
  /*data: function(){
    return{
      verdadero:"verdadero",
      falso:"falso"
    }
  },*/
  props: ['groupid'],
  template: `
        <div class="form-check">
            <label class="form-check-label">
                <input class="form-check-input" type="radio" :name="groupid" value="1">Verdadero
            </label>
            <br>
            <label class="form-check-label">
                <input class="form-check-input" type="radio" :name="groupid" value="2">Falso
            </label>
        </div>
        <br>
        <br>
    `
});
Vue.component('q-option3', {
  props: ['option', 'groupid'],
  template: `
        <div id="correcta">
            <label>
                <input class="form-control form-control-sm" type="text" :name="groupid">
            </label>
        </div>
    `
});