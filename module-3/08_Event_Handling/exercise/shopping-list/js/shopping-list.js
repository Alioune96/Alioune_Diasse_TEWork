let allItemsIncomplete = true;
const pageTitle = 'My Shopping List';
const groceries = [
  { id: 1, name: 'Oatmeal', completed: false },
  { id: 2, name: 'Milk', completed: false },
  { id: 3, name: 'Banana', completed: false },
  { id: 4, name: 'Strawberries', completed: false },
  { id: 5, name: 'Lunch Meat', completed: false },
  { id: 6, name: 'Bread', completed: false },
  { id: 7, name: 'Grapes', completed: false },
  { id: 8, name: 'Steak', completed: false },
  { id: 9, name: 'Salad', completed: false },
  { id: 10, name: 'Tea', completed: false }
];

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const title = document.getElementById('title');
  title.textContent = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const ul = document.querySelector('ul');
  groceries.forEach((item) => {
    const li = document.createElement('li');
    li.textContent = item.name;
    const checkCircle = document.createElement('i');
    checkCircle.setAttribute('class', 'far fa-check-circle');
    li.appendChild(checkCircle);
    ul.appendChild(li);
  });
}

function loopThrough(){
  
 
    const champMan = document.querySelectorAll("li");

     if(allItemsIncomplete==false){

      for(let i = 0; i < champMan.length;i++){
        champMan[i].classList.remove("completed");
      }
      const champchampchampyeahthatme = document.getElementById("toggleAll");
      champchampchampyeahthatme.textContent = "Mark All Complete";
      allItemsIncomplete = true;

    }else{
      for(let i = 0; i < champMan.length; i++){
        champMan[i].classList.add("completed");
      }
      const listenImjustTryNow = document.getElementById("toggleAll");
      listenImjustTryNow.textContent = "Mark All Incomplete";
      allItemsIncomplete=false;
    }
    


}


document.addEventListener("DOMContentLoaded",()=>{
  setPageTitle();
displayGroceries();
let eachOfThem = document.querySelectorAll("li");
eachOfThem.forEach((e)=>{
  e.addEventListener('click',()=>{ 
    e.classList.add("completed");
  })
}
)
eachOfThem.forEach((e)=>{
  e.addEventListener("dblclick",()=>{
    e.classList.remove("completed");
  })
}
)
const youA = document.getElementById("toggleAll");
youA.addEventListener("click", loopThrough)









})






