<template>
    <section>
        <h2>Parameters Object: {{ $route.params }}</h2>
        <h1>Here are all of our books!</h1>
        <products-list />

        <h3>Here they are again, in case you missed them:</h3>
        <products-list />

    </section>
</template>


<script>
import ProductsList from '../components/ProductsList.vue'

export default {
  components: { 
      ProductsList,
    },

}
</script>



<style scoped>

</style>