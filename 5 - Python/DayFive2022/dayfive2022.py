import copy

with open('.\DayFive2022\input') as input_data:
    input_data = [line for line in input_data.readlines()]

stacks = []
for line_index in reversed(range(8)):
    line = input_data[line_index]
    lineArr = [line[i:4+i] for i in range(0, len(line), 4)]
    for stack_index in range(len(lineArr)):
        crate = lineArr[stack_index]
        if (crate != '    ') and (crate != '   \n'):
            stack = []
            if len(stacks) == 9:
                stack = stacks[stack_index]            
                stack.append(lineArr[stack_index])
                stacks[stack_index] = stack
            else:
                stack.append(lineArr[stack_index])
                stacks.append(stack)

part_1 = copy.deepcopy(stacks)
for input_index in range(10, len(input_data)):
    arr = input_data[input_index].split()
    crates_to_move = int(arr[1])
    from_stack = int(arr[3])-1
    to_stack = int(arr[5])-1

    for crate in range(crates_to_move):
        part_1[to_stack].append(part_1[from_stack].pop())

output = ""
for stack in part_1:
    # print(stack[len(stack)-1])
    output += stack[len(stack)-1].strip().replace('[','').replace(']','')

print(output)

part_2 = copy.deepcopy(stacks)
for input_index in range(10, len(input_data)):
    arr = input_data[input_index].split()
    crates_to_move = int(arr[1])
    from_stack = part_2[int(arr[3])-1]
    to_stack = part_2[int(arr[5])-1]

    moving_stack = from_stack[(len(from_stack)-crates_to_move):]
    for crate in moving_stack:
        part_2[int(arr[5])-1].append(crate)
    part_2[int(arr[3])-1] = from_stack[0:(len(from_stack)-crates_to_move)]
    
output = ""
for stack in part_2:
    # print(stack[len(stack)-1])
    output += stack[len(stack)-1].strip().replace('[','').replace(']','')

print(output)