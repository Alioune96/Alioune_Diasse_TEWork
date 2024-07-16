/**
 * Write a function called isAdmitted. It will check entrance
 * scores and return true if the student is admitted and
 * false if rejected. It takes three parameters:
 *
 *     * gpa
 *     * satScore (optional)
 *     * recommendation (optional)
 *
 * Admit them--return true--if:
 * gpa is above 4.0 OR
 * SAT score is above 1300 OR
 * gpa is above 3.0 and they have a recommendation OR
 * SAT score is above 1200 and they have a recommendation
 * OTHERWISE reject it
 *
 * @param {number} gpa the GPA of the student, between 4.2 and 1.0
 * @param {number} [satScore=0] the student's SAT score
 * @param {boolean} [recommendation=false] does the student have a recommendation
 * @returns {boolean} true if they are admitted
 */

    function isAdmitted(gpa, satScore = 0, recommendation = false){
        if(gpa>4.0||satScore>1300||gpa>3.0 && recommendation == true || satScore > 1200 && recommendation== true ){
            return true;
        }
        return false;

    }





/**
 * Write a function called useParameterToFilterArray that accepts a filter function
 * as a parameter. Use this function to filter unfilteredArray and return the result.
 *
 * @param {function} filterFunction the function to filter with
 * @returns {number[]} the filtered array
 */
let unfilteredArray = [1, 2, 3, 4, 5, 6];
function useParameterToFilterArray(filterFunction){


    return unfilteredArray.filter(filterFunction)
}





/**
 * Write a function called makeNumber that takes two strings
 * of digits, concatenates them together, and returns
 * the value as a number.
 *
 * So if two strings are passed in "42293" and "443", then this function
 * returns the number 42293443.
 *
 * @param {string} first the first string of digits to concatenate
 * @param {string} [second=''] the second string of digits to concatenate
 * @returns {number} the resultant number
 */


function makeNumber(first, second = ""){
    let firstOne = `${first}`;
    let secondSe = `${second}`;
    let finished = firstOne+secondSe;
    return Number.parseInt(finished)
}





/**
 * Write a function called addAll that takes an unknown number of parameters
 * and adds all of them together. Return the sum.
 *
 * @param {...number} num a series of numbers to add together
 * @returns {number} the sum of all the parameters (or arguments)
 */


    function addAll(...number){
        let fistONe = 0;
       return number.reduce((n,fistONe)=>{return n+=fistONe},fistONe)
    }




/*
 * Write and document a function called makeHappy that takes
 * an array and prepends 'Happy ' to the beginning of all the
 * words and returns them as a new array. Use the `map` function.
 */

function makeHappy(arrayGuy = []){
    return arrayGuy.map(e=>{return "Happy "+e})
}







/*
 * Write and document a function called getFullAddressesOfProperties
 * that takes an array of JavaScript objects. Each object contains the
 * following keys:
 *     * streetNumber
 *     * streetName
 *     * streetType
 *     * city
 *     * state
 *     * zip
 *
 * getFullAddressesOfProperties returns an array of strings. 
 * Each string is a mailing address generated from the data of a single JavaScript object. 
 * 
 * Each mailing address should have the following format:
 *    
 *  streetNumber streetName streetType city state zip
 *
 * Use `map` and an anonymous function.
 */


function getFullAddressesOfProperties(arrayFunnyMan = []){



    return arrayFunnyMan.map(e=>{return `${e.streetNumber}`+" " + `${e.streetName}` +" "+ `${e.streetType}` +" "+ `${e.city}` +" "+ `${e.state}` +" "+ `${e.zip}`})
}







/** 
 * Write and document a function called findLargest that uses `forEach`
 * to find the largest element in an array.
 * The function must work for strings and numbers.
 * 
 * For strings, "largest" means the word coming last in lexographical order.
 * Lexographic is similar to alphabetical order except that 
 * capital letters come before lowercase letters: 
 * 
 * "cat" < "dog" but "Dog" < "cat"
 *
 * @param {number[]|string[]} searchArray the array to search
 * @returns {number|string} the number or string that is largest
 **/

