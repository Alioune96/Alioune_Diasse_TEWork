<template>
  <section>

    <form>
      <input v-model="example.checkbox" type="checkbox" />
      <input v-model="example.txt" type="text" />
      <input v-model="example.radio" type="radio" />
      <input v-model="example.pass" type="password" />
      <textarea v-model="example.paragraph"></textarea>
      <select v-model="example.dropdown">
        <option value="15">Fifteen</option>
        <option value="21">Twenty One</option>
        <option value="35">Thirty Five</option>
      </select>
    </form>


    <h2>Product Reviews for {{ productName }}</h2>

    <p class="description">{{ description }}</p>

    <div class="well-display">
      <div class="well">
        <span class="amount">{{ averageRating }}</span>
        Average Rating
      </div>

      <div class="well" v-for="x in 5" :key="x">
        <span class="amount">{{ numberOfXStarReviews(x) }}</span>
        {{ x }} Star Review{{ numberOfXStarReviews(x) === 1 ? '' : 's' }}
      </div>
    </div>

    <div class="review" v-for="rvw in reviews" :key="rvw.id" :class="{ helpful: rvw.helpful }">
      <h4>{{ rvw.reviewer }}</h4>
      <div class="rating" @click="rvw.rating++">
        <img src="../assets/star.png" :alt="rvw.rating + ' Star Review'" class="ratingStar" v-for="i in rvw.rating" :key="i" />
      </div>
      <h3 @dblclick="rvw.rating--">{{ rvw.title }}</h3>
      <p>{{ rvw.review }}</p>
      <label for="helpfulChkbx">Helpful?</label>
      <input name="helpfulChkbx" type="checkbox" v-model="rvw.helpful" />
    </div>


  </section>
</template>

<script>
export default {
  name: "Product Reviews component",

  data() {
    return {
      example: {},
      productName: "Head First Java",
      description: "Finally, a Java guide for the rest of us!",
      reviews: [
        {
          id: 1000,
          reviewer: "R Pérez",
          title: "Approachable pattern guide",
          review:
            "I love the uncomplicated, informal narrative style. I highly recommend this text for anyone trying to understand Design Patterns in a super simple way.",
          rating: 4,
          helpful: true
        },
        {
          id: 1001,
          reviewer: "Tom Pérez",
          title: "Unapproachable pattern guide",
          review:
            "I hate the uncomplicated, informal narrative style. I lowly recommend this text for anyone trying to understand Design Patterns in a super simple way.",
          rating: 1,
        },
        {
          id: 1002,
          reviewer: "Tom Again..",
          title: "Unapproachable pattern guide",
          review:
            "I hate the uncomplicated, informal narrative style. I lowly recommend this text for anyone trying to understand Design Patterns in a super simple way.",
          rating: 1,
        },
      ],
    };
  },
  computed: {
    averageRating() {
      return (this.reviews.reduce((acc, el) => { return acc + el.rating}, 0) / this.reviews.length).toFixed(2);
    }
  },

  methods: {
    numberOfXStarReviews(x) {
      return this.reviews.reduce((acc, el) => {
        return acc + (el.rating === x ? 1 : 0);
      }, 0);
    }
  },
};
</script>

<style scoped>
.helpful {
  background-color: lightyellow;
}

.main {
  margin: 1rem 0;
}

.well-display {
  display: flex;
  justify-content: space-around;
  margin-bottom: 1rem;
}

.well {
  display: inline-block;
  width: 15%;
  border: 1px black solid;
  border-radius: 6px;
  text-align: center;
  margin: 0.25rem;
  padding: 0.25rem;
}
.amount {
  color: darkslategray;
  display: block;
  font-size: 2.5rem;
}

.favorited {
  background-color: lightyellow;
}

.rating {
  height: 2rem;
  display: inline-block;
  vertical-align: top;
  margin: 0 0.5rem;
}

.rating img {
  height: 100%;
}

.review {
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
}
.review p {
  margin: 20px;
}

.review h3 {
  display: inline-block;
}

.review h4 {
  font-size: 1rem;
}
</style>
