<template>
            <h1>{{ checkInput }}</h1>

  <div class="container">
    <table id="tblUsers">
      <thead>
        <tr>
          <th>&nbsp;</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Username</th>
          <th>Email Address</th>
          <th>Status</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr>npm run dev
          
          <td>
            <input type="checkbox" id="selectAll" @click="grabAll" />
          </td>
          <td>
            <input type="text" id="firstNameFilter" v-model="filter.firstName" />
          </td>
          <td>
            <input type="text" id="lastNameFilter" v-model="filter.lastName" />
          </td>
          <td>
            <input type="text" id="usernameFilter" v-model="filter.username" />
          </td>
          <td>
            <input type="text" id="emailFilter" v-model="filter.emailAddress" />
          </td>
          <td>
            <select id="statusFilter" v-model="filter.status">
              <option value>Show All</option>
              <option value="Active">Active</option>
              <option value="Inactive">Inactive</option>
            </select>
          </td>
          <td>&nbsp;</td>
        </tr>
        <tr
          v-for="user in filteredList"
          v-bind:key="user.id"
          v-bind:class="{ deactivated: user.status === 'Inactive' }"
        >
          <td>
            <input type="checkbox" v-bind:id="user.id" v-bind:value="user.id" v-model="checkInput" >
          </td>
          <td >{{ user.firstName }}</td>
          <td>{{ user.lastName }}</td>
          <td>{{ user.username }}</td>
          <td>{{ user.emailAddress }}</td>
          <td>{{ user.status }}</td>
          <td>
            <button class="btnActivateDeactivate" v-if="user.status=='Active'? this.button = 'Deactivate' : this.button= 'Activate'" @click.prevent="changeWorld(user)" >{{ button }}</button>
          </td>
        </tr>
      </tbody>
    </table>

    <div class="all-actions">
      <button  @click.prevent="changeName" :disabled="this.checkInput==0">Activate Users</button>
      <button @click.prevent="goAgain" :disabled="this.checkInput==0">Deactivate Users</button>
      <button @click.prevent="thirdButton" :disabled="this.checkInput==0">Delete Users</button>
    </div>

  
  
    <button  @click.prevent="getClick">Add New User</button>
    <form v-show="!showForm" id="frmAddNewUser" >
      <div class="field">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" v-model="this.newUser.firstName"/>
      </div>
      <div class="field">
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" v-model="this.newUser.lastName" />
      </div>
      <div class="field">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" v-model="this.newUser.username"/>
      </div>
      <div class="field">
        <label for="emailAddress">Email Address:</label>
        <input type="text" id="emailAddress" name="emailAddress" v-model="this.newUser.emailAddress" />
      </div>
      <button type="submit" class="btn save" @click.prevent="addButton" >Save User</button>
    </form>
  </div>
</template>

<script>


export default {
  data() {
    return {
      button:"",
      filter: {
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: ""
      },
      nextUserId: 7,
      newUser: {
        id: null,
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: "Active"
      },
      showForm: true,
      checkInput: [],
      yougrabbing : true,

      users: [
        {
          id: 1,
          firstName: "John",
          lastName: "Smith",
          username: "jsmith",
          emailAddress: "jsmith@gmail.com",
          status: "Active"
        },
        {
          id: 2,
          firstName: "Anna",
          lastName: "Bell",
          username: "abell",
          emailAddress: "abell@yahoo.com",
          status: "Active"
        },
        {
          id: 3,
          firstName: "George",
          lastName: "Best",
          username: "gbest",
          emailAddress: "gbest@gmail.com",
          status: "Inactive"
        },
        {
          id: 4,
          firstName: "Ben",
          lastName: "Carter",
          username: "bcarter",
          emailAddress: "bcarter@gmail.com",
          status: "Active"
        },
        {
          id: 5,
          firstName: "Katie",
          lastName: "Jackson",
          username: "kjackson",
          emailAddress: "kjackson@yahoo.com",
          status: "Active"
        },
        {
          id: 6,
          firstName: "Mark",
          lastName: "Smith",
          username: "msmith",
          emailAddress: "msmith@foo.com",
          status: "Inactive"
        }
      ]
    };
  },
  methods: {
    changeName(){
      
      if(this.checkInput != 0){
      for(let i =0; i < this.checkInput.length; i++){
          this.filteredList.filter((e)=>{
            if(e.id==this.checkInput[i]){
              e.status = "Active";
            }
          })
        
      }
      this.checkInput = [];
    }
  },
    goAgain(){
      if(this.checkInput != 0){
      for(let i = 0; i < this.checkInput.length;i++){
        this.filteredList.filter((e)=>{
          if(e.id == this.checkInput[i]){
            e.status = "Inactive";
          }
        })
      }
      this.checkInput = [];
    }
  },

    grabAll(){
      if(this.yougrabbing == true){
      this.filteredList.forEach((e)=>{this.checkInput.push(e.id)})
      this.yougrabbing = false
    }else{
      this.filteredList.forEach(()=>{this.checkInput.pop()})
      this.yougrabbing = true
      this.checkInput = []
    }
      

    },


    thirdButton(){
      if(this.checkInput != 0){
      for(let i = 0; i < this.checkInput.length; i++){
        this.filteredList.forEach((e,index)=>{
          if(e.id==this.checkInput[i]){
            this.filteredList.splice(index,1)
          }
        })
      }


    }
  },
    getNextUserId() {
      return this.nextUserId++;
    },
    getClick(){
      if(this.showForm==false){
        this.showForm = true
      }else{
        this.showForm = false;
      } 
    },
    addButton(){
      this.newUser.id = this.getNextUserId();
      this.users.push(this.newUser);
      this.newUser = {};
    },
    changeWorld(user){
        if(user.status=='Active'){
          return user.status ="Inactive";
        }else{
          return user.status = "Active";
        }
      },
     
        },

      


   
  
  computed: {
    filteredList() {
      let filteredUsers = this.users;
      if (this.filter.firstName != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.firstName
            .toLowerCase()
            .includes(this.filter.firstName.toLowerCase())
        );
      }
      if (this.filter.lastName != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.lastName
            .toLowerCase()
            .includes(this.filter.lastName.toLowerCase())
        );
      }
      if (this.filter.username != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.username
            .toLowerCase()
            .includes(this.filter.username.toLowerCase())
        );
      }
      if (this.filter.emailAddress != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.emailAddress
            .toLowerCase()
            .includes(this.filter.emailAddress.toLowerCase())
        );
      }
      if (this.filter.status != "") {
        filteredUsers = filteredUsers.filter((user) =>
          user.status === this.filter.status
        );
      }
      return filteredUsers;
    }
  }
};

</script>

<style scoped>
table {
  margin-top: 20px;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  margin-bottom: 20px;
}
th {
  text-transform: uppercase;
}
td {
  padding: 10px;
}
tr.deactivated {
  color: red;
}
input,
select {
  font-size: 16px;
}

form {
  margin: 20px;
  width: 350px;
}
.field {
  padding: 10px 0px;
}
label {
  width: 140px;
  display: inline-block;
}
button {
  margin-right: 5px;
}
.all-actions {
  margin-bottom: 40px;
}
.btn.save {
  margin: 20px;
  float: right;
}
</style>
