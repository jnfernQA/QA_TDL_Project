const getData =()=>{
    fetch(`http://localhost:9092/list/read`)
    .then((response)=>{
        if (response.status !== 200){
            console.error(`status ${response.status}`);
            return;
        }
        response.json().then((data)=>console.info(data));
    })
    .catch((err)=>console.error(err))

}

const getOne =()=>{
    fetch(`http://localhost:9092/list/read/1`)
    .then((response)=>{
        if (response.status !== 200){
            console.error(`status ${response.status}`);
            return;
        }
        response.json().then((data)=>console.info(data));
    })
    .catch((err)=>console.error(err))

}

const create =()=>{

    const myObj = {
        "name": "Shanghai"
    }

    fetch(`http://localhost:9092/list/create`,{
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