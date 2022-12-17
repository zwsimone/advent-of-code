import { FileHandler } from "../../TypeScriptHelpers/FileHandler";
import { OpponentShape } from "./OpponentShape";
import { Shape } from "./Shape";

const arr = FileHandler.getStringArray("input.txt");

let score : number = 0;

for (let i = 0; i < arr.length; i++) {
    score = score + getScore(arr[i]);
}

console.log('Total score is ' + score);

function getScore(round: string): number {
    const roundArr = round.split(' ');
    const opponent = new OpponentShape(roundArr[0]);
    const yourself = new Shape(roundArr[1]);

    let score : number = yourself.shapeScore;
    score += yourself.getGameScore(opponent);

    return score;
}

