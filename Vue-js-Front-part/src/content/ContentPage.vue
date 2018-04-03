<template>
  <div class="container" id='content-page-container'>

    <nav>
      <div id="non-authorized-panel" :style="displayNonAuthorizedPanel">
        <router-link class="btn btn-success" :to="{name: 'login'}">Log in</router-link>
        <router-link class="btn btn-primary" :to="{name: 'registration'}">Sign up</router-link>
      </div>

      <div id="authorized-panel" :style="displayAuthorizedPanel">
        <span id="email-span" style="margin-right: 10px; margin-left: 10px;">{{postedEmail}}</span>
        <button class="btn btn-danger" @click="logoutClicked">Log out</button>
      </div>
    </nav>

    <header>
      <custom-header>Vue.js + Spring Boot</custom-header>
    </header>

    <main>
      <router-view>Main page</router-view>
    </main>

    <footer>
      <custom-footer>Vue.js + Spring Boot</custom-footer>
    </footer>
  </div>
</template>

<script>
import Header from './Header.vue';
import Footer from './Footer.vue';
import Content from './Content.vue';

import ContentService from './ContentService.js';

export default {
  components: {
    'custom-header': Header,
    'custom-content': Content,
    'custom-footer': Footer
  },

  computed: {
    postedEmail() {
      return ContentService.email;
    }
  },

  computed: {
    displayAuthorizedPanel() {
      return 'display: ' + (this.$route.name === 'content' ? 'block;'  : 'none;');
    },
    displayNonAuthorizedPanel() {
      return 'display: ' + (this.$route.name === 'content' ? 'none;' : 'block;');
    }
  },

  methods: {
    logoutClicked() {
      this.$http.get('/logout').then(
        (goodResponse) => {
          Console.log(' * Log out was successful.');
          ContentService.email = '';
          this.$router.push({name: 'home'});
        },
        (badResponse) => {
          console.log(' * ERROR. Cant log out.');
        }
      );
    }
  }
}
</script>

<style scoped>
  #content-page-container {
      border: 1px solid green;
      width: 100%;
  }

  #app {
    border: 1px solid red;

    height: auto;
  }

  nav, header, footer, main {
    border-radius: 10px;

    display: block;
    position: relative;

    margin: 50px;
    padding: 50px;
  }

  nav {
    display: block;
    position: absolute;

    width:fit-content;

    right: 0;

    padding: 0;
    margin-top: 5px;
  }

  #authorized-panel {
    border: 1px solid rgb(187, 186, 186);
    border-radius: 5px;
  }

  header {
    background-color: rgba(105, 190, 243, 0.5);
    padding: 10px;
  }

  main {
    background-color: rgba(0, 255, 179, 0.1);
  }

  footer {
    background-color: rgba(105, 190, 243, 0.5);
    padding: 10px;
  }

</style>
