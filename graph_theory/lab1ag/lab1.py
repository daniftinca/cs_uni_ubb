matrix = [[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0]]
way = [0,0,0,0,0,0,0,0,0]
counter =0
nr=0

def backtracking(node):
    global counter
    global nr
    way[counter] = node #way va contine nodurile bune
    counter+=1
    if(counter == 9):
        for elem in way: #way[0:9]
            print(elem)
        nr+=1
        print(": Possibility number "+str(nr)+'\n')
        counter-=1
        return

    for i in range(0,5):
        if(matrix[node][i]==1):
            matrix[node][i]=matrix[i][node] = 0
            backtracking(i)
            matrix[node][i] = matrix[i][node] = 1
    counter-=1

def main():
    matrix[0][1] = matrix[1][0] = 1
    matrix[0][2] = matrix[2][0] = 1
    matrix[0][4] = matrix[4][0] = 1
    matrix[2][3] = matrix[3][2] = 1
    matrix[1][2] = matrix[2][1] = 1
    matrix[1][4] = matrix[4][1] = 1
    matrix[2][4] = matrix[4][2] = 1
    matrix[3][4] = matrix[4][3] = 1
    backtracking(0)
    return


main()