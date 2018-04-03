<template>
    <div class="container">
        <h1>
            <slot></slot>
        </h1>
        <br>
        <a href="https://projects.spring.io/spring-boot/">
            <img id="logo-img" src="../assets/spring-boot-project-logo.png" alt="logo">
        </a>
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
        width: 20%;
    }
</style>
