import { EOpponentShape, OpponentShape } from "./OpponentShape";

export class Shape {
    shape: string;
    shapeScore: number;

    constructor(shape: string) {
        this.shape = shape;
        this.shapeScore = this.getShapeScore(shape as EGameShape);
    }

    // getShapeScore(shape: EShape): number {
    //     let score = 0;
    //     switch (shape) {
    //         case EShape.Rock:
    //             score = 1;
    //             break;
    //         case EShape.Paper:
    //             score = 2;
    //             break;
    //         case EShape.Scissors:
    //             score = 3;
    //             break;
    //     }
    //     return score;
    // }

    // getGameScore(opponent: OpponentShape): number {
    //     let score = 0;
    //     switch (opponent.shape) {
    //         case EOpponentShape.Rock:
    //             if (this.shape == EShape.Rock) {
    //                 score += EGameScore.Draw;
    //             } else if (this.shape == EShape.Paper) {
    //                 score += EGameScore.Win;
    //             } else if (this.shape == EShape.Scissors) {
    //                 score += EGameScore.Lose;
    //             }
    //             break;
    //         case EOpponentShape.Paper:
    //             if (this.shape == EShape.Rock) {
    //                 score += EGameScore.Lose;
    //             } else if (this.shape == EShape.Paper) {
    //                 score += EGameScore.Draw;
    //             } else if (this.shape == EShape.Scissors) {
    //                 score += EGameScore.Win;
    //             }
    //             break;
    //         case EOpponentShape.Scissors:
    //             if (this.shape == EShape.Rock) {
    //                 score += EGameScore.Win;
    //             } else if (this.shape == EShape.Paper) {
    //                 score += EGameScore.Lose;
    //             } else if (this.shape == EShape.Scissors) {
    //                 score += EGameScore.Draw;
    //             }
    //             break;
    //         default:
    //             break;
    //     }
    //     return score;
    // }
    getShapeScore(shape: EGameShape): number {
        let score = 0;
        switch (shape) {
            case EGameShape.Lose:
                score = EGameScore.Lose;
                break;
            case EGameShape.Draw:
                score = EGameScore.Draw;
                break;
            case EGameShape.Win:
                score = EGameScore.Win;
                break;
        }
        return score;
    }

    getGameScore(opponent: OpponentShape): number {
        let score = 0;
        switch (opponent.shape) {
            case EOpponentShape.Rock:
                if (this.shape == EGameShape.Lose) {
                    score += EShapeScore.Scissors;
                } else if (this.shape == EGameShape.Draw) {
                    score += EShapeScore.Rock;
                } else if (this.shape == EGameShape.Win) {
                    score += EShapeScore.Paper;
                }
                break;
            case EOpponentShape.Paper:
                if (this.shape == EGameShape.Lose) {
                    score += EShapeScore.Rock;
                } else if (this.shape == EGameShape.Draw) {
                    score += EShapeScore.Paper;
                } else if (this.shape == EGameShape.Win) {
                    score += EShapeScore.Scissors;
                }
                break;
            case EOpponentShape.Scissors:
                if (this.shape == EGameShape.Lose) {
                    score += EShapeScore.Paper;
                } else if (this.shape == EGameShape.Draw) {
                    score += EShapeScore.Scissors;
                } else if (this.shape == EGameShape.Win) {
                    score += EShapeScore.Rock;
                }
                break;
            default:
                break;
        }
        return score;
    }

}

// export enum EShape {
//     Rock = 'X',
//     Paper = 'Y',
//     Scissors = 'Z'
// }

export enum EShapeScore {
    Rock = 1,
    Paper = 2,
    Scissors = 3
}

export enum EGameShape {
    Lose = 'X',
    Draw = 'Y',
    Win = 'Z'
}

export enum EGameScore {
    Lose = 0,
    Draw = 3,
    Win = 6
}