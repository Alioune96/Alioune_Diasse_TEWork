
<template>
    <section>
        <h2>Product Reviews For </h2>

        <h1>{{ productName }} {{ description }}</h1>

        <div class="sf" v-for="r in reviews" :key="r.reviewer">
        <h2>{{ r.reviewer }}</h2>
        <p>{{ r.review }}</p>
        </div>

        


        <p class="description"></p>
    </section>
</template>
<script>


export default {
    data() {
        return {
            productName: "Dummies",
            description: "Look at That",
            reviews: [{

                id: 1000,
                reviewer: 'R Pérez',
                title: 'Approachable pattern guide',
                review:
                    'I love the uncomplicated, informal narrative style. I highly recommend this text for anyone trying to understand Design Patterns in a super simple way.',
                rating: 4
            },
            {

                id: 1000,
                reviewer: 'James',
                title: 'Approachable pattern guide',
                review:
                    'I love the uncomplicated, informal narrative style. I highly recommend this text for anyone trying to understand Design Patterns in a super simple way.',
                rating: 4
            }]
        }



    },


}
</script>
<style scoped>
.sf{
    border: 3px dotted green;
}

</style>