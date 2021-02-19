`use strict`
const allListToDisplay = document.querySelector("#displayBoxAll")
const ListToDisplay = document.querySelector("#displayBox")
const givenId = document.querySelector("#ListId")

const printToScreenAll = (Lists) => {
    for (let list of Lists) {
        for (let info in list) {
            let actualText = document.createTextNode(
                `${info}: ${list[info]} `
            );
            console.log(info + ":" + list[info]);
            allListToDisplay.append(actualText)
        }
    }
}

const printToScreen = (list) => {
    for (let info in list) {
        let actualText = document.createTextNode(
            `${info}: ${list[info]} `
        );
        console.log(info + ":" + list[info]);
        ListToDisplay.append(actualText)
    }

}


const readAll =()=>{
    allListToDisplay.innerHTML = "";
    fetch(`http://localhost:9090/list/read`)
    .then((response)=>{
        if (response.status !== 200){
            console.error(`status ${response.status}`);
            return;
        }
        response.json()
        .then((data)=>{
            console.info(data),
        printToScreenAll(data)
        })
        
        
    }).catch((err)=>console.error(err))
    
    

}

const readAllItems =()=>{
    allListToDisplay.innerHTML = "";
    fetch(`http://localhost:9090/item/read`)
    .then((response)=>{
        if (response.status !== 200){
            console.error(`status ${response.status}`);
            return;
        }
        response.json()
        .then((data)=>{
            console.info(data),
        printToScreenAll(data)
        })
        
        
    }).catch((err)=>console.error(err))
    
    

}


const readById =()=>{
    ListToDisplay.innerHTML = "";
    const id = givenId.value

    fetch("http://localhost:9090/list/read/" + id)
    .then((response)=>{
        if (response.status !== 200){
            console.error(`status ${response.status}`);
            return;
        }
        response.json().then((data)=>{
            console.info(data)
            printToScreen(data)});
    })
    .catch((err)=>console.error(err))

}

const readByItemId =()=>{
    ListToDisplay.innerHTML = "";
    const id = givenId.value

    fetch("http://localhost:9090/item/read/" + id)
    .then((response)=>{
        if (response.status !== 200){
            console.error(`status ${response.status}`);
            return;
        }
        response.json().then((data)=>{
            console.info(data)
            printToScreen(data)});
    })
    .catch((err)=>console.error(err))

}

