<template>
  <h1>$route.params --> {{ $route.params }}</h1>
  <h1>Add a review for: </h1>

  <add-review v-bind:productId="thisProductId" />  <!-- Add Review component -->

</template>



<script>
import AddReview from '../components/AddReview.vue'
export default {
  components: { AddReview },
  computed: {
      thisProductId() {
          return this.$route.params.bookId;
      }
  }

}
</script>



<style scoped>

</style>