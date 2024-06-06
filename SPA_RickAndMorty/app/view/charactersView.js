import charactersController from "../controller/charactersController.js";

function render(){
    let characterData;

    const stylesheet = document.getElementById('stylesheet');
    stylesheet.href = 'charactersPageStyle.css';

    const container = document.querySelector('#container');
    container.innerHTML = "";
    
    const charactersHeaderDiv = document.createElement('div');
    charactersHeaderDiv.setAttribute('id', 'charactersHeaderDiv');

    const charactersHeaderImg = document.createElement('img');
    charactersHeaderImg.setAttribute('src', 'assets/rickandmortyheader.jpeg');
    charactersHeaderImg.setAttribute('id', 'charactersHeaderImg');
    
    const charactersDiv = document.createElement('div');
    charactersDiv.setAttribute('id', 'charactersDiv');

    const pagerDiv = document.createElement('div');
    pagerDiv.setAttribute('id', 'pagerDiv');

    const previousPageButton = document.createElement('button');
    previousPageButton.type = 'button';
    previousPageButton.textContent ='<';
    previousPageButton.setAttribute('id','prevpageButton');
    previousPageButton.setAttribute('class', 'pagerButton');

    const searchForm = document.createElement("form");
    searchForm.setAttribute('id', 'searchForm');
    searchForm.action = "/submit_form.php"; // Set form action attribute
    searchForm.method = "get"; // Set form method attribute
    // Create an input element
    var input = document.createElement("input");
    input.type = "text"; // Set input type attribute
    input.name = "search"; // Set input name attribute
    input.placeholder = "search"; // Set input placeholder attribute

    // Append input element to the form
    searchForm.appendChild(input);

    const nextPageButton = document.createElement('button');
    nextPageButton.type = 'button';
    nextPageButton.textContent ='>';
    nextPageButton.setAttribute('id','nextpageButton');
    nextPageButton.setAttribute('class', 'pagerButton');

    charactersHeaderDiv.appendChild(charactersHeaderImg);
    pagerDiv.appendChild(previousPageButton);
    pagerDiv.appendChild(searchForm);
    pagerDiv.appendChild(nextPageButton);
    charactersDiv.appendChild(pagerDiv);
    container.appendChild(charactersHeaderDiv);
    container.appendChild(charactersDiv);

    charactersController.fetchCharacterData()
    .then(data => {
        characterData =data;
        
    //div under the header where all cards will go 
        

        for(let i = 0; i<characterData.results.length; i++){
            //all this has to happen for all cards
            const characterCard = document.createElement('div');
            characterCard.setAttribute('class', 'singCharacterCard');

            const characterImageDiv = document.createElement('div');
            characterImageDiv.setAttribute('class', characterImageDiv);
            const characterImage = document.createElement('img');
            characterImage.setAttribute('class','singleCharacterImg');
            characterImage.setAttribute('src', characterData.results[i].image);
            
            //at the end of each loop you have append everything to parents and finally to character div
            characterImageDiv.appendChild(characterImage);
            characterCard.appendChild(characterImageDiv);
            charactersDiv.appendChild(characterCard);
    
        }
        container.appendChild(charactersDiv);
    })
    .catch(error => {
        console.error('Failed to fetch character data:', error);
    });

    
}

export default { render }