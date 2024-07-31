<template>
    <h2>{{james.title}}</h2>
    <h3>{{ james.author }}</h3>
    <img :src="'http://covers.openlibrary.org/b/isbn/' + james.isbn + '-M.jpg'" alt="">
    <p>Number of pages: {{ james.numPages }}</p>
    <a target="_blank" :href="james.moreInfoLink">More Information</a>
    <p v-show="james.read">I Have read this book</p>
    <p v-show="!james.read">I Have not read this book</p>
</template>

<script>

export default{

    // props: {
    //     james: Object,
    //     here: String
    // },
    computed:{
        james(){
            let keep = {};
         keep = this.$store.state.books.filter((e)=>{
             if(e.isbn == this.$route.params.id){
                return e
             }
            })[0];


        return keep;
          
        },
    }
 
 
    
}
</script>

<style>

</style>