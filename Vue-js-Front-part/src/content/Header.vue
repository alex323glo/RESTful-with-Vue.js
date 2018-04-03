<template>
    <div class="container">
        <a href="https://vuejs.org/">
            <img id="logo-img" src="../assets/vue-newsletter-logo.png" alt="logo">
        </a>
        <br>
        <h1>
            <slot></slot>
        </h1>
    </div>
</template>

<script>
export default {
  
}
</script>

<style scoped>
    .container {
        text-align: center;
        color: rgb(7, 95, 110);

        width: 100%;
    }

    #logo-img {
        width: 45%;
    }
</style>
