// add pageTitle
let pageTitle = "My Shopping List";

// add groceries

let groceries = ["Chips","Water","Hot Dog", "More Chip", "More Water","Candy", "Ramen", "More Ramen","More Candy","Even More Candy"]


/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  
  let herethereGO = document.getElementById("title");
  herethereGO.textContent = pageTitle;


}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {

  let whatwillyoudo = document.getElementById("groceries");

  for(let i = 0; i < groceries.length; i++){
      let createNew = document.createElement("li");
      createNew.textContent = groceries[i];
      whatwillyoudo.appendChild(createNew)
  }

}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
    let listFun = document.getElementsByTagName("li");
    for(let i = 0; i<listFun.length; i++){
   listFun[i].classList.add("completed");
    }
}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
