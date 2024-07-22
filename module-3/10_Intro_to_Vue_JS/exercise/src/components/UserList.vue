<template>
  <table id="tblUsers">
    <thead>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Username</th>
        <th>Email Address</th>
        <th>Status</th>
    </tr>
    <tr>
      <td><input type="text" id="firstNameFilter" v-model="search.firstName"/></td>
      <td><input type="text" id="lastNameFilter" v-model="search.lastName"/></td>
      <td><input type="text" id="usernameFilter" v-model="search.username" /></td>
      <td><input type="text" id="emailFilter" v-model="search.emailAddress"/></td>
      <td>
        <select id="statusFilter" v-model="search.status"  >
          <option  value="" >Show All</option>
          <option value="Active">Active</option>
          <option value="Inactive">Inactive</option>
        </select>
      </td>
    </tr>
    </thead>

    <tbody>
      <tr v-for="(user, index) in filteredList" :key="index" class="Inactive" :class="{inactive: user.status.match('Inactive')}">
        <td>{{ user.firstName }}</td>
        <td>{{ user.lastName }}</td>
        <td>{{ user.username }}</td>
        <td>{{ user.emailAddress }}</td>
        <td>{{ user.status }}</td>
      </tr>
      
    </tbody>
  </table>
</template>

<script>
export default {
  data() {
    return {
      
      users: [
        { firstName: "John", lastName: 'Smith', username: 'jsmith', emailAddress: 'jsmith@gmail.com', status: 'Active' },
        { firstName: 'Anna', lastName: 'Bell', username: 'abell', emailAddress: 'abell@yahoo.com', status: 'Active' },
        { firstName: 'George', lastName: 'Best', username: 'gbest', emailAddress: 'gbest@gmail.com', status: 'Inactive' },
        { firstName: 'Ben', lastName: 'Carter', username: 'bcarter', emailAddress: 'bcarter@gmail.com', status: 'Active' },
        { firstName: 'Katie', lastName: 'Jackson', username: 'kjackson', emailAddress: 'kjackson@yahoo.com', status: 'Active' },
        { firstName: 'Mark', lastName: 'Smith', username: 'msmith', emailAddress: 'msmith@foo.com', status: 'Inactive' },
      ],
      search:{
        firstName:"",
        lastName:"",
        username: "",
        emailAddress: "",
        status: "",

      },
  };
},
computed:{
  filteredList(){
    let usersForfun = this.users;
   
    
   if(this.search.firstName != '' ){
 usersForfun = this.users.filter((u)=> u.firstName.toLowerCase().match(this.search.firstName.toLowerCase()))   
    }
   if( this.search.lastName != ''){
 usersForfun = this.users.filter((u)=> u.lastName.toLowerCase().match(this.search.lastName.toLowerCase()))
   }
   if(this.search.emailAddress != ''){
usersForfun = this.users.filter((u)=> u.emailAddress.toLowerCase().match(this.search.emailAddress.toLowerCase()))
   }
   if(this.search.username != ''){
usersForfun = this.users.filter((u)=> u.username.toLowerCase().match(this.search.username.toLowerCase()))
   }
  
  if(this.search.status == "Inactive"){
  usersForfun = this.users.filter((e)=>e.status.match(this.search.status));
   }
   
   if(this.search.status == "Active"){
  usersForfun = this.users.filter((e)=>e.status.match(this.search.status));
   }
   
   
   
   return usersForfun;


},


}
}
      

</script>

<style scoped>
table {
  margin-top: 20px;
  font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif
}
th {
  text-transform: uppercase
}
td {
  padding: 10px;
}
tr.inactive {
  color: red;
}
input, select {
  font-size: 16px;
}





</style>
