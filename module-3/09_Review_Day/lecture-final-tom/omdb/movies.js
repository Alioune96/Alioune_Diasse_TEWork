const baseURL = "http://www.omdbapi.com/";
const API_KEY = "e3231b55";

document.addEventListener("DOMContentLoaded", () => {

    const searchBox = document.getElementById("movie");
    const searchButton = document.getElementById("btnSearch");
    const movieTableData = document.getElementById("movieData");

    searchButton.addEventListener("click", () => {
        movieTableData.innerHTML = ''; // clear out the old search

        // Call the API!
        // URL: https://www.omdbapi.com/?apikey=e3231b55&s=star+wars
        const URL = baseURL + "?apikey=" + API_KEY + "&s=" + searchBox.value;

        fetch(URL)
        .then(response => response.json())
        .then(data => {

            data.Search.forEach((movieObject) => {
                const newRowOfMovieData = buildRow(movieObject);
                movieTableData.appendChild(newRowOfMovieData);
            });
        });
    });

});


// DOM Manipulation helper function
function buildRow(movieItem) {
    const tr = document.createElement('tr');  // <tr></tr>

    const posterCell = document.createElement('td');  // <td></td>
    const imdbCell = document.createElement('td');
    const titleCell = document.createElement('td');
    const yearCell = document.createElement('td');
    
    const img = document.createElement('img');  // <img />
    img.src = movieItem.Poster;                 // <img src="URL_to_image" />
    posterCell.appendChild(img);                // putting that into the image container

    imdbCell.innerText = movieItem.imdbID;
    titleCell.innerText = movieItem.Title;
    yearCell.innerText = movieItem.Year;

    tr.appendChild(posterCell);
    tr.appendChild(imdbCell);
    tr.appendChild(titleCell);
    tr.appendChild(yearCell);

    return tr;
}