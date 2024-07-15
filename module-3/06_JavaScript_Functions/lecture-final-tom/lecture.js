/**
 * All named functions will have the function keyword and
 * a name followed by parentheses.
 * 
 * @returns {number} 1
 */
function returnOne() {
  return 1;
}

/**
 * Functions can also take parameters. These are just variables that are filled
 * in by whomever is calling the function.
 *
 * Also, we don't *have* to return anything from the actual function.
 *
 * @param {any} value the value to print to the console
 */
function printToConsole(value) {
  console.log(value);
}

/**
 * Write a function called multiplyTogether that multiplies two numbers together. But 
 * what happens if we don't pass a value in? What happens if the value is not a number?
 *
 * @param {number} firstParameter the first parameter to multiply
 * @param {number} secondParameter the second parameter to multiply
 * @returns {number} the product of the multiplication
 */

function multiplyTogether(firstParameter, secondParameter) {
  return firstParameter * secondParameter;
}


/**
 * This version makes sure that no parameters are ever missing. If
 * someone calls this function without parameters, we default the
 * values to 0. However, it is impossible in JavaScript to prevent
 * someone from calling this function with data that is not a number.
 * Call this function multiplyNoUndefined
 *
 * @param {number} [firstParameter=0] the first parameter to multiply
 * @param {number} [secondParameter=0] the second parameter to multiply
 * @returns {number} the product of the multiplication
 */
function multiplyNoUndefined(firstParameter = 0, secondParameter = 0) {
  return firstParameter * secondParameter;
}

//                     ... "spread syntax"
function multiplyAllNumbers(...numbers) {

  let product = 1;
  for (let i = 0; i < numbers.length; i++) {
    product *= numbers[i];
  }

  return product;
}

function multiplyOldSchool() {
  let product = 1;
  for (let i = 0; i < arguments.length; i++) {
    product *= arguments[i];
  }

  return product;
}

 
/**
 * Functions can return earlier before the end of the function. This could be useful
 * in circumstances where you may not need to perform additional instructions or have to
 * handle a particular situation.
 * In this example, if the firstParameter is equal to 0, we return secondParameter times 2.
 * Observe what's printed to the console in both situations.
 * 
 * @param {number} firstParameter the first parameter
 * @param {number} secondParameter the second parameter
 * @returns {number} the result of the chosen arithmetic operation
 */
function returnBeforeEnd(firstParameter, secondParameter) {
  console.log("This will always fire.");

  if (firstParameter == 0) {
    console.log("Returning secondParameter times two.");
    return secondParameter * 2;
  }

  //this only runs if firstParameter is NOT 0
  console.log("Returning firstParameter + secondParameter.");
  return firstParameter + secondParameter;
}

/**
 * Scope is defined as where a variable is available to be used.
 *
 * If a variable is declare inside of a block, it will only exist in
 * that block and any block underneath it. Once the block that the
 * variable was defined in ends, the variable disappears.
 */
function scopeTest() {
  // This variable will always be in scope in this function
  let inScopeInScopeTest = true;

  {
    // this variable lives inside this block and doesn't
    // exist outside of the block
    const scopedToBlock = inScopeInScopeTest;
  }

  // scopedToBlock doesn't exist here so an error will be thrown
  if (inScopeInScopeTest && scopedToBlock) {
    console.log("This won't print!");
  }
}

function createSentenceFromUser(name, age, listOfQuirks = [], separator = ", ") {
  const description = `${name} is currently ${age} years old. Their quirks are: `; // String interpolation
  return description + listOfQuirks.join(separator);
}

/**
 * Takes an array and, using the power of anonymous functions, generates
 * their sum.
 *
 * @param {number[]} numbersToSum numbers to add up
 * @returns {number} sum of all the numbers
 */
function sumAllNumbers(numbersToSum) {
  console.log(numbersToSum);
  const seedValue = 0;

  const finalAnswer = numbersToSum.reduce((accumulator, element) => {
    console.log(`Accumulator: ${accumulator}\t\tElement: ${element}`);
    return accumulator + element;
  }, seedValue);

  console.log("Final Answer: " + finalAnswer);
  return finalAnswer;
}

function reduceExamples() {
  const arr = [99, 88, 77, 66, 55];
  console.table(arr);

  const sum = arr.reduce((accumulator, element) => {
    return accumulator + element;
  }, 0);
  console.log("sum: " + sum);

  const avg = sum / arr.length;
  console.log("avg: " + avg);

  // MAX
  const max = arr.reduce((accumulator, element) => {
    if (element > accumulator) {
      return element;
    }

    return accumulator;
  }, -999999);
  console.log("Max: " + max);

  // MIN
  const min = arr.reduce((acc, elm) => {
    if (elm < acc) {
      return elm;
    }
    return acc;
  }, 999999);
  console.log("Min: " + min);


}

/**
 * Takes an array and returns a new array of only numbers that are
 * multiples of 3
 *
 * @param {number[]} numbersToFilter numbers to filter through
 * @returns {number[]} a new array with only those numbers that are
 *   multiples of 3
 */
function allDivisibleByThree(numbersToFilter = []) {

  // const result = [];

  // for (let i = 0; i < numbersToFilter.length; i++) {
  //   const element = numbersToFilter[i];

  //   if (element % 3 === 0) {
  //     result.push(element);
  //   }
  // }

  // long form:
  // numbersToFilter.forEach( function (element) { 
  //   if (element % 3 === 0) {
  //     result.push(element);
  //   }
  // });

  // numbersToFilter.forEach(e => { 
  //   if (e % 3 === 0) {
  //     result.push(e);
  //   }
  // });

  return numbersToFilter.filter(e => e % 3 === 0);

}

// arr.forEach(function (e, i) { console.log("forEach is calling this function and passing in: " + e + ", which is index: " + i);  });
