<template>
  <div>
    <img src="../assets/ping_pong_loader.gif" v-if="isLoading"  />
    <card-detail v-bind:card="myCard" v-else />
  </div>
</template>

<script>
import CardDetail from '../components/CardDetail.vue';
import boardService from '../services/BoardService.js';

export default {
  
  components: {
    CardDetail
  },

  data() {
    return {
      myCard: { },
      isLoading: true,
    };
  },

  created() {
    const cardId = this.$route.params.cardId;
    boardService.getCard(cardId).then((response) => {
      this.myCard = response.data;
      this.isLoading = false;
    });
  }



};
</script>
