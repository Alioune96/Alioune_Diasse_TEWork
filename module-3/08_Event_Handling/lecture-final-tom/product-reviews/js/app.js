


const bookName = 'Cigar Parties for Dummies';
let description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
let reviews = [
  {
    reviewer: 'Malcolm Madwell',
    title: 'What a book!',
    review:
    "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language. Yes indeed, it is a book!",
    rating: 3
  }
];

/**
 * Add product name to the page title.
 */
function setPageTitle() {
  const pageTitle = document.getElementById('page-title');
  pageTitle.querySelector('.name').textContent = bookName;
}

/**
 * Add product description to the page.
 */
function setPageDescription() {
  document.querySelector('.description').textContent = description;
}

/**
 * Display all of the reviews in the reviews array.
 */
function displayReviews() {
  if ('content' in document.createElement('template')) {
    reviews.forEach((review) => {
      displayReview(review);
    });
  } else {
    console.error('Your browser does not support templates');
  }
}

/**
 * Add single review to the page.
 *
 * @param {Object} review The review to display
 */
function displayReview(review) {
  const main = document.getElementById('main');
  const tmpl = document.getElementById('review-template').content.cloneNode(true);
  tmpl.querySelector('h4').textContent = review.reviewer;
  tmpl.querySelector('h3').textContent = review.title;
  tmpl.querySelector('p').textContent = review.review;
  // there will always be 1 star because it is a part of the template
  for (let i = 1; i < review.rating; ++i) {
    const img = tmpl.querySelector('img').cloneNode();
    tmpl.querySelector('.rating').appendChild(img);
  }
  main.appendChild(tmpl);
}

// LECTURE STARTS HERE ---------------------------------------------------------------


document.addEventListener("DOMContentLoaded", () => {
  // Set the product reviews page title.
  setPageTitle();
  // Set the product reviews page description.
  setPageDescription();
  // Display all of the product reviews on our page.
  displayReviews();

  const pBox = document.querySelector("p.description");
  pBox.addEventListener("click", (event) => {
//    console.log("P box received a click!");
    toggleDescriptionEdit(event.target);
  });


  const inputBox = document.getElementById("inputDesc");
  inputBox.addEventListener("blur", () => {
    exitDescriptionEdit(inputBox, true);
  });

  const addReviewButton = document.getElementById("btnToggleForm");
  addReviewButton.addEventListener("click", showHideForm);


  const submitReviewButton = document.getElementById("btnSaveReview");
  submitReviewButton.addEventListener("click", (event) => {
    event.preventDefault();
    saveReview();
  });

  // document.querySelector("form").addEventListener("submit", (event) => {
  //   event.preventDefault();
  // });



  // document.getElementById("main").addEventListener("click", (event) => {
  //   console.log("div#main (the parent of p) received a click! ... don't tell my parent!");
  //   event.stopPropagation();
  // });


  // document.querySelector("body").addEventListener("click", (event) => {
  //   //event.stopPropagation();
  //   console.log("Body received a click!");
  // });

  // document.querySelector("html").addEventListener("click", () => {
  //   console.log("HTML received a click!");
  // });


  // document.addEventListener("click", (event) => {
  //   // alert(`(${event.x}, ${event.y})`);
  //   console.log("Document received a click!");
  // });


  // document.addEventListener("keyup", (event) => {
  //   console.log("User pressed: " + event.key)

  //   evil += event.key;

  //   // API Call to evil server HTTP POST: {evil}
  // });






});
let evil = "";

function showEvil() {
  console.log(evil);
}

// document.addEventListener("DOMContentLoaded", doStuff);

function doStuff() {
  // Set the product reviews page title.
  setPageTitle();
  // Set the product reviews page description.
  setPageDescription();
  // Display all of the product reviews on our page.
  displayReviews();  
}



/**
 * Hide the description and show the text box.
 *
 * @param {Element} desc the element containing the description
 */
function toggleDescriptionEdit(desc) {
  const textBox = desc.nextElementSibling;  // find the Input Box (relative to the P box)
  textBox.value = desc.textContent;         // pre-populate Input Box with whatever is in P box
  textBox.classList.remove('d-none');       // Show Input Box (by removing display: none)
  desc.classList.add('d-none');             // Hide the P Box (by adding display: none)
  textBox.focus();                          // activate the Input Box
}


/**
 * Hide the text box and show the description.
 * If save is true, also set the description to the contents of the text box.
 *
 * @param {Element} textBox the input element containing the edited description
 * @param {Boolean} save should we save the description text
 */
function exitDescriptionEdit(textBox, save) {
  let desc = textBox.previousElementSibling;  // Find the P box, given the Text Box
  if (save) {
    desc.textContent = textBox.value;         // if we're keeping it, set the P box content to the Input Box value (what the user typed)
  }
  textBox.classList.add('d-none');            // Hide Input Box
  desc.classList.remove('d-none');            // Show P box
}

/**
 * Toggle visibility of the add review form.
 */
function showHideForm() {
  const form = document.querySelector('form');
  const btn = document.getElementById('btnToggleForm');

  if (form.classList.contains('d-none')) {
    // If the form is hidden, show it!
    form.classList.remove('d-none');
    btn.textContent = 'Hide Form';
    document.getElementById('name').focus();
  } else {
    // The form is showing, so hide it!
    resetFormValues();
    form.classList.add('d-none');
    btn.textContent = 'Add Review';
  }
}

/**
 * Reset all of the values in the form.
 */
function resetFormValues() {
  const form = document.querySelector('form');
  const inputs = form.querySelectorAll('input');
  inputs.forEach((input) => {
    input.value = '';
  });
  document.getElementById('rating').value = 1;
  document.getElementById('review').value = '';
}

/**
 * Save the review that was added using the add review form.
 */
function saveReview() {
  const reviewerName = document.getElementById("name").value;
  const reviewTitle = document.getElementById("title").value;
  const reviewRating = document.getElementById("rating").value;
  const reviewContent = document.getElementById("review").value;

  if (reviewerName && reviewTitle && reviewRating && reviewContent) {
    const newReview = {
      reviewer: reviewerName,
      title: reviewTitle,
      review: reviewContent,
      rating: reviewRating
    };

    reviews.unshift(newReview);
    // document.querySelectorAll('.review').forEach((div) => {
    //   div.innerHTML = '';
    // });
    // displayReviews();

    displayReview(newReview);
    showHideForm();
  }
}
