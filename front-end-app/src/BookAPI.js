const api = "http://localhost:8080/FullStackProject"
// Generate a unique token for storing your bookshelf data on the backend server.
let token = localStorage.token
if (!token)
  token = localStorage.token = Math.random().toString(36).substr(-8)

const headers = {
  'Accept': 'application/json'
}

export const get = (title) =>
  fetch(`${api}/books/${title}`, { headers })
    .then(res => {console.log(res); return res.json(); })
   

    export const getAll = () =>
    fetch(`${api}/books`, {headers })
      .then(res => res.json())

export const update = (book, shelf) =>
  fetch(`${api}/books/${book.id}`, {
    method: 'PUT',
    headers: {
      ...headers,
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({ shelf })
  }).then(res => res.json())
 
  export const insert = (shelf) =>
  fetch(`${api}/users`, {
    method: 'POST',
    headers: {
      ...headers,
      'Content-Type': 'application/json'
    },
    body: JSON.stringify( shelf )
  }).catch(error => error).then(res => res.json())

  export const insertBook = (shelf) =>
  fetch(`${api}/books`, {
    method: 'POST',
    headers: {
      ...headers,
      'Content-Type': 'application/json'
    },
    body: JSON.stringify( shelf )
  }).then(res => res.json())

export const del = (title) =>
  fetch(`${api}/books/${title}`, {
    method: 'DELETE',
    headers:{
      ...headers,
      'Content-Type': 'application/json'
    }
  })
  export const delFav = (bookID) =>
  fetch(`${api}/favorites/${bookID}`, {
    method: 'DELETE',
    headers:{
      ...headers,
      'Content-Type': 'application/json'
    }
  })
  export const delBookInfo = (bookID) =>
  fetch(`${api}/bookinfos/${bookID}`, {
    method: 'DELETE',
    headers:{
      ...headers,
      'Content-Type': 'application/json'
    }
  })
