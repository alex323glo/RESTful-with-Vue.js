import Vue from 'vue';

export default new Vue({
    data: {
        contentPageEmail: ''
    },
    methods: {
        postEmail(email) {
            this.contentPageEmail = email;
        }
    }
});