<template>
  <div id="book-app">
    <nav>
      <router-link :to = "{name: 'Home'}">Home |</router-link>
      <router-link :to = "{name: 'Mybook'}">My Books</router-link>
    </nav>


    <router-view />
  </div>
</template>

<script>

export default {
  
}
</script>

<style>
#book-app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: 60px;
}

a{
  display: inline-block;
  margin-right: 5px;

  color:#2c3e50;
  font-weight: bold;
  text-decoration: none;
  border-left: 2px;
}



</style>
