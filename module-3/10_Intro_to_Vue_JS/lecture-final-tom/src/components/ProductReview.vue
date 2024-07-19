<template>
    <section>

        <h2>Product Reviews for {{ productName }}</h2>

        <p class="description">{{ description }}</p>

        <!-- <ol>
        <li v-for="rvw in reviews" v-bind:key="rvw.id">
            <h2>{{ rvw.reviewer }}</h2>
            <h3>{{ rvw.title }}</h3>
        </li>
        </ol> -->

        <!-- for (ReviewObject rvw : reviews) { } -->
        <div class="review" v-for="rvw in reviews" v-bind:key="rvw.id">
            <h4>{{ rvw.reviewer }}</h4>
            <div class="rating">                                                                         <!-- for (int i = 1; i <= rvw.rating; i++) { } -->
                <img src="../assets/star.png" v-bind:alt="rvw.rating + ' Star Review'" class="ratingStar" v-for="i in rvw.rating" v-bind:key="i"/>
            </div>
            <h3>{{ rvw.title }}</h3>

            <p>{{ rvw.review }}</p>
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
            reviews: 
            [
                {
                    id: 1000,
                    reviewer: 'R Pérez',
                    title: 'Approachable pattern guide',
                    review: 'I love the uncomplicated, informal narrative style. I highly recommend this text for anyone trying to understand Design Patterns in a super simple way.',
                    rating: 4
                },
                {
                    id: 1001,
                    reviewer: 'Tom Pérez',
                    title: 'Unapproachable pattern guide',
                    review: 'I hate the uncomplicated, informal narrative style. I lowly recommend this text for anyone trying to understand Design Patterns in a super simple way.',
                    rating: 1
                },
            ]
        };
    },

    methods: {

    }

}
</script>

<style scoped>
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
