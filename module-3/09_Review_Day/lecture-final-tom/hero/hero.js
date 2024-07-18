// const nerdyURL = 'http://api.icndb.com/jokes/random?exclude=explicit&limitTo=nerdy';
// const randomURL = 'http://api.icndb.com/jokes/random?exclude=explicit';

const chuckURL = 'https://api.chucknorris.io/jokes/random';


document.addEventListener("DOMContentLoaded", (event) => {

    // If I'm in here, I know all of the elements are available!
    // document.querySelector("#randomButton");
    const randomButton = document.getElementById("randomButton");
    randomButton.addEventListener("click", () => {

        // 1. Call an API! 2. Receive Data 3. Update DOM (so user can enjoy)

        // Call API!  fetch(URL);  GET: URL
        fetch(chuckURL)  // Immediately returns an object called a Promise
        .then((httpResponse) => {
            // Process HTTP Response (ignore Header, turn JSON Body into native JavaScript Object)
            return httpResponse.json();  // also immediately returns a Promise
        })
        .then((data) => {

            // Now that I FINALLY have the data I want, I will use it in the DOM
            const messageBox = document.getElementById("message");
            messageBox.textContent = data.value;

        });


    });



});

function fetchExample() {

    // https://github.com/public-apis/public-apis

    fetch("URL GOES HERE, as a String")
    .then(response => response.json())
    .then(data => {
        // DOM Manipulation Goes Here
        //    WELCOME TO THE FUTURE!
    })

    //  if things go wrong:
    .catch(err => {
        console.error(err);
    });

}