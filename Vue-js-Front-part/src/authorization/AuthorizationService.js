import Vue from "vue";
import VueResource from 'vue-resource';

import ContentService from '../content/ContentService.js';

Vue.use(VueResource);

export default new Vue ({
    methods: {
        validateRegistrationFormData(email, password, confirmPassword) {
            if (password !== confirmPassword) {
                alert('Please, confirm your password!');
                return false;
            }

            // ...

            return true;
        },

        validateLoginFormData(email, password) {
            // ...

            return true;
        },

        sendLoginAJAX(that) {
            that.$http.post('/login', {email: that.email, password: that.password}).then(
                (goodResponse, self = that) => {
                    console.log(' * Login was successful! Response:\n' + goodResponse);
                    showSuccessPanel(self);
                    
                    ContentService.postEmail(self.email);

                    if (confirm('Go to main page now?') === true) {
                        self.$router.push({name: 'personal'});
                    }
                },
                (badResponse, self = that) => {
                    console.log(' * ERROR! Login was not successful! Response:\n' + badResponse);
                    showFailPanel(self);
                }
            );
        },

        sendRegistrationAJAX(that) {
            that.$http.post('/registration', {email: that.email, password: that.password}).then(
                (goodResponse, self = this) => {
                    console.log(' * Registration was successful! Response:\n' + goodResponse);
                    AuthService.showSuccessPanel(self);

                    ContentService.postEmail(self.email);

                    if (confirm('Go to main page now?') === true) {
                        self.$router.push({name: 'personal'});
                    }
                },
                (badResponse, self = that) => {
                    console.log(' * ERROR! Registration was not successful! Response:\n' + badResponse);
                    AuthService.showFailPanel(self);
                }
            );
        },

        showSuccessPanel(self) {
            self.displayFailPanel = 'display: none';
            self.displaySuccessPanel = 'display: block';
        },
        showFailPanel(self) {
            self.displaySuccessPanel = 'display: none';
            self.displayFailPanel = 'display: block';
        },
        hideAllPanels(self) {
            self.displaySuccessPanel = 'display: none';
            self.displayFailPanel = 'display: none';
        }
    }
});