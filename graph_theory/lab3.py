

def main():
    n = int(input("Enter the nr. of nodes: "))
    visited = [0] * 10  # muchii vizitate=1

    cost_matrix = [[0 for x in range(n)] for y in range(n)]
    cost_matrix[0][1] = cost_matrix[1][0] = 3
    cost_matrix[0][3] = cost_matrix[3][0] = 6
    cost_matrix[0][2] = cost_matrix[2][0] = 1
    cost_matrix[1][2] = cost_matrix[2][1] = 5
    cost_matrix[1][4] = cost_matrix[4][1] = 3
    cost_matrix[2][4] = cost_matrix[4][2] = 6
    cost_matrix[2][5] = cost_matrix[5][2] = 4
    cost_matrix[4][5] = cost_matrix[5][4] = 6
    cost_matrix[2][3] = cost_matrix[3][2] = 5
    cost_matrix[3][5] = cost_matrix[5][3] = 2

    for elem in cost_matrix:
        print(elem)

    nr_edge=1 #nr muchiei
    for i in range(0, n):
        for j in range(0, n):
            if cost_matrix[i][j] == 0:
                cost_matrix[i][j] = 999
    visited[0] = 1
    for elem in cost_matrix:
        print(elem)
    mincost = 0

    while(nr_edge<n):

        min=800
        mincost = 0
        a = 0
        b = 0
        u = 0
        v = 0

        for i in range(0,n):
            if min==999:
                break
            for j in range(0,n):

                if cost_matrix[i][j]<min:

                    if visited[i] != 0:
                        min=cost_matrix[i][j]
                        a=u=i
                        #u=i
                        b=v=j

                        #v=j



            if visited[u]==0 or visited[v]==0:
                print("\n" + "Edge "+ str(nr_edge) + ' ' + str(a)+ '-' + str(b) + ': ' + str(min))

                nr_edge+=1
                print("min: "+str(min))
                mincost += min
                print("mincost: " + str(mincost))
                visited[b]=1

            cost_matrix[a][b]=cost_matrix[b][a]=999


    print("Minimum cost = " + str(mincost))

main()