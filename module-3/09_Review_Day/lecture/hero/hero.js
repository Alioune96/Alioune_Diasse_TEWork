const nerdyURL = 'http://api.icndb.com/jokes/random?exclude=explicit&limitTo=nerdy';
const randomURL = 'http://api.icndb.com/jokes/random?exclude=explicit';
let urlStuff = "https://api.chucknorris.io/jokes/random";


document.addEventListener("DOMContentLoaded",()=>{
  
    const button = document.getElementById("randomButton");
    button.addEventListener('click', ()=>{
        

        fetch(urlStuff).then((httpRespond)=>{
           return returnBuddy = httpRespond.json();
        }).then((data)=>{
            const james = document.getElementById("message").textContent= data.url;
            
        })
    })

    const second = document.getElementById("nerdButton");
    second.addEventListener('click',()=>{
        fetch(url).then((httpRespond)=>{
            return httpRespond.json()

        }).then((data)=>{
            const printOut = document.querySelector('message').textContent = data.value;
        }))




})