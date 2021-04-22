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

function findWorkout(){
  alert("Welcome to find a workout!");
  var day = prompt("What type of workout are you looking for?");
  var choice = prompt("Press: \n 1 for Distance\n2 for Gain\n3 for Time");
  switch (choice) {
    case 1:
        var distance = prompt("How far do you want to run?");
         var workoutType = "distance";
        break;
    case 2:
        var gain = prompt("How much vertical gain do you want?");
        workoutType = "gain";
        break;
    case 3:
        var time = prompt("How much time do you want to run for in hours?");
        workoutType = "time";
        break;
    }

    findActualWorkout(workoutType, day, distance, gain, time);

}





