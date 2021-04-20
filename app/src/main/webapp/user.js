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


  //Workouts

  let workouturi = 'http://localhost:8080/app/workouts';
let workouts = [];

async function readInWorkouts() {
    let resp = await fetch(workouturi);
    workouts = await resp.json();
    console.log(workouts);
    //document.querySelector('#athtable').innerHTML = new
}
readInWorkouts();


function generateWorkoutTable(){
  console.log("trying to create a table")
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
  
  let table = document.getElementById("workoutstable");
  let data = Object.keys(workouts[0]);
  generateTable(table, workouts);
  generateTableHead(table, data);
}



 