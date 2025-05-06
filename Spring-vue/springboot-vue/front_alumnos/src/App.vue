<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';

const alumnos = ref([]);

const nuevoAlumno = ref({
  numeroControl: '',
  nombre: '',
  apellidos: '',
  telefono: '',
  email: '',
  carrera: '',
  imagenURL: ''
});

const cargarAlumnos = async () => {
  const response = await axios.get('http://localhost:8082/alumnos/traer-alumnos');
  alumnos.value = response.data;
  console.log(alumnos.value);
}

const agregarAlumno = async () => {
  await axios.post('http://localhost:8082/alumnos/insertar-alumnos' , nuevoAlumno.value);
  await cargarAlumnos();
  nuevoAlumno.value = {
    numeroControl: '',
    nombre: '',
    apellidos: '',
    telefono: '',
    email: '',
    carrera: '',
    imagenURL: ''
  }
}

onMounted(cargarAlumnos);


</script>
<template>
  <div class="container">
    <div class="row">
      <div class="col-md-12 mt-4">
        <div class="card shadow p-4 mb-4">
          <h2 class="text-center">Formulario de Alumnos</h2>
          <form @submit.prevent="agregarAlumno">
            <div class="row">
            <div class="col-md-6 mb-3">
              <label for="numeroControl" class="form-label">Numero de Control</label>
              <input type="text" class="form-control" id="numeroControl" v-model="nuevoAlumno.numeroControl" required>

            </div>
            <div class="col-md-6 mb-3">
              <label for="nombre" class="form-label">Nombre</label>
              <input type="text" class="form-control" id="nombre" v-model="nuevoAlumno.nombre" required>
            </div>
            <div class="col-md-6 mb-3">
              <label for="apellidos" class="form-label">Apellidos</label>
              <input type="text" class="form-control" id="apellidos" v-model="nuevoAlumno.apellidos" required>
            </div>
            <div class="col-md-6 mb-3">
              <label for="telefono" class="form-label">Telefono</label>
              <input type="text" class="form-control" id="telefono" v-model="nuevoAlumno.telefono" required>
            </div>
            <div class="col-md-6 mb-3">
              <label for="email" class="form-label">Email</label>
              <input type="email" class="form-control" id="email" v-model="nuevoAlumno.email" required>
            </div>
            <div class="col-md-6 mb-3">
              <label for="carrera" class="form-label">Carrera</label>
              <input type="text" class="form-control" id="carrera" v-model="nuevoAlumno.carrera" required>
            </div>
            <div class="col-md-6 mb-3">
              <label for="imagenURL" class="form-label">Imagen URL</label>
              <input type="text" class="form-control" id="imagenURL" v-model="nuevoAlumno.imagenURL">
            </div>
          </div>
            <button type="submit" class="btn btn-primary">Agregar Alumno</button>
          </form> <!-- CORRECCIÓN AQUÍ -->
        </div>
      </div>


      <div class="col-md-12">
        <div class="card shadow">
          <div class="card body">
            <h5 class="card title mb-3">Tabla De Alumnos</h5>
            <table class="table table-hover align-middle">
          <thead class="table-dark">
            <tr>
              <th scope="col">id</th>
              <th scope="col">numeroControl</th>
              <th scope="col">nombre</th>
              <th scope="col">apellidos</th>
              <th scope="col">telefono</th>
              <th scope="col">email</th>
              <th scope="col">carrera</th>
              <th scope="col">imagenURL</th>
              <th scope="col">accion</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="alumno in alumnos" :key="alumno.id">
              <td>{{ alumno.id }}</td>
              <td>{{ alumno.numeroControl }}</td>
              <td>{{ alumno.nombre }}</td>
              <td>{{ alumno.apellidos }}</td>
              <td>{{ alumno.telefono }}</td>
              <td>{{ alumno.email }}</td>
              <td>{{ alumno.carrera }}</td>
              <td><img :src="alumno.imagenURL" alt="Imagen de Alumno" width="50" height="50"></td>
              <td>
                <button class="btn btn-danger mx-2"><i class="bi bi-trash2-fill"></i></button>
                <button class="btn btn-warning"><i class="bi bi-pencil-fill"></i></button>
              </td>
            </tr>
          </tbody>
        </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
</style>
