<template>
  <div class="container">

    <br>
    <h1 style="text-align: center;">
      <slot>Heading</slot>
    </h1>
    <hr style="border-color: green;">
    <br>

    <h3>Registered Users:</h3>
    <button class="btn btn-primary" @click.prevent="refreshUsersClicked">
      <img src="../assets/refresh-icon.png" alt="" style="height: 30px;">
      Refresh list
    </button>
    <table class="table table-striped ">
      <thead>
        <tr>
          <th>ID</th> <th>Email</th> <th>Password</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="user in users" :key="user.id">
          <td>{{user.id}}</td> <td>{{user.email}}</td> <td>{{user.password}}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
    data() {
      return {
        users: [
          {id: 1, email: 'alex@gmail.com', password: '123456'},
          {id: 1, email: 'alex@gmail.com', password: '123456'},
          {id: 1, email: 'alex@gmail.com', password: '123456'},
          {id: 1, email: 'alex@gmail.com', password: '123456'},
          {id: 1, email: 'alex@gmail.com', password: '123456'},
          {id: 1, email: 'alex@gmail.com', password: '123456'},
          {id: 1, email: 'alex@gmail.com', password: '123456'},
          {id: 1, email: 'alex@gmail.com', password: '123456'},
          {id: 1, email: 'alex@gmail.com', password: '123456'},
          {id: 1, email: 'alex@gmail.com', password: '123456'},
          {id: 1, email: 'alex@gmail.com', password: '123456'},
          {id: 1, email: 'alex@gmail.com', password: '123456'},
        ]
      };
    },

    methods: {
      refreshUsersClicked() {
        
      }
    }
}
</script>

<style scoped>
    .container {
        border: 1px solid green;
        border-radius: 10px;

        height: auto;

        width: 100%;
    }
</style>
