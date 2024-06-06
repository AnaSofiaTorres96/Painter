import router from "../router.js";
import routes from "../routes.js";

function render(){
    
    const stylesheet = document.getElementById('stylesheet');
    stylesheet.href = 'style.css';

    const container = document.querySelector('#container');
    container.innerHTML = "";

    const headerDiv = document.createElement('div');
    headerDiv.setAttribute('id', 'headerDiv');

    const headerImg = document.createElement('img');
    headerImg.setAttribute('src','assets/rickandmortyheader.jpeg');
    headerImg.setAttribute('id', 'headerImg');

    const charactersButton = document.createElement('button');
    charactersButton.type = 'button';
    charactersButton.setAttribute('id', 'charactersButton');
    charactersButton.setAttribute('class', "blueButton");
    charactersButton.textContent = 'Meet the cast';

    const headerImgDiv = document.createElement('div');
    headerImgDiv.setAttribute('id', 'headerImgDiv');

    const headerTitle = document.createElement('div');
    headerTitle.setAttribute('id', 'headerTitle');
    headerTitle.textContent = 'Rick and Morty';

    const portalImg = document.createElement('img');
    portalImg.setAttribute('src', 'assets/PinClipart.com_rick-and-morty-clip_1496181.png');
    portalImg.setAttribute('id', 'portalImg');

    headerImgDiv.appendChild(headerImg);
    headerImgDiv.appendChild(headerTitle);
    headerImgDiv.appendChild(portalImg);
    headerDiv.appendChild(headerImgDiv);
    headerDiv.appendChild(charactersButton);
    

    charactersButton.addEventListener('click', (e)=>{
        e.preventDefault();
        window.location.hash = routes.characters.path;
    })

    container.appendChild(headerDiv);
}

export default { render };