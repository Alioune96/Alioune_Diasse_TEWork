<template>
  <section>
    <h2>Product Reviews for {{ productName }}</h2>

    <p class="description">{{ description }}</p>

    <div class="well-display">
      <div class="well">
        <span class="amount">{{ averageRating }}</span>
        Average Rating
      </div>

      <div class="well">
        <span class="amount">{{ numberOfOneStarReviews }}</span>
        1 Star Review{{ numberOfOneStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount">{{ numberOfTwoStarReviews }}</span>
        2 Star Review{{ numberOfTwoStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount">{{ numberOfThreeStarReviews }}</span>
        3 Star Review{{ numberOfThreeStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount">{{ numberOfFourStarReviews }}</span>
        4 Star Review{{ numberOfFourStarReviews === 1 ? '' : 's' }}
      </div>

      <div class="well">
        <span class="amount">{{ numberOfFiveStarReviews }}</span>
        5 Star Review{{ numberOfFiveStarReviews === 1 ? '' : 's' }}
      </div>
    </div>

    <!-- <ol>
        <li v-for="rvw in reviews" v-bind:key="rvw.id">
            <h2>{{ rvw.reviewer }}</h2>
            <h3>{{ rvw.title }}</h3>
        </li>
        </ol> -->

    <!--                  for (ReviewObject rvw : reviews) { } -->
    <div class="review" v-for="rvw in reviews" v-bind:key="rvw.id" v-bind:class="{ helpful: rvw.helpful }">
      <h4>{{ rvw.reviewer }}</h4>
      <div class="rating">
        <!--                                                                                        for (int i = 1; i <= rvw.rating; i++) { } -->
        <img src="../assets/star.png" v-bind:alt="rvw.rating + ' Star Review'" class="ratingStar" v-for="i in rvw.rating" v-bind:key="i" />
      </div>
      <h3>{{ rvw.title }}</h3>

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
    // Computed Properties: Cannot accept input, Must return a value
    numberOfOneStarReviews() {
      let count = 0;

      this.reviews.forEach((reviewObject) => {
        if (reviewObject.rating === 1) {
          count++;
        }
      });

      return count;
    },
    numberOfTwoStarReviews() {
      const filteredReviews = this.reviews.filter((reviewObject) => {
        if (reviewObject.rating === 2) {
          return true;
        }
        return false;
      });

      return filteredReviews.length;
    },

    numberOfThreeStarReviews() {
      return this.reviews.filter((reviewObject) => {
        return reviewObject.rating === 3;
      }).length;
    },

    numberOfFourStarReviews() {
      return this.reviews.reduce((accumulator, reviewObject) => {
        if (reviewObject.rating === 4) {
          return accumulator + 1;
        }
        return accumulator;
      }, 0);
    },
    numberOfFiveStarReviews() {
      return this.reviews.reduce((acc, el) => {
        return acc + (el.rating === 5 ? 1 : 0);
      }, 0);
    },

    averageRating() {
      return (this.reviews.reduce((acc, el) => { return acc + el.rating}, 0) / this.reviews.length).toFixed(2);
    }
  },

  methods: {},
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
