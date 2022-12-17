export class OpponentShape {
    shape: string;

    constructor(shape: string) {
        this.shape = shape;
    }
}

export enum EOpponentShape {
    Rock = 'A',
    Paper = 'B',
    Scissors = 'C'
}