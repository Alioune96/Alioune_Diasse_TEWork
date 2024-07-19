<template>
  <!-- HTML Section!  notice these comments are allllll different -->
  <div class="main">
    <img alt="Vue logo" src="./assets/logo.png" />

    <!-- Step 3 (of using sub-components): Use the component as a custom HTML tag -->
    <ProductReview />


     
  </div>
</template>


<script>
// JavaScript section!
import ProductReview from './components/ProductReview.vue'; // Step 1: Import it!

export default {
  components: {
    ProductReview   // Step 2: Register it!
  }
}
</script>


<style>
/* CSS Section! */
.main {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
