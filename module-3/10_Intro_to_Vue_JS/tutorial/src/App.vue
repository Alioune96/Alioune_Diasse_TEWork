<template>
  <div id="todo-app">
    <h1>{{ firstName }}</h1>
    <ul>
      <li v-for="kid in kids" :key="kid">{{ kid }} {{ narutobasedCalor }}</li>
    </ul>
    
  </div>
</template>

<script>


export default {

  data(){
    return{ 
    firstName : "Naruto",
    lastName : "Uzimaku",
    isheHokage : true,
    kids : ["Boruto", "himawari uzumaki", "sasuke"]
    }
  },
  computed: {
    narutobasedCalor(){
      
      if(this.isheHokage){
       this.kids =["sasuke",'konahoruma', 'might guy','everyone in the village'];
      }
    
    }
  } 
}
</script>

<style>
body {
  background: rgb(74,162,244);
}
</style>
