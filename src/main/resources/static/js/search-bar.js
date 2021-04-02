const itemsList = document.getElementById('itemsList')
const searchBar = document.getElementById('searchInput')

const allItems = [];

fetch("http://localhost:8080/items/api").
then(response => response.json()).
then(data => {
    for (let item of data) {
        allItems.push(item)
    }
})

console.log(allItems);

searchBar.addEventListener('keyup', (e) => {
    const searchingCharacters = searchBar.value.toLowerCase();
    let filteredItems = allItems.filter(item => {
        return item.name.toLowerCase().includes(searchingCharacters)
            || item.brand.toLowerCase().includes(searchingCharacters);
    });
    displayItems(filteredItems);
})


const displayItems = (items) => {
    itemsList.innerHTML = items
        .map((i) => {
            return `  <div class="col-md-3" >
                <div class="card mb-4 box-shadow">
                <img src="${i.imageUrl}" class="card-img-top" alt="Thumbnail [100%x225]"
                     data-holder-rendered="true"
                     style="height: 225px; width: 100%; display: block;">
                <div class="card-body">
                    <div class="text-center">
                        <p class="card-text border-bottom ">Name: ${i.name}</p>
                        <p class="card-text border-bottom ">Brand: ${i.brand}</p>
                        <p class="card-text border-bottom ">Type: ${i.categoryEnum}</p>
                       
                    </div>
                    <div class="d-flex justify-content-between align-items-center">
                        <div class="btn-group">
                            <a href="/items/details/${i.id}"  type="button" class="btn btn-sm btn-outline-secondary">Details</a>
                        </div>
                       <th:block>
                        <div  class="btn-group">
                            <a href="/items/delete/${i.id}"  type="button" class="btn btn-sm btn-outline-secondary">Delete</a>
                        </div>
                        </th:block>
                    </div>
                </div>
            </div>
            </div>`
        })
        .join('');
    }
