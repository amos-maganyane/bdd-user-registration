const jsonServer = require('json-server')
const server = jsonServer.create()
const router = jsonServer.router('db.json')

const middlewares = jsonServer.defaults()
server.use(middlewares)
server.use(jsonServer.bodyParser)

server.post('/register' , (request, response) => {
    const {name, password} = request.body

    if (!name){
        return response.status(400).jsonp({error: "Missing name"})
    }

    if (!password || password.length < 6 ){
        return response.status(400).jsonp({error: "Password too short"})
    }

    const user = {id: Date.now(), name, password}

    router.db.get('users').push(user).write()

    response.status(201).jsonp({id : user.id })
})

server.use(router)
server.listen(5000, ()=>{
    console.log('JSON Server is running on http://localhost:5000')
})