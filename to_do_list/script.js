var addTaskButton = document.getElementById("addTaskButton");
var taskTable = document.getElementById("taskTable");
var numbrOfTasks = 0;

addTaskButton.addEventListener("click", submitTask);

function submitTask(){
    //inputCaptured
    let taskNameInput = document.getElementById("taskNameInput").value;
    let taskDescriptionInput = document.getElementById("taskDescriptionInput").value;
    let status = "Incomplete";
    
    //this isnt workin
    if(!taskNameInput|| !taskDescriptionInput){
        alert("You forgot to fill in everything!")
        return;
    }

    //change HTML here
    let row = document.createElement("tr");
    let c1 = document.createElement("td");
    let c2 = document.createElement("td");
    let c3 = document.createElement("td");
    let c4 = document.createElement("button");
    let c5 = document.createElement("button");
        
    //add ids so i can find them later
    c1.id = "taskNameCell"+ numbrOfTasks;
    c1.className = "tableCell";
    c2.id = "taskDescriptionCell"+ numbrOfTasks;
    c2.className = "tableCell";
    c3.id = "statusCell"+ numbrOfTasks;

    c4.id = "completeButton"+ numbrOfTasks;
    c4.className = "completeTaskButton";
    c5.id = "removeButton"+ numbrOfTasks;
    c5.className = "removeTaskButton";
        
    c1.innerText = taskNameInput;
    c2.innerText = taskDescriptionInput;
    c3.innerText = status;
        
        
    row.appendChild(c1);
    row.appendChild(c2);
    row.appendChild(c3);
    row.appendChild(c4);
    row.appendChild(c5);
        
        
    taskTable.appendChild(row);
    document.getElementById("taskNameInput").value = "";
    document.getElementById("taskDescriptionInput").value = "";
    numbrOfTasks ++;

    c4.addEventListener("click", () => setTaskToComplete(c3.id, c4.id));
    c5.addEventListener("click", () => removeTask(row));

    //alert makes it so the items are only added after you press the alert button
    //alert("Submited Task!");
}

function setTaskToComplete(id, buttonId){
    console.log(id);
    document.getElementById(id).innerText = "Completed";
    document.getElementById(buttonId).disabled = true;

    //change look of button
    document.getElementById(buttonId).className = "disabledCompletedTaskButton"

    console.log("wao you completed a task");

}

function removeTask(row){
    row.remove();
    
    //REMOVE WHOLE ROW
    console.log("task remove");
}


