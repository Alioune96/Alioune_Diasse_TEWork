<template>
    <form class = "new-book-form" action="">
        
        <label for="Title"></label>
        <input class="title-input"  type="text" v-model="title" placeholder="Title">
        <label for="Author"></label>
        <input class="author-input"   type="text" v-model="author" placeholder="Author">
        <label for="ISBN"></label>
        <input class="isbn-input" type="text" v-model="isbn" placeholder="ISBN"><br>
        <button @click.prevent = "secondOne" >Submit</button>
    </form>

</template>
<script>
export default {
        data(){
        return{
            title: '',
            author: '',
            isbn: ''

        }
            
    },


    methods: {
       
        secondOne(){
            const newOne = {
                    title: this.title,
                    author: this.author,
                    isbn: this.isbn,
                    read: true,
                };
            this.$store.commit("ADD_MORE",newOne);
            this.title = '';
            this.author = '';
            this.isbn = '';
        }
           
        }
    

    
}
</script>
<style>

.isbn-input{
    border: 1px solid black;
    margin-left: 2px;
}

.author-input{
    border: 1px solid black;
    margin-left: 2px; 
}

.title-input{
    border: 1px solid black ;
    margin-left: 2px;
}

</style>