
const givenId = document.querySelector("#ListId")
const givenListName = document.querySelector("#name")


const updateList =()=>{
    const id = givenId.value
    const name = givenListName.value
    fetch(`http://localhost:9090/list/create/`+id,{
        method:`put`,
        headers:{
            "Content-type":"application/json"
        },
        body: JSON.stringify({
            "name": name
        })
    })
    .then((res)=> res.json())
    .then((data)=>console.info(`Request was all good with json respons $(data)`))
    .catch((err)=> console.error(err));
}

const givenItemId = document.querySelector("#ItemId")
const givenItemName = document.querySelector("#item_name")
const givenItemAction = document.querySelector("#item_action")


const updateItem =()=>{
    const id = givenItemId.value
    const item_name = givenItemName.value
    const item_action = givenItemAction.value
    fetch("http://localhost:9090/item/create/"+id,{
        method:`put`,
        headers:{
            "Content-type":"application/json"
        },
        body: JSON.stringify({
            "item_name": item_name,
            "item_action": item_action
        })
    })
    .then((res)=> res.json())
    .then((data)=>console.info(`Request was all good with json respons $(data)`))
    .catch((err)=> console.error(err));
}