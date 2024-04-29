alert("it works")
async function logProducts() {
getProducts = () =>{
return fetch("/api/products")
.then(response => response.json());
}
createProductHtmlEl = (productData) => {
const template = '
<div>
<h4>${productData.name}</h4>
<span>${productData.description}</span>
<span>${productData.price}</span>
<button data-id=${"productData.id"} Add to cart </button>
';

const newEl = document.createElement("li");
newEl.innerHTML = "abc xyz";
return newEl;
}

document.addEventListener("DOMContentLoaded", () => {
console.log("it works");
const productslist = document.querySelector("#productsList");
getProducts()
.then(products => products.map(createProductHtmlEl))
.then(productsHtmls => {
productsHtmls.forEach(htmlEl => productList.appendChild(htmlEl))
})
});

