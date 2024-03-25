alert("it works")
async function logProducts() {
  const response = await fetch("/api/products");
  const movies = await response.json();
  console.log(products);
}
