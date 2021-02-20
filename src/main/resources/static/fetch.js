`use strict`

const ListName = document.querySelector("#name")
function createList(){
    
        let myObj = {
            name :ListName.value
        }
    
        fetch(`http://localhost:9090/list/create`,{
            method:`post`,
            headers: {
                "Content-type": "application/json"
            },
            body: JSON.stringify(myObj),
        })
        .then(res => res.json())
        .then((data) => console.log(`Request succeeded with JSON response ${data}`))
        .catch((err) => console.log(err))
        alert("List Created")
     
}

const itemName = document.querySelector("#item_name")
const itemAction = document.querySelector("#item_action")
const listId = document.querySelector("#listName")
function createItem(){

    let myObj = {
        item_name : itemName.value,
        item_action : itemAction.value,
        listName :{
            id : listId.value
        }
    }

    fetch(`http://localhost:9090/item/create`,{
        method:`post`,
        headers:{
            "Content-type":"application/json"
        },
        body:JSON.stringify(myObj),
    })
    .then(res => res.json())
    .then((data) => console.log(`Request succeeded with JSON response ${data}`))
    .catch((err) => console.log(err))
    alert("Item Created")
     
}

const getData =()=>{
    fetch(`http://localhost:9090/list/read`)
    .then((response)=>{
        if (response.status !== 200){
            console.error(`status ${response.status}`);
            return;
        }
        response.json().then((data)=>console.info(data));
    })
    .catch((err)=>console.error(err))
    

}

const getById =(id)=>{
    fetch(`http://localhost:9090/list/read/${id}`)
    .then((response)=>{
        if (response.status !== 200){
            console.error(`status ${response.status}`);
            return;
        }
        response.json().then((data)=>console.info(data));
    })
    .catch((err)=>console.error(err))

}



const deleteById =(id)=>{

    fetch(`http://localhost:9090/list/delete/${id}`,{
         method:`delete`,
        headers: {
            "Content-type": "application/json"
        },
    })
    .then(res => res.json())
    .then((data) => console.log(`Request succeeded with JSON response ${data}`))
    .catch((err) => console.log(err))
}

const updateList =(id, name)=>{

    const myObj = {
        "name" : name
    }

    fetch(`http://localhost:9090/list/create/${id}`,{
        method:`put`,
        headers:{
            "Content-type":"application/json"
        },
        body: JSON.stringify(myObj)
    })
    .then((res)=> res.json())
    .then((data)=>console.info(`Request was all good with json respons $(data)`))
    .catch((err)=> console.error(err));
}

const updateItem =(id, item_name,item_action)=>{

    const myObj = {
        "item_name" : item_name,
        "item_action": item_action,
        
        
    }

    fetch(`http://localhost:9090/item/create/${id}`,{
        method:`put`,
        headers:{
            "Content-type":"application/json"
        },
        body: JSON.stringify(myObj)
    })
    .then((res)=> res.json())
    .then((data)=>console.info(`Request was all good with json respons $(data)`))
    .catch((err)=> console.error(err));
}
