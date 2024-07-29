<template>
  <div>
    <h1>Card Detail</h1>
    <h2>{{ card.title }}</h2>
    <p>{{ card.description }}</p>

    <comments-list v-bind:commentsArray="card.comments" />
  </div>
</template>

<script>
import CommentsList from './CommentsList.vue';

export default {
  props: ['card'],
  components: {
    CommentsList
  }
};
</script>
