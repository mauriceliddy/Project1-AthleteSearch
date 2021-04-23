console.log("hello from javascript land")


  //Workouts

  let workouturi = 'http://localhost:8080/app/userWorkouts';
let workouts = [];

async function readInWorkouts() {
    let resp = await fetch(workouturi);
    workouts = await resp.json();
    console.log(workouts);
    var uName= workouts[0].userAccount.name;
console.log("Name in the fucntion:" + uName)
document.querySelector('#uname').innerHTML = uName;
    
}
readInWorkouts();


function generateWorkoutTable(){
  
  if(workouts.length == 0){
    alert("You don't have any workouts added, im afraid.You should run more");
  }

  
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
  
var user1 = {id:"1", name:"Maurice", color:"password"};
var user2 = {id:"2", name:"Nick", color:"password2"};
var user3 = {id:"3", name:"Burke", color:"password3"};

var users=[];
users.push(user1,user2,user3);







