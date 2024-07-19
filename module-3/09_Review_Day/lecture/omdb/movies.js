const baseURL = "http://www.omdbapi.com/";
const apiKey = "e3231b55";

document.addEventListener("DOMContentLoaded",()=>{

   const search =  document.getElementById("movie");
   const button = document.getElementById("btnSearch");
   const movie = document.getElementById("movieData")
   
   button.addEventListener('click',()=>{
    movie.innerHTML = " ";
    
    const secondUrl = baseURL + "?apikey=" + apiKey +"&s=" + search.value

    fetch(secondUrl).then(Response => Response.json()).then((data)=>{
    data.Search.forEach((movieItem)=>{
    const here = buildRow(movieItem);
    movie.appendChild(here);


})

       
    })
   })


})

function buildRow(movieItem) {
    const tr = document.createElement('tr');
    const posterCell = document.createElement('td');
    const imdbCell = document.createElement('td');
    const titleCell = document.createElement('td');
    const yearCell = document.createElement('td');
    const img = document.createElement('img');

    img.src = movieItem.Poster;
    posterCell.appendChild(img);

    imdbCell.innerText = movieItem.imdbID;
    titleCell.innerText = movieItem.Title;
    yearCell.innerText = movieItem.Year;

    tr.appendChild(posterCell);
    tr.appendChild(imdbCell);
    tr.appendChild(titleCell);
    tr.appendChild(yearCell);

    return tr;
}

