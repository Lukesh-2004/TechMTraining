document.addEventListener("DOMContentLoaded", function () {
    const searchInput = document.getElementById("searchInput");
    const searchButton = document.getElementById("searchButton");
    const rateNowMoviesList = document.getElementById("rateNowMoviesList");
    const topRatedMoviesList = document.getElementById("topRatedMoviesList");
    const ratings = {};

    const movieDatabase = ["Interstellar", "Vidamuyarchi", "Dragon", "Neek", "Inception"]; // Example movies

    function searchMovie(query) {
        if (query) {
            let lowerCaseQuery = query.toLowerCase();
            let foundMovie = movieDatabase.find(movie => movie.toLowerCase() === lowerCaseQuery);
    
            if (foundMovie) {
                window.location.href = `review.html?movie=${encodeURIComponent(foundMovie)}`;
            } else {
                window.location.href = `redirect.html`;
            }
        }
    }

    searchButton.addEventListener("click", function () {
        searchMovie(searchInput.value.trim());
    });

    searchInput.addEventListener("keyup", function (event) {
        if (event.key === "Enter") {
            searchMovie(searchInput.value.trim());
        }
    });

    function createStarRating(movieCard) {
        const ratingContainer = document.createElement("div");
        ratingContainer.classList.add("star-rating");

        for (let i = 1; i <= 5; i++) {
            const star = document.createElement("span");
            star.classList.add("star");
            star.textContent = "☆";
            star.dataset.value = i;

            star.addEventListener("click", function () {
                const movieTitle = movieCard.querySelector(".card-title").textContent;
                ratings[movieTitle] = i;
                updateStarRating(movieCard, i);
                updateTopRatedMovies();
            });

            ratingContainer.appendChild(star);
        }
        movieCard.appendChild(ratingContainer);
    }

    function updateStarRating(movieCard, rating) {
        const stars = movieCard.querySelectorAll(".star");
        stars.forEach((star, index) => {
            star.textContent = index < rating ? "★" : "☆";
        });
    }

    function updateTopRatedMovies() {
        const sortedMovies = Object.entries(ratings).sort((a, b) => b[1] - a[1]).slice(0, 3);
        topRatedMoviesList.innerHTML = "";
        sortedMovies.forEach(([title, rating]) => {
            const movieElement = document.createElement("div");
            movieElement.classList.add("top-movie");
            movieElement.textContent = `${title} - ⭐ ${rating}/5`;
            topRatedMoviesList.appendChild(movieElement);
        });
    }

    function setupCarousel() {
        rateNowMoviesList.classList.add("carousel");
        let index = 0;
        const movies = Array.from(rateNowMoviesList.children);
        function showMovie(i) {
            movies.forEach(movie => movie.style.display = "none");
            movies[i].style.display = "block";
        }
        showMovie(index);
        setInterval(() => {
            index = (index + 1) % movies.length;
            showMovie(index);
        }, 3000);
    }

    document.querySelectorAll("#rateNowMoviesList .movie-card").forEach(movieCard => {
        createStarRating(movieCard);
    });

    setupCarousel();
});
