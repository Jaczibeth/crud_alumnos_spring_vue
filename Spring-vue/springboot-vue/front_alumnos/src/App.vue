<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';

const alumnos = ref([]);

const alumno = ref({
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
              <input type="text" class="form-control" id="numeroControl" v-model="alumno.numeroControl">
            </div>
            <div class="col-md-6 mb-3">
              <label for="nombre" class="form-label">Nombre</label>
              <input type="text" class="form-control" id="nombre" v-model="alumno.nombre">
            </div>
            <div class="col-md-6 mb-3">
              <label for="apellidos" class="form-label">Apellidos</label>
              <input type="text" class="form-control" id="apellidos" v-model="alumno.apellidos">
            </div>
            <div class="col-md-6 mb-3">
              <label for="telefono" class="form-label">Telefono</label>
              <input type="text" class="form-control" id="telefono" v-model="alumno.telefono">
            </div>
            <div class="col-md-6 mb-3">
              <label for="email" class="form-label">Email</label>
              <input type="email" class="form-control" id="email" v-model="alumno.email">
            </div>
            <div class="col-md-6 mb-3">
              <label for="carrera" class="form-label">Carrera</label>
              <input type="text" class="form-control" id="carrera" v-model="alumno.carrera">
            </div>
            <div class="col-md-6 mb-3">
              <label for="imagenURL" class="form-label">Imagen URL</label>
              <input type="text" class="form-control" id="imagenURL" v-model="alumno.imagenURL">
            </div>
          </div>
            <button type="submit" class="btn btn-primary">Agregar Alumno</button>
          </form> <!-- CORRECCIÓN AQUÍ -->
        </div>
      </div>
      <div class="col-md-12">
        <h2>Tabla De Alumnos</h2>

        <table class="table">
          <thead>
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
              <td><button class="btn btn-danger">Eliminar</button></td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<style scoped>
</style>