function findLargest(searchArray){
  let cooked =   searchArray.map(s=>{return `${s}`})


    if(cooked[0].includes("1")||cooked[0].includes("2")||cooked[0].includes("3")||cooked[0].includes("4")||cooked[0].includes("5")||cooked[0].includes("6")||cooked[0].includes("7")||cooked[0].includes("8")||cooked[0].includes("9")){
    
    
    let LArgest =0;
    searchArray.forEach(s=>{if (s > LArgest) LArgest = s})
    
    
return LArgest;
}


 
        let secondLar = ""
       
        james = function(word){
            let number = 0
            switch(word){
                case "A":
                number = 1;
                break;
                case "B":
                number = 2;
                break;
                case "C":
                number = 3;
                break;
                case "D":
                number = 4;
                break;
                case "E":
                number = 5;
                break;
                case "F":
                number = 6;
                break;
                case "G":
                number = 7;
                break;
                case "H":
                number = 8;
                break;
                case "I":
                number = 9;
                break;
                case "J":
                number = 10;
                break;
                case "K":
                number = 11;
                break;
                case "L":
                number = 12;
                break;
                case "M":
                number = 13;
                break;
                case "N":
                number = 14;
                break;
                case "O":
                number = 15;
                break;
                case "P":
                number = 16;
                break;
                case "Q":
                number = 17;
                break;
                case "R":
                number = 18;
                break;
                case "S":
                number = 19;
                break;
                case "T":
                number = 20;
                break;
                case "U":
                number = 21;
                break;
                case "V":
                number = 22;
                break;
                case "W":
                number = 23;
                break;
                case "X":
                number = 24;
                break;
                case "Y":
                number = 25;
                break;
                case "Z":
                number = 26;
                break;
                case "a":
                    number = 27;
                    break;
                    case "b":
                    number = 28;
                    break;
                    case "c":
                    number = 29;
                    break;
                    case "d":
                    number = 30;
                    break;
                    case "e":
                    number = 31;
                    break;
                    case "f":
                    number = 32;
                    break;
                    case "g":
                    number = 33;
                    break;
                    case "h":
                    number = 34;
                    break;
                    case "i":
                    number = 35;
                    break;
                    case "j":
                    number = 36;
                    break;
                    case "k":
                    number = 37;
                    break;
                    case "l":
                    number = 38;
                    break;
                    case "m":
                    number = 39;
                    break;
                    case "n":
                    number = 40;
                    break;
                    case "o":
                    number = 41;
                    break;
                    case "p":
                    number = 42;
                    break;
                    case "q":
                    number = 43;
                    break;
                    case "r":
                    number = 44;
                    break;
                    case "s":
                    number = 45;
                    break;
                    case "t":
                    number = 46;
                    break;
                    case "u":
                    number = 47;
                    break;
                    case "v":
                    number = 48;
                    break;
                    case "w":
                    number = 49;
                    break;
                    case "x":
                    number = 50;
                    break;
                    case "y":
                    number = 51;
                    break;
                    case "z":
                    number = 52;
                    break;
                
            }
            return number;
        }
        
        searchArray.forEach(s => {if (james(s[0])> james(secondLar[0])) secondLar = s })
        return secondLar;
    
}


let number = ["cat","dog","zebra", "fish"]
findLargest(number)






/*
 * CHALLENGE
 * Write and document a function called getSumOfSubArrayValues.
 *
 * Take an array of arrays, adds up all sub values, and returns
 * the sum. For example, if you got this array as a parameter:
 * [
 *   [1, 2, 3],
 *   [2, 4, 6],
 *   [5, 10, 15]
 * ];
 *
 * The function returns 48. To do this, you will use two nested `reduce`
 * calls with two anonymous functions.
 *
 * Read the tests to verify you have the correct behavior.
 */
