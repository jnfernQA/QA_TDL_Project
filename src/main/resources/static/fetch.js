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

const createList =(name)=>{

    const myObj = {
        "name": name

    }

    fetch(`http://localhost:9090/list/create/${name}`,{
         method:`post`,
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(myObj),
    })
    .then(res => res.json())
    .then((data) => console.log(`Request succeeded with JSON response ${data}`))
    .catch((err) => console.log(err))
}

const createItem =(itemName, itemAction, listId)=>{

    const myObj = {
        "item_name" : itemName,
        "item_action" : itemAction,
        "listName" :{
            "id" : id
        }
    }
    fetch(`http://localhost:9090/item/create/${itemName, itemAction, listId}`,{
        method:`post`,
        headers:{
            "Content-type":"application/json"
        },
        body:JSON.stringify(myObj),
    })
    .then(res => res.json())
    .then((data) => console.log(`Request succeeded with JSON response ${data}`))
    .catch((err) => console.log(err))
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

const update=(id,name)=>{

    const myObj = {
        "name" : name
    }

    fetch(`http://localhost:9090/list/update/${id}`,{
        method:`PUT`,
        headers:{
            "Content-type":"application/json"
        },
        body: JSON.stringify(myObj)
    })
    .then((res)=> res.json())
    .then((data)=>console.info(`Request was all good with json respons $(data)`))
    .catch((err)=> console.error(err));
}