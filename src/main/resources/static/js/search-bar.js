const itemsList = document.getElementById('itemsList')
const searchBar = document.getElementById('searchInput')

const allItems = [];

fetch("http://localhost:8080/items/api").
then(response => response.json()).
then(data => {
    for (let item of data) {
        allItems.push(data)
    }
})

//TODO: add key listener to the search

//TODO: create method that adds an album...