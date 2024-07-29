<template>
  <div>
    <div v-if="isLoading">
      <h1>My Kanban Boards</h1>
      <div class="loading">
        <img src="../assets/ping_pong_loader.gif" />
      </div>
    </div>
    <div v-else>
      <h1>My Kanban Boards</h1>

<!--   subcomponent         attribute
                                    local data (this.localBoardsVariable)  -->
      <boards-list   v-bind:boards="localBoardsVariable" />
   
    </div>
  </div>
</template>

<script>
import BoardsList from '../components/BoardsList.vue';
import boardService from '../services/BoardService.js';

export default {
  components: {
    BoardsList
  },
  data() {
    return {
      localBoardsVariable: [],
      isLoading: true
    };
  },
  methods: {
    retrieveBoards() {
      boardService.getBoards().then(response => {
        // IN THE FUTURE!
        this.localBoardsVariable = response.data;
        this.isLoading = false;
      });
    }
  },
  // Vue Lifecycle Hook
  created() {
    this.retrieveBoards();
  }
};
</script>
