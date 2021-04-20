console.log("Welcome to the index page/JS")
let uri = 'http://localhost:8080/app/refresh';
let userAccounts = [];

async function readInAccounts() {
    let resp = await fetch(uri);
    userAccounts = await resp.json();
    console.log(userAccounts);
    //document.querySelector('#athtable').innerHTML = new
}
readInAccounts();