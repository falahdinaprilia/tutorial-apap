let demon = {
    name: 'Muzan Kibutsuji',
    age: 1000,
    gender: 'Male'
}
// This object is mutable
// Let's make it immutable
// by make a copy of it
 
function saveDemon(aDemon) {
    let savedDemon = {...aDemon}
    return savedDemon
}
 
let newDemon = saveDemon(demon);
newDemon.name = 'Kokushibo'
 
console.log(newDemon) // name: 'Kokushibo'
console.log(demon) // name: 'Muzan Kibutsuji'
 
let demonList = [
    { id: 1, name: 'Muzan Kibutsuji', age: 1000, status: 'progenitor' },
    { id: 2, name: 'Kokushibo', age: 480, status: 'upper moon' },
    { id: 3, name: 'Doma', age: 20, status: 'upper moon' },
    { id: 4, name: 'Akaza', age: 18, status: 'upper moon' }
]
 
function mapFunction() {
    // This is example of .map()
    let demonIds = demonList.map(demonObj => demonObj.id)
    console.log(demonIds)
}
 
function reduceFunction() {
    // This is example of .reduce()
    let ageTotal = demonList.reduce((acc, demonObj) => acc + demonObj.age, 0)
    console.log(ageTotal)
}
 
function filterFunction() {
    // This is example of .filter()
    let upperMoon = demonList.filter(demonObj => demonObj.status === 'upper moon')
    console.log(upperMoon)
}
 
// Callback function
// This function is called with arguments funct1, funct2, and funct3
function processTheFunction(funct1, funct2, funct3) {
    funct1()
    funct2()
    funct3()
    console.log('---END---')
}
processTheFunction(mapFunction, reduceFunction, filterFunction)
 
