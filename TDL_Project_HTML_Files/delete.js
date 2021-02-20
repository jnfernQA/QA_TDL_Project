'use strict'
const givenId = document.querySelector("#ListId")
const deleteById =()=>{
  const id = givenId.value

  fetch(`http://localhost:9090/list/delete/`+ id,{
       method:`delete`,
      headers: {
          "Content-type": "application/json"
      },
  })
  .then(res => res.json())
  .then((data) => console.log(`Request succeeded with JSON response ${data}`))
  .catch((err) => console.log(err))
}

const givenItemId = document.querySelector("#ItemId")
const deleteItemById =()=>{
  const id = givenItemId.value

  fetch(`http://localhost:9090/item/delete/`+ id,{
       method:`delete`,
      headers: {
          "Content-type": "application/json"
      },
  })
  .then(res => res.json())
  .then((data) => console.log(`Request succeeded with JSON response ${data}`))
  .catch((err) => console.log(err))
}