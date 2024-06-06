import charactersView from "../view/charactersView.js";

function init (){
    charactersView.render();
    
}

async function fetchCharacterData() {
    const apiUrl = 'https://rickandmortyapi.com/api/character';

    try {
        const response = await fetch(apiUrl);
        if (!response.ok) {
            throw new Error('Failed to fetch character data: network response not ok');
        }
        const data = await response.json();
        return data;
    } catch (error) {
        console.log('Failed to fetch character data:', error);
    }
}
//export const characterModule = { init, fetchCharacterData };

export default { init, fetchCharacterData }