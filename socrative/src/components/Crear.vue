  <template>
  <div id="app">
    <div class="container">
        <div class="row">
          <div class="span12">
            <h1>Crear Cuestionario</h1>
          </div>
        </div>
        <div class="row">
          <form>
            <div class="form-group">
              <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Nombre del Cuestionario">
            </div>
          </form>
        </div>
        <div class="row">
          <div class="col-md-12">
            <label for="exampleInputEmail1">Preguntas</label>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12">
            <button type="button" class="btn btn-primary"> + Multiple Choice </button>
            <button type="button" class="btn btn-success"> + True / False </button>
            <button type="button" class="btn btn-warning"> + Short Answer </button>
          </div>
        </div>
    </div>
  </div>
</template>