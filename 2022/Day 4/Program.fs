open System.IO

let filePath = @"C:\workspace\advent-of-code\2022\Day 4\input.txt"
let readLines = File.ReadAllLines(filePath)
let list = Seq.toList readLines

let getNumberArray (maxMin: string[]) =
    [| for i in int (maxMin[0]) .. int (maxMin[1]) -> i |]

let getStringOfNumbers (maxMin: string[]) =
    let numberArr = getNumberArray maxMin
    let numberString = numberArr |> Array.map string |> String.concat " "
    " " + numberString + " "

let mutable fullyContainsCounter = 0

for pair in list do
    let mutable sections = pair.Split [| ',' |]
    sections[0] <- sections[ 0 ].Split [| '-' |] |> getStringOfNumbers
    sections[1] <- sections[ 1 ].Split [| '-' |] |> getStringOfNumbers
    sections <- Array.sortByDescending (fun s -> s.Length) sections

    if (sections[ 0 ].Contains(sections[1])) then
        fullyContainsCounter <- fullyContainsCounter + 1

printfn "Number of assignment pairs fully containing the other is %i" fullyContainsCounter

let mutable overlayCounter = 0

for pair in list do
    let sections = pair.Split [| ',' |]
    let section1 = sections[ 0 ].Split [| '-' |] |> getNumberArray
    let section2 = sections[ 1 ].Split [| '-' |] |> getNumberArray

    let mutable overlayFound = false

    for id in section1 do
        if (section2 |> Array.exists (fun element -> element = id)) && (not overlayFound) then
            overlayCounter <- overlayCounter + 1
            overlayFound <- true

printfn "Number of overlayed pairs is %i" overlayCounter
