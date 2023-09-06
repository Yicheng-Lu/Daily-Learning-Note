let maxNum = parseInt(prompt("Enter the maximum number!"));
while (!maxNum) {
    maxNum = parseInt(prompt("Enter a valid number!"));
}
const targetNum = Math.floor(Math.random() * maxNum) + 1;
for (let i = 0; i < 5; i++) {
    let guessNum = prompt("")
}