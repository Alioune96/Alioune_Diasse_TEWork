<template>
  <div id="container" >
     <img src="https://res.cloudinary.com/drr6cwmiz/image/upload/v1721948001/logo-transparent_p8qays.png" alt="">
     <h1 id="siteTitle">{{ title }}</h1>
     <nav>
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'about' }">About</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'search' }">Search</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </nav>


  </div>
</template>

<script>
export default {

    data() {
        return {
            title: 'Java Juggernauts'
        }
    }

}
</script>

<style scoped>
       #siteTitle {
           text-align: center;
       }
       img {
        width: 20%;
        height: auto;
       }
       #container {
        display:flex;
        justify-content: space-around;
        align-items: center;
        width: 100%;
        background-color: coral;
        border-bottom: 10px solid red;
       }

       nav {
        margin:5px;
        padding: 13px 25px;
        background-color: crimson;
        color: white;
       }
</style>