
// 1. **sumDouble** Given two int values, return their sum. Unless the two values are the 
//     same, then return double their sum.

		// sumDouble(1, 2) → 3
		// sumDouble(3, 2) → 5
		// sumDouble(2, 2) → 8

		function sumDouble(x, y) {
			if(x==y){
				return (x+y)*2
			}

			// do logic here
			// return result;
			return x + y;
        }


/*
2. **hasTeen** We'll say that a number is "teen" if it is in the range 13..19 inclusive. 
    Given 3 int values, return true if 1 or more of them are teen.

		hasTeen(13, 20, 10) → true
		hasTeen(20, 19, 10) → true
		hasTeen(20, 10, 13) → true
*/


function hasTeen(parameter, parametertwo, parameterthree){
	if(parameter>=13||parametertwo>=13||parameterthree>=13){
		return true;
	}


return false;
}


/* 
3. **lastDigit** Given two non-negative int values, return true if they have the same 
    last digit, such as with 27 and 57.

		lastDigit(7, 17) → true
		lastDigit(6, 17) → false
		lastDigit(3, 113) → true

/*
*/
	function lastDigit(int, intwo){
		let numberKid = `${int}`;
		let numberGrow = `${intwo}`

		if(numberKid==numberGrow){
			return true;
		}

		if(numberKid>=10){
			if(numberKid.substring(numberKid.length-1) == numberGrow){
				return true
			}
		}

		if(numberGrow>=10){
			if(numberGrow.substring(numberGrow.length-1)== numberKid){
				return true;
			}
		}

		if(numberKid>=10&&numberGrow>=10){
			if(numberKid.substring(numberKid.length-1)==numberGrow.substring(numberGrow.length-1)){
				return true
			}
		}

		return false;
	}




// 4. **seeColor** Given a string, if the string begins with "red" or "blue" return that color 
//     string, otherwise return the empty string.

// 		seeColor("redxx") → "red"
// 		seeColor("xxred") → ""
//         seeColor("blueTimes") → "blue"
// */


function seeColor(parameter){
	let here = `${parameter}`;
	if(here.substring(0,3)=="red"){
		return "red";
	}
	if(here.substring(0,4)=="blue"){
		return "blue";
	}


	
	return ""


}



/*
5. **oddOnly** Write a function that given an array of integer of any length, removes
    the even numbers, and returns a new array of just the the odd numbers.

		oddOnly([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]) → [1, 3, 5, 7, 9, 11];
		oddOnly([2, 4, 8, 32, 256]); → []
*/


 function oddOnly(james){
	let oneOne = [];

	for(let i = 0; i < james.length; i++){
		if(james[i]%2=="1"){
			oneOne.push(james[i])
		}
	}
	return oneOne;
 }

	
// }



/*
6. **frontAgain** Given a string, return true if the first 2 chars in the string also appear 
    at the end of the string, such as with "edited".

		frontAgain("edited") → true
		frontAgain("edit") → false
		frontAgain("ed") → true
*/


function frontAgain(parameter){
	let parseGut = `${parameter}`;
	if(parseGut.substring(0,2)=="ed"&&parseGut.substring(parseGut.length-2)=="ed"){
		return true;
	}else if(parseGut.length==2){
		return true;
	}
	return false;
}


/*
7. **cigarParty** When squirrels get together for a party, they like to have cigars. 
A squirrel party is successful when the number of cigars is between 40 and 60, inclusive. 
Unless it is the weekend, in which case there is no upper bound on the number of cigars. 
Write a squirrel party function that return true if the party with the given values is successful, 
or false otherwise.

		cigarParty(30, false) → false
		cigarParty(50, false) → true
		cigarParty(70, true) → true
*/


function cigarParty(number, boolean){

	let numberOne = `${number}`
	let booleanOne = `${boolean}`

	 if (booleanOne=="true"){
		return true;
	}else if(numberOne>=40 && numberOne<=60){
		return true;
	}else


return false;
}

/*
8. **fizzBuzz** Given a number, return a value according to the following rules:
If the number is multiple of 3, return "Fizz."
If the number is a multiple of 5, return "Buzz." 
If the number is a multiple of both 3 and 5, return "FizzBuzz."
In all other cases return the original number. 

	fizzBuzz(3) → "Fizz"
	fizzBuzz(1) → 1
	fizzBuzz(10) → "Buzz"
	fizzBuzz(15) → "FizzBuzz"
	fizzBuzz(8) → 8
*/



function fizzBuzz(number){
	let GreatNumber = `${number}`;
	if(GreatNumber%"3"== "0" && GreatNumber% "5"== "0"){
		return "FizzBuzz";
	}
	if(GreatNumber%"5"=="0"){
		return "Buzz";
	}
	if(GreatNumber%"3"=="0"){
		return "Fizz";
	}
	

	return number;
}



/*
9. **filterEvens** Write a function that filters an array to only include even numbers.

	filterEvens([]) → []
	filterEvens([1, 3, 5]) → []
	filterEvens([2, 4, 6]) → [2, 4, 6]
	filterEvens([100, 8, 21, 24, 62, 9, 7]) → [100, 8, 24, 62]
*/

function filterEvens(OneKind){
	let youareMyFriend = [];
	for(let i = 0; i< OneKind.length; i++){
		if(OneKind[i]%2==0){
			youareMyFriend.push(OneKind[i])
		}
	}
	return youareMyFriend;
}



/*
10. **filterBigNumbers** Write a function that filters numbers greater than or equal to 100.

	filterBigNumbers([7, 10, 121, 100, 24, 162, 200]) → [121, 100, 162, 200]
	filterBigNumbers([3, 2, 7, 1, -100, -120]) → []
	filterBigNumbers([]) → []
*/


function filterBigNumbers(Sasuke){
	let naruto= [];
	for(let i = 0; i <Sasuke.length; i++){
		if(Sasuke[i]>=100){
			naruto.push(Sasuke[i])
		}
	}
return naruto;
}

/*
11. **filterMultiplesOfX** Write a function to filter numbers that are a multiple of a 
parameter, `x` passed in.

	filterMultiplesOfX([3, 5, 1, 9, 18, 21, 42, 67], 3) → [3, 9, 18, 21, 42]
	filterMultiplesOfX([3, 5, 10, 20, 18, 21, 42, 67], 5) → [5, 10, 20]
*/

function filterMultiplesOfX(args, yourAreMyDream){
	let distance = [];
	for(let i = 0; i < args.length; i++){
		if(args[i]%yourAreMyDream==0){
			distance.push(args[i])
		}
	}
	return distance;
}






/*
12. **createObject** Write a function that creates an object with a property called 
firstName, lastName, and age. Populate the properties with your values.

	createObject() →

	{
		firstName,
		lastName,
		age
	}
*/


function createObject(){
	let jamesBrown = {
		firstName: "alioune",
		lastName: "diasse", 
		age: 27
	}

	return jamesBrown;
}
