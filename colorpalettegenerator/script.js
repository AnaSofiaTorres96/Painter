var generateAllColorsButton = document.getElementById("generateCoolors");
var generateFirstColorButton = document.getElementById("firstCoolor");
var generateSecondColorButton = document.getElementById("secondCoolor");
var generateThirdColorButton = document.getElementById("thirdCoolor");
var generateFourthColorButton = document.getElementById("fourthCoolor");
var generateFifthColorButton = document.getElementById("fifthCoolor");

generateAllColorsButton.addEventListener("click", generateAllColors);
generateFirstColorButton.addEventListener("click", ()=>generateSingleColor(generateFirstColorButton.id));
generateSecondColorButton.addEventListener("click", ()=>generateSingleColor(generateSecondColorButton.id));
generateThirdColorButton.addEventListener("click", ()=>generateSingleColor(generateThirdColorButton.id));
generateFourthColorButton.addEventListener("click", ()=>generateSingleColor(generateFourthColorButton.id));
generateFifthColorButton.addEventListener("click", ()=>generateSingleColor(generateFifthColorButton.id));



function generateAllColors(){
    let firstColor = document.getElementById("firstCoolor");
    let secondColor = document.getElementById("secondCoolor");
    let thirdColor = document.getElementById("thirdCoolor");
    let fourthColor = document.getElementById("fourthCoolor");
    let fifthColor = document.getElementById("fifthCoolor");

    firstColor.style.backgroundColor = generateHexCode();
    secondColor.style.backgroundColor = generateHexCode();
    thirdColor.style.backgroundColor = generateHexCode();
    fourthColor.style.backgroundColor = generateHexCode();
    fifthColor.style.backgroundColor = generateHexCode();

}

function generateSingleColor(id){
    let divToChange = document.getElementById(id);

    divToChange.style.backgroundColor = generateHexCode();
}

function generateHexCode(){
    var allowed = "ABCDEF0123456789", color = "#";
    
    while(color.length < 7){
        color += allowed.charAt(Math.floor((Math.random()*16)+1));
    }
    return color;
 
}

