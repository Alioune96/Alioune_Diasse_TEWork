<template>
    <ReadingListVue></ReadingListVue>
    <router-link class="lower" :to = "{name: 'NewBook'}">Add Book to Reading List</router-link>
</template>

<script>
import ReadingListVue from '../components/ReadingList.vue'

export default {
    components:{
        ReadingListVue
    },

    methods: {
        justCase(){
            this
        }
    },
}
</script>

<style>
.lower{
    font-weight: lighter;
    text-decoration: underline;
}

</style>