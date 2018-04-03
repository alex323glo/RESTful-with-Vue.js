<template>
    <div class="container" id="main-container">
        <form class="form-group">
            <h1>Login page</h1>
    
            <br><br>

            <label for="email">Email address:</label>
            <input  type="email" class="form-control" id="email" v-model="email" @change="formInputChanged">

            <label for="password">Password:</label>
            <input  type="password" class="form-control" id="password" v-model="password" @change="formInputChanged">

            <br>
            
            <button class="btn btn-success" @click.prevent="submitClicked">Login</button>

            <br><br><br>

            <router-link class="btn btn-info" :to="{name: 'registration'}">Don't have account yet? <br> Register now!</router-link>
        </form>

        <div id="success-panel" class="container" :style="displaySuccessPanel">
            <h2>Login was successful! :)</h2>
        </div>

        <div id="fail-panel" class="container" :style="displayFailPanel">
            <h2>Login failed! :(</h2>
        </div>
    </div>
</template>

<script>
import AuthService from './AuthorizationService';

export default {
    data() {
        return {
            email: '',
            password: '',

            displaySuccessPanel: 'display: none',
            displayFailPanel: 'display: none'
        }
    },

    methods: {
        formInputChanged() {
            AuthService.hideAllPanels(this);
        },

        submitClicked() {
            console.log(' * Login: "Submit" button was clicked!');

            if (!AuthService.validateLoginFormData(this.email, this.password)) {
                console.log(' * ERROR! Login was not started successfully! Form data validation was not passed.'); 
                AuthService.showFailPanel();
                return;
            }

            AuthService.sendLoginAJAX(this);
        },

        
    }
}
</script>


<style scoped>

    #main-container {
        padding: 10%;
    }

    form {
        border: 1px solid rgba(0, 0, 255, 0.1);
        border-radius: 30px;
        background-color: rgba(0, 255, 255, 0.15);

        width: 100%;

        padding: 10%;

        padding-top: 50px;
        padding-bottom: 20px;
    }

    input {
        width: 100%;
    }

    #success-panel {
        text-align: center;
        color: green;

        display: none;
    }

    
    #fail-panel {
        text-align: center;
        color: red;

        display: none;
    }

</style>