<template>
    <div class="card" :class=" {read: book.read}">
      <h2 class="book-title">{{ book.title }}</h2>
      <img class="book-image" v-bind:src="'http://covers.openlibrary.org/b/isbn/'+`${book.isbn}` + '-M.jpg'" alt="">
      <h3 class="book-author">{{ book.author }}</h3>
      <button @click="firstMethod(book.read)" class="mark-unread" v-show="book.read">Mark Unread</button>
      <button @click="firstMethod(book.read)" class="mark-read"  v-show="!book.read">Mark Read </button>
    </div>
</template>

<script>
export default {
  props:['book'],



methods: {
  firstMethod(){
     this.$store.commit("CHANGE_STATUS",this.book);
  },
}
}
</script>

<style>
.card {
  border: 2px solid black;
  border-radius: 10px;
  width: 250px;
  height: 550px;
  margin: 20px;
  position: relative;
}

.card.read {
  background-color: lightgray;
}

.card .book-title {
  font-size: 1.5rem;
}

.card .book-author {
  font-size: 1rem;
}

.book-image {
  width: 80%;
}

.mark-read, .mark-unread {
  display: block;
  position: absolute;
  bottom: 40px;
  width: 80%;
  left: 10%;
  font-size: 1rem;
}
</style>