import { createStore as _createStore } from 'vuex';
import axios from 'axios';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},

      players:
      [
        {
            "playerId": 1,
            "firstName": "Derek",
            "lastName": "Jeter",
            "jerseyNumber": 2,
            "salary": 220000.0,
            "positions": [
                "Pitcher"
            ],
            "teamId": 1,
            "imageUrl": "https://res.cloudinary.com/drr6cwmiz/image/upload/v1701190470/1_cxwinb.webp",
            "fullName": "Derek Jeter"
        },
        {
            "playerId": 2,
            "firstName": "Mariano",
            "lastName": "Rivera",
            "jerseyNumber": 42,
            "salary": 150000.0,
            "positions": [
                "Catcher"
            ],
            "teamId": 1,
            "imageUrl": "https://res.cloudinary.com/drr6cwmiz/image/upload/v1701190469/2_hqe0ky.webp",
            "fullName": "Mariano Rivera"
        },
        {
            "playerId": 3,
            "firstName": "Alex",
            "lastName": "Rodriguez",
            "jerseyNumber": 13,
            "salary": 250000.0,
            "positions": [
                "First Baseman"
            ],
            "teamId": 1,
            "imageUrl": "https://res.cloudinary.com/drr6cwmiz/image/upload/v1701190469/3_mgphn7.webp",
            "fullName": "Alex Rodriguez"
        },
        {
            "playerId": 4,
            "firstName": "Kelly",
            "lastName": "Johnson",
            "jerseyNumber": 3,
            "salary": 1991000.0,
            "positions": [
                "Second Baseman"
            ],
            "teamId": 1,
            "imageUrl": "https://res.cloudinary.com/drr6cwmiz/image/upload/v1701190469/5_dm97cw.webp",
            "fullName": "Kelly Johnson"
        },
        {
            "playerId": 5,
            "firstName": "Babe",
            "lastName": "Ruth",
            "jerseyNumber": 4,
            "salary": 800000.0,
            "positions": [
                "Shortstop"
            ],
            "teamId": 1,
            "imageUrl": "https://res.cloudinary.com/drr6cwmiz/image/upload/v1701190469/6_mdkfoj.webp",
            "fullName": "Babe Ruth"
        },
        {
            "playerId": 6,
            "firstName": "Natalie",
            "lastName": "Smith",
            "jerseyNumber": 19,
            "salary": 1800000.0,
            "positions": [
                "Outfielder"
            ],
            "teamId": 1,
            "imageUrl": "https://res.cloudinary.com/drr6cwmiz/image/upload/v1701190469/7_omvz9t.webp",
            "fullName": "Natalie Smith"
        }
      ]




    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      }
    },
  });
  return store;
}
