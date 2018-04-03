import ContentPage from './content/ContentPage.vue';
import Content from './content/Content.vue';
import EmptyContent from './content/EmptyContent.vue';

import Login from './authorization/Login.vue';
import Registration from './authorization/Registration.vue';

export const routes = [
    {
        path: '/',
        component: ContentPage,
        name: 'home',
        children: [
            {
                path: '/',
                component: EmptyContent,
                name: 'empty-content'
            },
            {
                path: '/personal',
                component: Content,
                name: 'personal'
            }
        ]
    },
    {
        path: '/registration',
        component: Registration,
        name: 'registration'
    },
    {
        path: '/login',
        component: Login,
        name: 'login'
    }
]