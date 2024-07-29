import axios from 'axios';

const http = axios.create({
  baseURL: import.meta.env.VITE_REMOTE_API
});

export default {

  getBoards() {
    // ASYNCH
    return http.get('/boards'); // returns a Promise immediately
  },

  getBoard(boardId) {
    return http.get(`/boards/${boardId}`)
  },

  getCard(cardId) {
    return http.get(`/cards/${cardId}`)
  }

}
