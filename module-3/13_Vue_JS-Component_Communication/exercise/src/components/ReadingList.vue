<template>
  <div class="book-container">
  <BookCard :book = 'book'   v-for:="(book,index) in $store.state.books" :key="index" class="" />
  
  </div>
</template>

<script>
import BookCard from './BookCard.vue';

export default {

components: {
  BookCard
},

methods: {

  
}
}
</script>

<style>
.book-container {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}
</style>