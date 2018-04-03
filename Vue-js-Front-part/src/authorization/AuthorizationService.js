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
                (goodResponse, target = that, self = this) => {
                    console.log(' * Login was successful! Response:\n' + goodResponse);
                    self.showSuccessPanel(target);

                    ContentService.postEmail(target.email);

                    if (confirm('Go to main page now?') === true) {
                        target.$router.push({name: 'personal'});
                    }
                },
                (badResponse, target = that, self = this) => {
                    console.log(' * ERROR! Login was not successful! Response:\n' + badResponse);
                    self.showFailPanel(target);
                }
            );
        },

        sendRegistrationAJAX(that) {
            that.$http.post('/registration', {email: that.email, password: that.password}).then(
                (goodResponse, target = that, self = this) => {
                    console.log(' * Registration was successful! Response:\n' + goodResponse);
                    self.showSuccessPanel(target);

                    ContentService.postEmail(target.email);

                    if (confirm('Go to main page now?') === true) {
                        target.$router.push({name: 'personal'});
                    }
                },
                (badResponse, target = that, self = this) => {
                    console.log(' * ERROR! Registration was not successful! Response:\n' + badResponse);
                    self.showFailPanel(target);
                }
            );
        },

        showSuccessPanel(target) {
            target.displayFailPanel = 'display: none';
            target.displaySuccessPanel = 'display: block';
        },
        showFailPanel(target) {
            target.displaySuccessPanel = 'display: none';
            target.displayFailPanel = 'display: block';
        },
        hideAllPanels(target) {
            target.displaySuccessPanel = 'display: none';
            target.displayFailPanel = 'display: none';
        }
    }
});
