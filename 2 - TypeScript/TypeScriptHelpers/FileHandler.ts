import * as fs from 'fs';

export class FileHandler {
    static getStringArray(path: string) : string[] {
        try {
            const input = fs.readFileSync(path, 'utf-8');
            const arr = input.split('\n');
            return arr
        } catch (error) {
            console.error('File not found.', error);
        }
        return [];
    }
}