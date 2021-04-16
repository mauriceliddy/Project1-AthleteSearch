console.log("hello from javascript land")


let uri = 'http://localhost:8080/app/refresh';
let userAccounts = [];

async function readInAccounts() {
    let resp = await fetch(uri);
    userAccounts = await resp.json();
    console.log(userAccounts);
    //document.querySelector('#athtable').innerHTML = new
}
readInAccounts();



function generateUserTable(){
  function generateTableHead(table, data) {
    let thead = table.createTHead();
    let row = thead.insertRow();
    for (let key of data) {
      let th = document.createElement("th");
      let text = document.createTextNode(key);
      th.appendChild(text);
      row.appendChild(th);
    }
  }
  
  function generateTable(table, data) {
    for (let element of data) {
      let row = table.insertRow();
      for (key in element) {
        let cell = row.insertCell();
        let text = document.createTextNode(element[key]);
        cell.appendChild(text);
      }
    }
  }
  
  let table = document.querySelector("table");
  let data = Object.keys(userAccounts[0]);
  generateTable(table, userAccounts);
  generateTableHead(table, data);
}

// var x="";
// function showUsers(){
//     for (i in userAccounts) {
//         x+= "<h3>" + userAccounts[i].name + " "+ userAccounts[i].password+ "</h3>";
//         console.log(x);
//       }
//       document.querySelector("#athtable").innerHTML = x;
// }



