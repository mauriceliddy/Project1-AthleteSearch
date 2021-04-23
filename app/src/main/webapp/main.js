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
  
  let table = document.getElementById("athtable");
  let data = Object.keys(userAccounts[0]);
  generateTable(table, userAccounts);
  generateTableHead(table, data);

}

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


//For use in Javascript testing(Mock data)

function checkWorkouts(number){
  var wout1 = {id:"1", type:"distance", amount:31};
  var wout2 = {id:"2", type:"gain", amount:3000};
  var wout3 = {id:"3", type:"time", amount:5};
  var workouts=[];
  workouts.push(wout1,wout2,wout3);
  
  if(number ==1){
  return workouts.length;
  }
  if(number ==2){
    return workouts[1].amount;
    }
    
  }
  
  
  module.exports = {checkWorkouts};