//this file does the redirecting by launching the necessary controllers
import routes from '../app/routes.js';

function setCurrentRoute({path, controller}){
//basic setter
    routes.currentPath.path = path;
    routes.currentPath.controller = controller;

}

async function launchController(controllerName){
//has to await to make sure the import is present
    const module = await import(`../app/controller/${controllerName}.js`);

    module.default.init();
}

function navigate(path){
//dont do anything if you're already in the page you're going to
    if(path == routes.currentPath.path){
        return;
    }
//in routes look for the key(route) that matches the one in param
    const routeKey = Object.keys(routes).find(key=> routes[key].path === path);
//if routeKey is empty sets home as default
    const route = routes[routeKey] || routes.home;

    setCurrentRoute(route);
    launchController(route.controller);
}

function getPath(urlStr){
//extract endpoint
    return new URL(urlStr).hash.slice(1);
}

function navigateOnHashChange(){
    addEventListener('hashchange', (e)=>{
        const path = getPath(e.newURL);
        navigate(path);
    })
}

function init(){
//assure that theres an hash by having a default home value
    window.location.hash = window.location.hash || routes.home.path;

    navigate(getPath(window.location.href));
    navigateOnHashChange();
}

export default { init, navigate }

